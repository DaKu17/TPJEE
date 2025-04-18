package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactFacade {
    private Connection connection;

    public ContactFacade() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gestion_contacts",
                "root", // ou ton user
                ""      // ton mot de passe
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM Contact";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("ID_CONTACT"));
                contact.setFirstName(rs.getString("FIRSTNAME"));
                contact.setLastName(rs.getString("LASTNAME"));
                contact.setEmail(rs.getString("EMAIL"));
                contact.setPhone(rs.getString("PHONE"));
                contact.setAddress(rs.getString("ADDRESS"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void addContact(Contact contact) {
        String query = "INSERT INTO Contact (FIRSTNAME, LASTNAME, EMAIL, PHONE, ADDRESS) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, contact.getFirstName());
            stmt.setString(2, contact.getLastName());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getPhone());
            stmt.setString(5, contact.getAddress());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(int id) {
        String query = "DELETE FROM Contact WHERE ID_CONTACT = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

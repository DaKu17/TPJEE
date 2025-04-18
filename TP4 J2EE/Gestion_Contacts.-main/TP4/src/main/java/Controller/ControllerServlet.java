package Controller;

import model.Contact;
import model.ContactFacade;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ControllerServlet") 
public class ControllerServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContactFacade contactFacade;

    public void init() {
        contactFacade = new ContactFacade();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("do_this");
        if ("list".equals(action)) {
            List<Contact> contacts = contactFacade.findAll();
            request.setAttribute("listContacts", contacts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("accueil.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("do_this");
        if ("create".equals(action)) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            Contact contact = new Contact();
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setEmail(email);
            contact.setPhone(phone);
            contact.setAddress(address);

            contactFacade.addContact(contact);

            response.sendRedirect("ControllerServlet?do_this=list");
        }
    }
}

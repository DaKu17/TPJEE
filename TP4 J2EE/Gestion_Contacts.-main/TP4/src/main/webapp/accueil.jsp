<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
    <h1>Liste des Contacts</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Email</th>
            <th>Téléphone</th>
            <th>Adresse</th>
        </tr>
        <c:forEach var="contact" items="${requestScope.listContacts}">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                <td>${contact.email}</td>
                <td>${contact.phone}</td>
                <td>${contact.address}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="addContact.jsp">Créer un nouveau contact</a>
</body>
</html>

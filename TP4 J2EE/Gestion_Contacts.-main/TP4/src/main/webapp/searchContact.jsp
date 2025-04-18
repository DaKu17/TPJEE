<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rechercher un Contact</title>
</head>
<body>

<h2>Rechercher un Contact</h2>

<!-- Formulaire de recherche -->
<form action="ControllerServlet" method="POST">
    <!-- Paramètre caché pour spécifier l'action -->
    <input type="hidden" name="do_this" value="search"/>

    <label for="searchCriteria">Rechercher par :</label>
    <select id="searchCriteria" name="searchCriteria">
        <option value="firstName">Prénom</option>
        <option value="lastName">Nom</option>
        <option value="email">Email</option>
    </select>
    <br><br>

    <label for="searchValue">Valeur :</label>
    <input type="text" id="searchValue" name="searchValue" required />
    <br><br>

    <input type="submit" value="Rechercher" />
</form>

<!-- Affichage des résultats de la recherche -->
<c:if test="${not empty requestScope.searchResults}">
    <h3>Résultats de la recherche :</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Prénom</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Téléphone</th>
            <th>Adresse</th>
        </tr>
        <c:forEach items="${requestScope.searchResults}" var="contact">
            <tr>
                <td>${contact.idContact}</td>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                <td>${contact.email}</td>
                <td>${contact.phone}</td>
                <td>${contact.address}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

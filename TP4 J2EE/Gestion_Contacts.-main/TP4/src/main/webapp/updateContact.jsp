<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un Contact</title>
</head>
<body>

<h2>Modifier un Contact</h2>

<!-- Formulaire pour la modification d'un contact -->
<form action="ControllerServlet" method="POST">
    <!-- Paramètre caché pour spécifier l'action -->
    <input type="hidden" name="do_this" value="update"/>

    <!-- Champ pour l'ID du contact (invisible pour l'utilisateur, utilisé par la Servlet) -->
    <input type="hidden" name="idContact" value="${contact.idContact}"/>

    <label for="firstName">Prénom :</label>
    <input type="text" id="firstName" name="firstName" value="${contact.firstName}" required />
    <br><br>

    <label for="lastName">Nom :</label>
    <input type="text" id="lastName" name="lastName" value="${contact.lastName}" required />
    <br><br>

    <label for="email">Email :</label>
    <input type="email" id="email" name="email" value="${contact.email}" required />
    <br><br>

    <label for="phone">Téléphone :</label>
    <input type="text" id="phone" name="phone" value="${contact.phone}" />
    <br><br>

    <label for="address">Adresse :</label>
    <input type="text" id="address" name="address" value="${contact.address}" />
    <br><br>

    <input type="submit" value="Mettre à jour le Contact" />
</form>

</body>
</html>

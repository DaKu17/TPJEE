<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Contact</title>
</head>
<body>
    <h1>Ajouter un nouveau Contact</h1>
    <form action="ControllerServlet" method="POST">
        <input type="hidden" name="do_this" value="create"/>
        <table>
            <tr><td>Prénom</td><td><input type="text" name="firstName" /></td></tr>
            <tr><td>Nom</td><td><input type="text" name="lastName" /></td></tr>
            <tr><td>Email</td><td><input type="text" name="email" /></td></tr>
            <tr><td>Téléphone</td><td><input type="text" name="phone" /></td></tr>
            <tr><td>Adresse</td><td><input type="text" name="address" /></td></tr>
            <tr><td colspan="2"><input type="submit" value="Ajouter"/></td></tr>
        </table>
    </form>
</body>
</html>

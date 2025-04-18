<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Supprimer un Contact</title>
</head>
<body>

<h2>Supprimer un Contact</h2>

<form action="ControllerServlet" method="POST">
    <!-- Paramètre caché pour spécifier l'action -->
    <input type="hidden" name="do_this" value="delete"/>
    
    <label for="idContact">Entrez l'ID du contact à supprimer :</label>
    <input type="text" id="idContact" name="idContact" required />
    
    <br><br>
    
    <input type="submit" value="Supprimer le Contact" />
</form>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat IMC</title>
</head>
<body>
    <h2>Votre IMC est : <%= request.getAttribute("imc") %></h2>

    
    <form action="TableauBord" method="GET">
        <input type="submit" value="Voir le Tableau de Bord">
    </form>
</body>
</html>

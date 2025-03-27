<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tableau de Bord</title>
</head>
<body>
    <h2>Tableau de Bord</h2>

    <h3>Données depuis la Session :</h3>
    <p>Poids : <%= session.getAttribute("poids") %> kg</p>
    <p>Taille : <%= session.getAttribute("taille") %> m</p>
    <p>IMC : <%= session.getAttribute("imc") %></p>

    <h3>Données depuis les Cookies :</h3>
    <%
        Cookie[] cookies = request.getCookies();
        String poidsCookie = "Non trouvé", tailleCookie = "Non trouvé";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("poids".equals(c.getName())) poidsCookie = c.getValue();
                if ("taille".equals(c.getName())) tailleCookie = c.getValue();
            }
        }
    %>
    <p>Poids (Cookie) : <%= poidsCookie %> kg</p>
    <p>Taille (Cookie) : <%= tailleCookie %> m</p>

    <!-- 🔹 Bouton retour -->
    <form action="renseignement.html" method="GET">
        <input type="submit" value="Retour au formulaire">
    </form>
</body>
</html>

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculMonImc")
public class CalculMonImc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CalculMonImc() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double poids = Double.parseDouble(request.getParameter("poids"));
        double taille = Double.parseDouble(request.getParameter("taille"));
        double imc = poids / (taille * taille);

        // Store data in cookies
        Cookie poidsCookie = new Cookie("poids", String.valueOf(poids));
        Cookie tailleCookie = new Cookie("taille", String.valueOf(taille));
        response.addCookie(poidsCookie);
        response.addCookie(tailleCookie);

        // Store data in session
        HttpSession session = request.getSession();
        session.setAttribute("poids", poids);
        session.setAttribute("taille", taille);
        session.setAttribute("imc", imc);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Résultat IMC</title></head><body>");
        out.println("<h2>Votre IMC est : " + String.format("%.2f", imc) + "</h2>");

        // 🔹 Button to go to Tableau de Bord
        out.println("<form action='TableauBord' method='GET'>");
        out.println("<input type='submit' value='Voir le Tableau de Bord'>");
        out.println("</form>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des paramètres
        String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");

        // Vérification si les valeurs sont nulles
        if (poidsStr == null || tailleStr == null || poidsStr.isEmpty() || tailleStr.isEmpty()) {
            response.sendRedirect("renseignement.html?error=1"); // Redirige vers le formulaire avec un message d'erreur
            return;
        }

        double poids = 0, taille = 0;
        boolean erreur = false;

        try {
            poids = Double.parseDouble(poidsStr.trim());
            taille = Double.parseDouble(tailleStr.trim());
        } catch (NumberFormatException e) {
            erreur = true;
        }

        if (!erreur && taille > 0) {
            double imc = poids / (taille * taille);

            // 🔹 Stockage des valeurs dans les cookies
            Cookie poidsCookie = new Cookie("poids", String.valueOf(poids));
            Cookie tailleCookie = new Cookie("taille", String.valueOf(taille));
            poidsCookie.setMaxAge(60 * 60 * 24);
            tailleCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(poidsCookie);
            response.addCookie(tailleCookie);

            // 🔹 Stockage des valeurs dans la session
            HttpSession session = request.getSession();
            session.setAttribute("poids", poids);
            session.setAttribute("taille", taille);
            session.setAttribute("imc", imc);

            // 🔹 Redirige vers la JSP pour afficher le résultat
            request.setAttribute("imc", String.format("%.2f", imc));
            request.getRequestDispatcher("resultat.jsp").forward(request, response);
        } else {
            response.sendRedirect("renseignement.html?error=1");
        }
    }

}

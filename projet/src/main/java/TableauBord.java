import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TableauBord")
public class TableauBord extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

    public TableauBord() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("TableauBord.jsp").forward(request, response);
    }
 // Retrieving data from cookies
    Cookie[] cookies = request.getCookies();
    String poids = null, taille = null ;

    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("poids")) poids = c.getValue();
            if (c.getName().equals("taille")) taille = c.getValue();
        }
    }
       
        PrintWriter out ;
        // Retrieve data from session
        HttpSession session = request.getSession(false);
        Double sessionPoids = (session != null) ? (Double) session.getAttribute("poids") : null;
        Double sessionTaille = (session != null) ? (Double) session.getAttribute("taille") : null;
        Double sessionImc = (session != null) ? (Double) session.getAttribute("imc") : null;

        if (sessionPoids != null && sessionTaille != null && sessionImc != null) {
            out.println("<p><b>Poids (Session) :</b> " + sessionPoids + " kg</p>");
            out.println("<p><b>Taille (Session) :</b> " + sessionTaille + " m</p>");
            out.println("<p><b>IMC (Session) :</b> " + String.format("%.2f", sessionImc) + "</p>");
        } else {
            out.println("<p>Aucune donnée en session.</p>");
        }

        if (poids != null && taille != null) {
            double imcFromCookies = Double.parseDouble(poids) / (Double.parseDouble(taille) * Double.parseDouble(taille));
        
			out.println("<p><b>Poids (Cookie) :</b> " + poids + " kg</p>");
            out.println("<p><b>Taille (Cookie) :</b> " + taille + " m</p>");
            out.println("<p><b>IMC (Cookie) :</b> " + String.format("%.2f", imcFromCookies) + "</p>");
        } else {
            out.println("<p>Aucune donnée trouvée dans les cookies.</p>");
        }

        // 🔹 Button to return to IMC form
        out.println("<form action='renseignement.html' method='GET'>");
        out.println("<input type='submit' value='Retour au formulaire'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}

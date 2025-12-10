package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import java.util.logging.Level;

@WebServlet("/connexion")
public class Login extends HttpServlet {
    
    private static final Logger LOGGER = Logger.getLogger(Login.class.getName());
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = null;
        
        try {
            // Configuration de la réponse
            response.setContentType("text/html; charset=UTF-8");
            out = response.getWriter();
            
            // Récupération des paramètres
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            
            // Validation des paramètres
            if (login == null || login.trim().isEmpty()) {
                throw new IllegalArgumentException("Le login est obligatoire");
            }
            
            if (password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("Le mot de passe est obligatoire");
            }
            
            // Vérification des credentials
            if (login.equals("admin") && password.equals("passer")) {
                response.setStatus(HttpServletResponse.SC_OK);
                out.println("Connexion réussie");
                LOGGER.info("Connexion réussie pour l'utilisateur : " + login);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.println("Échec de la connexion : identifiants incorrects");
                LOGGER.warning("Tentative de connexion échouée pour : " + login);
            }
            
        } catch (IllegalArgumentException e) {
            // Gestion des erreurs de validation
            LOGGER.log(Level.WARNING, "Erreur de validation : " + e.getMessage(), e);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            if (out != null) {
                out.println("Erreur : " + e.getMessage());
            }
            
        } catch (Exception e) {
            // Gestion des erreurs inattendues
            LOGGER.log(Level.SEVERE, "Erreur inattendue lors de la connexion", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (out != null) {
                out.println("Erreur serveur : Une erreur technique est survenue");
            }
            
        } finally {
            // Fermeture propre du PrintWriter
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    LOGGER.log(Level.WARNING, "Erreur lors de la fermeture du PrintWriter", e);
                }
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        response.getWriter().println("Erreur : Méthode GET non autorisée");
    }
}
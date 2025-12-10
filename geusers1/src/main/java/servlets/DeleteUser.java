package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;
/**
 * Servlet implementation class AddUser
 */
@WebServlet("/supprimer")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String id = request.getParameter("id");
    	
    	if ( id != null && id.matches("[0-9]+")) {
    		
    		UtilisateurDao.supprimer(Integer.parseInt(id));

    	}
        response.sendRedirect("list");
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		int id = Integer.parseInt(request.getParameter("id"));
//		String login = request.getParameter("login");
//		String prenom = request.getParameter("prenom");
//		String nom = request.getParameter("nom");
//		String password = request.getParameter("password");
//		
//		Utilisateur utilisateur = new Utilisateur(prenom, nom, login, password);
//		
//		UtilisateurDao.modifier(id, utilisateur);
//		response.sendRedirect("list");
//		
//	}

}

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
@WebServlet("/addUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String ADD_USER_VIEW = "/WEB-INF/Utilisateurs/ajouterUtilisateur.jsp";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(ADD_USER_VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String password = request.getParameter("password");
		
		Utilisateur utilisateur = new Utilisateur(prenom, nom, login, password);
		
		UtilisateurDao.ajouter(utilisateur);
		response.sendRedirect("list");
		
	}

}

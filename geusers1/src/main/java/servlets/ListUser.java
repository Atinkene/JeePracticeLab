package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.UtilisateurDao;

/**
 * Servlet implementation class ListUser
 */
@WebServlet("/list")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String LIST_USER_VIEW = "/WEB-INF/Utilisateurs/listerUtilisateur.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("utilisateurs", UtilisateurDao.lister());
		getServletContext().getRequestDispatcher(LIST_USER_VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

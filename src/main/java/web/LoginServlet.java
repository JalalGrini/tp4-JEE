package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User u = dao.findByLoginAndPassword(login, password);
		if (u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			response.sendRedirect("listProduits");
		} else {
			request.setAttribute("erreur", "Login ou mot de passe invalide");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}

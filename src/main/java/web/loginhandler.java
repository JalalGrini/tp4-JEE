package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import model.User;

/**
 * 
 */
public class loginhandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		dao = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if (login.isEmpty() || password.isEmpty()) {
			request.setAttribute("erreur", "accée refusé");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;

		}
		User u = dao.UserValid(login, password);
		if (u != null) {
			HttpSession S = request.getSession();
			S.setAttribute("user", u);
			if (u.getRole().equals("admin")) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("list.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("erreur", "login ou mot de pass est invalide");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}

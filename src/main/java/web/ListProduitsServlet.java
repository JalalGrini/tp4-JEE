package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Produit;
import Services.ProduitMetier;
import Services.ProduitMetierImpl;
import model.User;

public class ListProduitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String idParam = request.getParameter("idProduit");
		List<Produit> liste = new ArrayList<>();
		
		if (idParam != null && !idParam.isEmpty()) {
			try {
				Long id = Long.parseLong(idParam);
				Produit p = metier.getProduitById(id);
				if (p != null) {
					liste.add(p);
				}
			} catch (NumberFormatException e) {
				liste = metier.getAllProduits();
			}
		} else {
			liste = metier.getAllProduits();
		}
		
		request.setAttribute("listeProduits", liste);
		
		HttpSession session = request.getSession(false);
		User u = (User) session.getAttribute("user");
		
		if (u != null && "admin".equals(u.getRole())) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}

package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Produit;
import Services.ProduitMetier;
import Services.ProduitMetierImpl;

public class UpdateProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("idProduit"));
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		
		Produit p = new Produit();
		p.setIdProduit(id);
		p.setNom(nom);
		p.setDescription(description);
		p.setPrix(prix);
		
		metier.updateProduit(p);
		
		request.setAttribute("listeProduits", metier.getAllProduits());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}

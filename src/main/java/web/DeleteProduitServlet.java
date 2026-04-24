package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ProduitMetier;
import Services.ProduitMetierImpl;

public class DeleteProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		metier.deleteProduit(id);
		response.sendRedirect("listProduits");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}

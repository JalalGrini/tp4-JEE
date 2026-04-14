package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import Services.ProduitMetier;
import Services.ProduitMetierImpl;

/**
 * Servlet implementation class DeleteProduitServlet
 */

public class DeleteProduitServlet extends HttpServlet {
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Récupération du paramètre "id" depuis l'URL

		Long id = Long.parseLong(req.getParameter("id"));

		// Appel à la couche métier pour supprimer le produit

		metier.deleteProduit(id);

		// Redirection vers ListProduitServlet pour afficher la liste mise à jour

		// Important : sendRedirect déclenche une nouvelle requête HTTP

		resp.sendRedirect("listProduits");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import DAO.Produit;
import Services.ProduitMetier;
import Services.ProduitMetierImpl;

/**
 * Servlet implementation class EditProduitServlet
 */

public class EditProduitServlet extends HttpServlet {
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Récupération de l'ID depuis le lien "Modifier"
		Long id = Long.parseLong(req.getParameter("id"));

		// Récupération du produit correspondant via la couche métier
		Produit p = metier.getProduitById(id);

		// Ajout du produit dans les attributs de requête pour pré-remplir le formulaire
		req.setAttribute("produitEdit", p);

		// On ajoute aussi la liste complète pour afficher tous les produits
		req.setAttribute("listeProduits", metier.getAllProduits());

		// Forward vers la JSP index.jsp
		// Le formulaire sera pré-rempli si "produitEdit" existe
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

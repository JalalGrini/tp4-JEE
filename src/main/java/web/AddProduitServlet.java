package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.Produit;
import Services.ProduitMetier;
import Services.ProduitMetierImpl;

/**
 * Servlet implementation class AddProduitServlet
 */

public class AddProduitServlet extends HttpServlet {
	// Instance singleton de la couche métier

	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();

	// Liste locale, utilisée seulement si on voulait gérer des produits temporaires (inutile ici)

	List<Produit> produits = new ArrayList<Produit>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Récupération des paramètres du formulaire

		String nom = req.getParameter("nom");
		String description = req.getParameter("description");
		Double prix = Double.parseDouble(req.getParameter("prix")); // conversion String -> Double

		// Création de l'objet Produit
		Produit p = new Produit(nom, description, prix);

		// Ajout via la couche métier (qui met à jour la liste DAO)
		metier.addProduit(p);
		// La liste locale produits.add(p) n'est pas nécessaire ici,
		// car metier.getAllProduits() contient déjà tous les produits.
		produits.add(p);
		// Mise à disposition de la liste complète pour la JSP
		req.setAttribute("listeProduits", metier.getAllProduits());

		// Forward vers la JSP (index.jsp) pour affichage
		// Important : on ne redirige pas, sinon la requête perd ses attributs
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}

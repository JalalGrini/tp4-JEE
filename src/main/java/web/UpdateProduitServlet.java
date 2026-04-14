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
 * Servlet implementation class UpdateProduitServlet
 */

public class UpdateProduitServlet extends HttpServlet {
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduitServlet() {
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
		Long id = Long.parseLong(req.getParameter("idProduit"));
		String nom = req.getParameter("nom");
		String description = req.getParameter("description");
		Double prix = Double.parseDouble(req.getParameter("prix"));

		// Création d'un objet Produit avec les nouvelles valeurs
		Produit p = new Produit();

		p.setIdProduit(id);
		p.setNom(nom);
		p.setDescripton(description);
		p.setPrix(prix);

		// Mise à jour via la couche métier
		metier.updateProduit(p);

		// Préparer la liste complète pour l'affichage JSP
		req.setAttribute("listeProduits", metier.getAllProduits());

		// Forward vers index.jsp pour afficher le tableau mis à jour
		// On utilise forward ici pour conserver les attributs de la requête
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		// Remarque : si l'on utilisait sendRedirect("listProduits"),
		// on perdrait les attributs
	}

}

package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Produit;
import Services.ProduitMetier;
import Services.ProduitMetierImpl;

/**
 * Servlet implementation class ListProduitsServlet
 */
public class ListProduitsServlet extends HttpServlet {
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProduitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idParam = req.getParameter("idProduit");

		// Liste de produits à afficher

		List<Produit> liste = new ArrayList<>();

		if (idParam != null && !idParam.isEmpty()) {

		try {

		// Conversion du paramètre en Long

		Long id = Long.parseLong(idParam);

		// Recherche du produit correspondant via la couche métier

		Produit p = metier.getProduitById(id);

		if (p != null) {

		liste.add(p); // ajouter le produit trouvé à la liste

		}

		// Si le produit n'existe pas, la liste restera vide (option : message d'erreur)

		} catch (NumberFormatException e) {

		// Cas où l'utilisateur entre un ID invalide (non numérique)

		// On récupère tous les produits pour ne pas bloquer la page

		liste = metier.getAllProduits();

		}

		} else {

		// Aucun paramètre fourni : on affiche tous les produits

		liste = metier.getAllProduits();

		}

		// Stocker la liste dans la requête pour l'affichage JSP

		req.setAttribute("listeProduits", liste);

		// Forward vers JSP pour affichage (on garde les attributs de la requête)

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

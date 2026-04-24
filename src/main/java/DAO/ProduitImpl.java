package DAO;

import java.util.ArrayList;
import java.util.List;

public class ProduitImpl implements ProduitDAO {
	
	private List<Produit> produits = new ArrayList<Produit>();
	
	public void init() {
		System.out.println("Spring IOC est bien fonctionnée !");
		addProduit(new Produit("PC 1", "msi pc", 1200.0));
		addProduit(new Produit("PC 2", "acer pc", 1300.0));
	}

	@Override
	public void addProduit(Produit p) {
		p.setIdProduit(Long.valueOf(produits.size() + 1));
		produits.add(p);
	}

	@Override
	public void deleteProduit(Long id) {
		produits.remove(getProduitById(id));
	}

	@Override
	public Produit getProduitById(Long id) {
		for (Produit p : produits) {
			if (p.getIdProduit().equals(id)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Produit> getAllProduits() {
		return produits;
	}

	@Override
	public void updateProduit(Produit p) {
		for (int i = 0; i < produits.size(); i++) {
			Produit existingProduit = produits.get(i);
			if (existingProduit.getIdProduit().equals(p.getIdProduit())) {
				existingProduit.setDescription(p.getDescription());
				existingProduit.setNom(p.getNom());
				existingProduit.setPrix(p.getPrix());
				break;
			}
		}
	}
}

package DAO;

import java.util.ArrayList;

import java.util.List;
import DAO.Produit;

import DAO.ProduitDAO;

public class ProduitImpl implements ProduitDAO {
	
	private List<Produit> produits = new ArrayList<Produit>();
	
	public void init(){

		System.out.println("Spring IOC est bien fonctionnée !");

		addProduit(new Produit("PC 1","Sony vaio 1",7000.0));

		addProduit(new Produit("PC 2","Sony vaio 2",6000.0));

		}
	@SuppressWarnings("removal")
	@Override
	public void addProduit(Produit p) {
		p.setIdProduit(new Long(produits.size()+1));
		produits.add(p);
	}

	@Override
	public void deleteProduit(Long id) {
		produits.remove(getProduitById(id));
	}

	@Override
	public Produit getProduitById(Long id) {
		Produit produit = null;
		for(Produit p : produits) {
			if(p.getIdProduit().equals(id)) {
				produit = p;
				break;
			}
		}
		
		return produit;
	}

	@Override
	public List<Produit> getAllProduits() {
		
		return produits;
	}

	@Override
	public void updateProduit(Produit p) {
		for(int i = 0 ; i<produits.size() ; i++) {
			Produit existingProduit = produits.get(i);
			if(existingProduit.equals(p)) {
				existingProduit.setDescripton(p.getDescripton());
				existingProduit.setNom(p.getNom());
				existingProduit.setPrix(p.getPrix());
				break;
			}
		}
		
	}
	
}

package DAO;

public class Produit {
	private Long IdProduit;
	private String nom;
	private String descripton;
	private double prix;
	
	public Produit() {
	
	}
	public Produit(String nom, String descripton, double prix) {
		super();
		this.nom = nom;
		this.descripton = descripton;
		this.prix = prix;
	}
	public Long getIdProduit() {
		return IdProduit;
	}
	public void setIdProduit(Long idProduit) {
		IdProduit = idProduit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	

}

package entity;

public class Produit {
	private int idP ;
	private String nom ; 
	private double prix; 
	private double quantite; 
	private String nomC ;
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}   
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	} 
	public Produit() {
		super();
	}
	public Produit(String nom, double prix, double quantite, String nomC) {
		super(); 
	
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.nomC = nomC;
		
	}

}
	

	


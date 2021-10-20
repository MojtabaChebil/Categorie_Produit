package dao;

import java.util.List;


import entity.Categorie;
import entity.Produit;



public interface CatalogueDao { 
	public void addProduit(Produit e);  
	public void addCategorie(Categorie c);
	public List<Produit>getAllProduit();
	public List<Categorie> getAllCategorie(); 
	public List<Produit> consultProduitPCat(String choix );
	
	
	
}

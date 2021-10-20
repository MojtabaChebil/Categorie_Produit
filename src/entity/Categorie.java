package entity;

public class Categorie { 
	private int idC ;
	private String nomC ;

	public int getIdC() {
		return idC;
	}
	public void setId(int idC) {
		this.idC = idC;
	}
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	} 
	public Categorie() {
		
	 
		
	}
	public Categorie(String nomC) {
		
		this.nomC = nomC;
		
	}
	
}

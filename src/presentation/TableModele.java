package presentation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import entity.*;

public class TableModele extends AbstractTableModel {
	private List<Produit> l = new ArrayList<>();
	private String titre []= {"id","nom","prix","quantite","categorie"};
	public int getColumnCount() {
		return  titre.length;
	}
	public int getRowCount() {
		return l.size();
	}
	public Object getValueAt(int li ,int c) {
		switch(c) {
		case 0:
			
			return(l.get(li).getIdP());
		case 1 :
			return (l.get(li).getNom());
		case 2 :
			return(l.get(li).getPrix()); 
		case 3 :
			return(l.get(li).getQuantite());	 
		case 4:
			return(l.get(li).getNomC());	
		}
			return  null ;
		}
	public String getColumnName(int column) {
		return titre[column];
	}
	public void charger(List<Produit> l) {
		this.l = l;
		fireTableDataChanged();
	}
	
	

}



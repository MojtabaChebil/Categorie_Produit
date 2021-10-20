package presentation;

import java.util.ArrayList;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Categorie;
import entity.Produit;


	public class TableModele2 extends AbstractTableModel {
		private List<Categorie> l = new ArrayList<>();
		private String titre[]= {"id","categorie"};
		
		
		public int getColumnCount() {
			return  titre.length;
		}
		public int getRowCount() {
			return l.size();
		}
		public Object getValueAt(int li ,int c) {
			switch(c) {
			case 0:
				
				return(l.get(li).getIdC());
			case 1 :
				return (l.get(li).getNomC());
			}
			return  null ;
			}
		public String getColumnName(int column) {
			return titre[column];
		}
		public void charger(List<Categorie> l) {
			this.l = l;
			fireTableDataChanged();
		}
		
		

	}





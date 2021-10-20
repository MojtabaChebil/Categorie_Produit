
	package presentation;

	import java.awt.Color;
import java.awt.GridLayout;




	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;

	public class GetPresentation extends JFrame{
		JButton ajouterC = new JButton("Ajouter Categorie");
		JButton ajouterP = new JButton("Ajouter Produit");
		JButton rechercher = new JButton("Rechercher");
		JButton quitter = new JButton("Quitter");
		
		 public GetPresentation() {
			 this.setVisible(true);
			 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			 this.setTitle("Gestion Catalogue");
			 this.setLayout(new GridLayout(2,2)); 
			
			 
			 this.add(ajouterC);
			 this.add(ajouterP);
			 this.add(rechercher);
			 this.add(quitter);
			
			 this.setSize(500,400);
			 this.setLocationRelativeTo(null);
			
			 ajouterC.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 new ajouterPresentation();
				 }
			 });
			 ajouterP.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 new ajouterPresentationC();
				 }
			 });
			 rechercher.addActionListener(new ActionListener(){          
				 public void actionPerformed(ActionEvent e) {
					 new FindPresentation();
				 }
			 });
			 quitter.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					System.exit(0);
				 }
			 });
			 }
		public static void main(String[]args) {
			new  GetPresentation();
		}
	}

	


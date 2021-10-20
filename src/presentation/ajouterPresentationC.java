package presentation;

import javax.swing.JFrame;
import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import dao.CatalogueDao;
import dao.CatalogueDaoImpl;
import entity.Categorie;
import entity.Produit;

public class ajouterPresentationC extends JFrame  {
	
	JPanel pp = new JPanel(new BorderLayout());
	JPanel bas = new JPanel(new BorderLayout());
	JButton quitter = new JButton("quitter");
	JPanel p1 = new JPanel(new GridLayout(6, 2, 10, 10));
	JButton btn1 = new JButton("annuller");
	JPanel btnQ = new JPanel();
	JComboBox<String> nomCat = new JComboBox<>(new String[] {});
	JLabel nom = new JLabel("nom", JLabel.RIGHT);
	JTextField tnom = new JTextField();
	JLabel prix = new JLabel("prix", JLabel.RIGHT);
	JTextField tprix = new JTextField();
	JLabel nomC = new JLabel("Categorie");
	JTextField tnomC = new JTextField();
	JLabel quantite = new JLabel("quantite", JLabel.RIGHT);
	JTextField tquantite = new JTextField();
	JButton ajouter = new JButton("ajouter");
    JLabel vide = new JLabel("  ");
	CatalogueDao catalogueDao = new CatalogueDaoImpl();													
	JPanel prs = new JPanel(new GridLayout(1, 1));
	TableModele me = new TableModele();
	JTable table = new JTable(me);
	JScrollPane jsp = new JScrollPane(table);
	JPanel prsc = new JPanel(new GridLayout(1, 1));
	JPanel ppp = new JPanel(new GridLayout(1,2));
	public ajouterPresentationC() {
		getAllCategories();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		nom.setHorizontalAlignment(JLabel.RIGHT);
		nomC.setHorizontalAlignment(JLabel.RIGHT);
		p1.add(nom);
		p1.add(tnom);
		p1.add(prix);
		p1.add(tprix);
		p1.add(quantite);
		p1.add(tquantite);
		p1.add(nomC);
		p1.add(nomCat);
		p1.add(vide);
		prs.add(jsp);
		p1.add(ajouter);
		p1.add(btn1);
		pp.add(p1, BorderLayout.NORTH);
		pp.add(jsp, BorderLayout.CENTER);
		ppp.add(pp);	
		setVisible(true);	
		pp.setBorder(BorderFactory.createTitledBorder( "Ajouter Un Produit"));
		
		btnQ.add(quitter);
		bas.add(btnQ);
		this.add(ppp,BorderLayout.CENTER);
		this.add(btnQ , BorderLayout.SOUTH) ;
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		 me.charger(catalogueDao.getAllProduit());  	 
		ajouter.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String nom = tnom.getText();
				Double prix = Double.parseDouble(tprix.getText());
				Double quantite = Double.parseDouble(tquantite.getText());
				String nomC = (String) nomCat.getSelectedItem();			
				if (nom.equals("") || prix.equals("") || quantite.equals("")
						|| nomC.equals("")) {
					JOptionPane.showMessageDialog(ajouterPresentationC.this, "erreur de saisie");}
				else {
					Produit p = new Produit(nom, prix, quantite, nomC);
					catalogueDao.addProduit(p);
					
					me.charger(catalogueDao.getAllProduit());
				}
			}
		});
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});	
btn1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

		tnom.setText("");
		tprix.setText("");
		tquantite.setText("");		
				
			}
		});
		
}		
	private void getAllCategories() {
		
		List<Categorie> categorieList = catalogueDao.getAllCategorie();
		categorieList.forEach(c -> nomCat.addItem(c.getNomC()));

	}
	
	
	public static void main(String[] args) {
		new ajouterPresentationC();
	}
		
}

package presentation;

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

public class ajouterPresentation extends JFrame {

	
	JPanel c = new JPanel(new BorderLayout());
	JPanel bas = new JPanel(new BorderLayout());
	JButton quitter = new JButton("quitter");
	JPanel p1 = new JPanel(new GridLayout(2, 2));

	JPanel p2 = new JPanel(new GridLayout(2, 2));
	JPanel btnQ = new JPanel();
	JLabel nomC = new JLabel("Categorie");
	JTextField tnomC = new JTextField();
	JLabel quantite = new JLabel("quantite", JLabel.RIGHT);
	JTextField tquantite = new JTextField();
	JButton btn2 = new JButton("annuller");
	JButton ajouterC = new JButton("Ajouter Categorie");

JLabel vide = new JLabel(" ");
	CatalogueDao catalogueDao = new CatalogueDaoImpl();
														
	

	JPanel prsc = new JPanel(new GridLayout(1, 1));
	TableModele2 mec = new TableModele2();
	JTable tablec = new JTable(mec);
	JScrollPane jspc = new JScrollPane(tablec);
	JPanel ppp = new JPanel(new GridLayout(1,2));
	public ajouterPresentation() {		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		nomC.setHorizontalAlignment(JLabel.RIGHT);
		p1.add(nomC);
		p1.add(vide);
		setVisible(true);
		c.setBorder(BorderFactory.createTitledBorder("Ajouter Une Categorie"));
		p2.add(nomC);
		p2.add(tnomC);
		prsc.add(jspc);
		p2.add(ajouterC);
		p2.add(btn2);
		c.add(p2, BorderLayout.NORTH);
		c.add(prsc, BorderLayout.CENTER);
		ppp.add(c);
		btnQ.add(quitter);
		bas.add(btnQ);
		this.add(ppp,BorderLayout.CENTER);
		this.add(btnQ , BorderLayout.SOUTH) ;
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mec.charger(catalogueDao.getAllCategorie());
		ajouterC.addActionListener(e->{
               if(tnomC.getText().equals(""))
            	   JOptionPane.showMessageDialog(this, " Completer la saisie ");
               else { 
				String nomC = tnomC.getText();	
				Categorie c2 = new Categorie(nomC);
				catalogueDao.addCategorie(c2);
			
				mec.charger(catalogueDao.getAllCategorie()); }
		});
               
btn2.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
       tnomC.setText("");
	}
	
});}	
	public static void main(String[] args) {
		new ajouterPresentation();
	}
}
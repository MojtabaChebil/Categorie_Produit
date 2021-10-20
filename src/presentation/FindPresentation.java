 package presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.CatalogueDao;
import dao.CatalogueDaoImpl;
import entity.Categorie;


class FindPresentation extends JFrame {

	JLabel ent = new JLabel("selectionner une categorie : ");
	CatalogueDao catalogueDao = new CatalogueDaoImpl();
	JPanel haut = new JPanel();
	JPanel bas = new JPanel();
	JButton find = new JButton("Rechercher");
	JButton quitter = new JButton("quitter");
	TableModele3 m1 = new TableModele3();
	JTable table = new JTable(m1);
	JScrollPane jsp = new JScrollPane(table);

	
	JComboBox<String> nomCat = new JComboBox<>(new String[] {  });
	


	public FindPresentation() {
		
		
		List<Categorie> categorieList = catalogueDao.getAllCategorie();
		categorieList.forEach(c -> nomCat.addItem(c.getNomC()));
		
		
		this.setTitle("Rechercher");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		haut.add(ent);
		haut.add(nomCat);
		find.setHorizontalAlignment(JButton.RIGHT);
		haut.add(find);
		this.add(haut, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
		bas.add(quitter);
		this.add(bas, BorderLayout.SOUTH);
		this.setSize(500, 450);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = (String) nomCat.getSelectedItem();
				m1.charger3(catalogueDao.consultProduitPCat(s));
			}
		});

		

		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new FindPresentation();
	}
}



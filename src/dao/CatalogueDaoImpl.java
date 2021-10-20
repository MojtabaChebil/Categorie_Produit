package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Categorie;
import entity.Produit;
import utils.SingletonConnection;

public class CatalogueDaoImpl implements CatalogueDao {
	public void addProduit(Produit p) {
		Connection cnx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cnx
					.prepareStatement("insert into produit (nom,prix,quantite,nomC ) values(?,?,?,?)");
			// st.setInt(1, p.getIdP());
			st.setString(1, p.getNom());
			st.setDouble(2, p.getPrix());
			st.setDouble(3, p.getQuantite());
			st.setString(4, p.getNomC());
			st.executeUpdate();
		} catch (SQLException p1) {
			p1.printStackTrace();
		}

	}

	public void addCategorie(Categorie c) {
		Connection cnx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cnx.prepareStatement("insert into categorie(nomC)values(?)");
			// st.setInt(1,c.getId());
			st.setString(1, c.getNomC());
			st.executeUpdate();

		} catch (SQLException c1) {
			c1.printStackTrace();
		}
	}

	public List<Produit> getAllProduit() {
		Connection cnx = SingletonConnection.getInstance();
		List<Produit> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select* from produit");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setIdP(rs.getInt(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				p.setNomC(rs.getString(5));
				liste.add(p);
			}
		} catch (SQLException p) {
			p.printStackTrace();
		}
		return liste;

	}

	public List<Categorie> getAllCategorie() {
		Connection cnx = SingletonConnection.getInstance();
		List<Categorie> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select* from categorie");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Categorie c = new Categorie();
				c.setId(rs.getInt(1));
				c.setNomC(rs.getString(2));

				liste.add(c);
			}
		} catch (SQLException c) {
			c.printStackTrace();
		}
		return liste;

	}

	@Override
	public List<Produit> consultProduitPCat(String choix) {
		Connection cnx = SingletonConnection.getInstance();
		List<Produit> listeP = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from produit where nomC =?");
			ps.setString(1, choix);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Produit prod = new Produit();
				prod.setIdP(res.getInt(1));
				prod.setNom(res.getString(2));
				prod.setPrix(res.getDouble(3));
				prod.setQuantite(res.getDouble(4));
				prod.setNomC(res.getString(5));
				listeP.add(prod);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeP;
	}

}
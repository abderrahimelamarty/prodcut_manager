package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDao {

	@Override
	public Produit save(Produit p) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?) ");
			ps.setString(1,p.getDesignation());
			ps.setLong(2, p.getPrix());
			ps.setLong(3, p.getQuantite());
			ps.executeUpdate();
			ps.close();
			PreparedStatement ps1 =connection.prepareStatement
					("SELECT MAX(ID) as MAX_ID from produits ");
			ResultSet rs=ps1.executeQuery();
			if(rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p;
	}

	@Override
	public List<Produit> ProduitsParMC(String mc) {
		List<Produit> produits=new ArrayList<Produit>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit p=new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getLong("PRIX"));
				p.setQuantite(rs.getLong("QUANTITE"));
				produits.add(p);
			}
			return produits;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduit(Long id) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement
					("DELETE FROM PRODUITS where id=? ");
		    ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
	}
	

}

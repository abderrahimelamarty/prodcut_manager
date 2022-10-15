package dao;

import metier.entities.Produit;

public class TestDao {
 public static void main( String[] args) {
	 ProduitDaoImpl dao =new ProduitDaoImpl();
	 Produit p1=dao.save(new Produit("hhh",9000,5000));
	 Produit p2=dao.save(new Produit("kkkkk",1000,80000));

	 
 }
}

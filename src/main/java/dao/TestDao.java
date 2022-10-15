package dao;

import java.util.List;

import metier.entities.Produit;

public class TestDao {
 public static void main( String[] args) {
	 ProduitDaoImpl dao =new ProduitDaoImpl();
	 Produit p1=dao.save(new Produit("hhh",9000,5000));
	 Produit p3=dao.save(new Produit("hoho",9000,5000));
	 Produit p6=dao.save(new Produit("haha",9000,5000));
	 Produit p2=dao.save(new Produit("kkkkk",1000,80000));
	 List<Produit> produits=dao.ProduitsParMC("%h%");
	 for(int i=0; i<produits.size();i++) {
		 System.out.println(produits.get(i).getDesignation());
	 }
	 

	 
 }
}

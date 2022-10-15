package metier.entities;

import java.io.Serializable;

public class Produit implements Serializable {
	private long id;
	private String designation;
	private long prix;
	private long quantite;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String designation, long prix, long quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	public long getQuantite() {
		return quantite;
	}
	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}
	

}

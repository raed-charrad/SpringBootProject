package com.example.produits.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class produit {

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long idProduit;
		private String nomProduit;
		private Double prixProduit;
		private Date dateCreation; 
		public produit(String nomProduit, Double prixProduit, Date dateCreation) {
		super();
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.dateCreation = dateCreation;
		}
		public produit() {
		super();
		}
		public String getNomProduit() {
		return nomProduit;
		}
		public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
		}
		public Double getPrixProduit() {
		return prixProduit;
		}
		public void setPrixProduit(Double prixProduit) {
		this.prixProduit = prixProduit;
		}
		public Date getDateCreation() {
		return dateCreation;
		}
		public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
		}
		public Long getIdProduit() {
			return idProduit;
		}
		public void setIdProduit(Long idProduit) {
			this.idProduit = idProduit;
		}
}
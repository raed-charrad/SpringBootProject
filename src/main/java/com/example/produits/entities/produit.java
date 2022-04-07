package com.example.produits.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class produit {

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long idProduit;
		@NotNull
		@Size (min = 4,max = 15)
		private String nomProduit;
		@Min(value = 10)
		@Max(value = 10000) 

		private Double prixProduit;
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@PastOrPresent

		private Date dateCreation; 
		@ManyToOne
		private Categorie categorie;

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
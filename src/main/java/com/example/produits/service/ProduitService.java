package com.example.produits.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.produit;

public interface ProduitService {
	produit saveProduit(produit p);
	produit updateProduit(produit p);
	Page<produit> getAllProduitsParPage(int page, int size); 
	void deleteProduit(produit p);
	void deleteProduitById(Long id);
	produit getProduit(Long id);
	List<produit> getAllProduits(); 
	List<produit> findByNomProduit(String nom);

	Page<produit> findByNomProduitContains(String nom,int page,int size);

	List<produit> findByNomPrix(String nom, Double prix);

	List<produit> findByCategorie(Categorie categorie);

	List<produit> findByCategorieIdCat(Long id);

	List<produit> findByOrderByNomProduitAsc();

	List<produit> trierProduitsNomsPrix(); 
}

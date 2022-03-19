package com.example.produits.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.produits.entities.produit;

public interface ProduitService {
	produit saveProduit(produit p);
	produit updateProduit(produit p);
	Page<produit> getAllProduitsParPage(int page, int size); 
	void deleteProduit(produit p);
	void deleteProduitById(Long id);
	 produit getProduit(Long id);
	 List<produit> getAllProduits(); 
}

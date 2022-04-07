package com.example.produits.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.produit;
public interface ProduitRepository extends JpaRepository<produit, Long> {
	List<produit> findByNomProduit(String nom);

    List<produit> findByNomProduitContains(String nom);
    Page<produit> findAllByNomProduitContains(String nom,Pageable pageable);

    @Query("select p from produit p where p.nomProduit like %?1 and p.prixProduit> ?2")
    List<produit> findByNomPrix(String nom, Double prix);

    @Query("select p from produit p where p.categorie = ?1")
    List<produit> findByCategorie(Categorie categorie);

    List<produit> findByCategorieIdCat(Long id);

    List<produit> findByOrderByNomProduitAsc();

    @Query("select p from produit p order by p.nomProduit ASC, p.prixProduit DESC")
    List<produit> trierProduitsNomsPrix();
}


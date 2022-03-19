package com.example.produits.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.produits.entities.produit;
public interface ProduitRepository extends JpaRepository<produit, Long> {
}

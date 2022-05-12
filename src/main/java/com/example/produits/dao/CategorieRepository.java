package com.example.produits.dao;

import com.example.produits.entities.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}

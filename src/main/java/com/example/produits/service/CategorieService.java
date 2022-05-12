package com.example.produits.service;

import java.util.List;

import com.example.produits.dao.CategorieRepository;
import com.example.produits.entities.Categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie saveCategorie(Categorie p) {
        return categorieRepository.save(p);
    }

    public Categorie updateCategorie(Categorie p) {
        return categorieRepository.save(p);
    }

    public Page<Categorie> getAllCategoriesParPage(int page, int size) {
        return categorieRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteCategorie(Categorie p) {
        categorieRepository.delete(p);
    }

    public void deleteCategorieById(Long id) {
        categorieRepository.deleteById(id);
    }

    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).get();
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

}

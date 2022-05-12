package com.example.produits.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.produit;
import com.example.produits.service.CategorieService;
import com.example.produits.service.ProduitService;

@Controller
public class CatController {
	@Autowired
	ProduitService produitService;
	@Autowired
	CategorieService categorieService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("produit", new produit());
		modelMap.addAttribute("ajout", true);
		return "createProduit";
	}

	@RequestMapping("ShowCreateCategorie")
	public String ShowCreateCategorie(ModelMap modelMap) {
		modelMap.addAttribute("categorie", new Categorie());
		modelMap.addAttribute("ajout", true);
		return "createCategorie";
	}

	@RequestMapping("/saveProduit")
	public String saveProduit(@Valid produit produit,
			BindingResult bindingResult,
			ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("ajout", true);
			return "createProduit";
		}
		produit saveProduit = produitService.saveProduit(produit);
		String msg = "produit enregistré avec Id " +
				saveProduit.getIdProduit();
		modelMap.addAttribute("msg", msg);
		return this.listeProduits(modelMap, 0, 2);
	}

	@RequestMapping("/saveCategorie")
	public String saveCategorie(@Valid Categorie categorie,
			BindingResult bindingResult,
			ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("org.springframework.validation.BindingResult.categorie", bindingResult);

			modelMap.addAttribute("ajout", true);
			return "createCategorie";
		}
		Categorie saveCategorie = categorieService.saveCategorie(categorie);
		String msg = "categorie enregistré avec Id " +
				saveCategorie.getIdCat();
		modelMap.addAttribute("msg", msg);
		return this.listeCategories(modelMap, 0, 2);
	}

	@RequestMapping("/ListeProduits")
	public String listeProduits(
			ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<produit> prods = produitService.getAllProduitsParPage(page, size);
		modelMap.addAttribute("produits", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "search";
	}

	@RequestMapping("/ListeCategories")
	public String listeCategories(
			ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Categorie> cats = categorieService.getAllCategoriesParPage(page, size);
		modelMap.addAttribute("categories", cats);
		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeCategories";
	}

	@RequestMapping("supprimerCategories")
	public String supprimerCategories(@RequestParam(name = "id") Long id,
			ModelMap modelMap) {
		categorieService.deleteCategorieById(id);
		String msg = "categorie supprimé avec Id " + id;
		modelMap.addAttribute("msg", msg);
		return this.listeCategories(modelMap, 0, 2);
	}

	@RequestMapping("/supprimerProduit")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		produitService.deleteProduitById(id);
		Page<produit> prods = produitService.getAllProduitsParPage(page,
				size);
		modelMap.addAttribute("produits", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "search";
	}

	@RequestMapping("/modifierCategorie")
	public String modifierCategorie(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Categorie cat = categorieService.getCategorie(id);
		modelMap.addAttribute("categorie", cat);
		modelMap.addAttribute("ajout", false);
		Page<Categorie> cats = categorieService.getAllCategoriesParPage(page, size);
		modelMap.addAttribute("categories", cats);
		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "createCategorie";
	}

	@RequestMapping("/modifierProduit")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		produit p = produitService.getProduit(id);
		modelMap.addAttribute("produit", p);
		modelMap.addAttribute("ajout", false);

		Page<produit> prods = produitService.getAllProduitsParPage(page, size);
		modelMap.addAttribute("produits", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "createProduit";
	}

	@RequestMapping("/searchProduit")
	public String searchProduit(@RequestParam(name = "name", defaultValue = "") String name, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<produit> prods = produitService.findByNomProduitContains(name, page, size);
		modelMap.addAttribute("produits", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("name", name);
		return "search";
	}

	@RequestMapping("/updateProduit")
	public String updateProduit(@Valid produit produit,
			BindingResult bindingResult,
			ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) throws ParseException {
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("ajout", false);
			return "createProduit";
		}
		produitService.updateProduit(produit);
		Page<produit> prods = produitService.getAllProduitsParPage(page, size);
		modelMap.addAttribute("produits", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "search";
	}

	@RequestMapping("/updateCategorie")
	public String updateCategorie(@Valid Categorie categorie,
			BindingResult bindingResult,
			ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) throws ParseException {
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("ajout", false);
			return "createCategorie";
		}
		categorieService.updateCategorie(categorie);
		Page<Categorie> cats = categorieService.getAllCategoriesParPage(page, size);
		modelMap.addAttribute("categories", cats);
		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeCategories";
	}

}

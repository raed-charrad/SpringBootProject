package com.example.produits.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.produits.entities.produit;
import com.example.produits.service.ProduitService;
@Controller
public class CatController {
	@Autowired
	 ProduitService produitService;
	@RequestMapping("/showCreate")
	public String showCreate()
	 {
	 return "createProduit";
	 }
	@RequestMapping("/saveProduit")
	public String saveProduit(@ModelAttribute("produit") produit produit,
	 @RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException
	 {
	 //conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	produit.setDateCreation(dateCreation);
	 produit saveProduit = produitService.saveProduit(produit);
	 String msg ="produit enregistré avec Id "+saveProduit.getIdProduit();
	 modelMap.addAttribute("msg", msg);
	 return "createProduit";
	 } 
	@RequestMapping("/ListeProduits")
	public String listeProduits(
	ModelMap modelMap,
	@RequestParam(name = "page", defaultValue = "0") int page,
	@RequestParam(name = "size", defaultValue = "2") int size)
	{
	 Page<produit> prods = produitService.getAllProduitsParPage(page, size);
	modelMap.addAttribute("produits", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeProduits";
	} 

	@RequestMapping("/supprimerProduit")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap
	modelMap,
	 @RequestParam(name = "page", defaultValue = "0") int page,
	 @RequestParam(name = "size", defaultValue = "2") int size) {
	 produitService.deleteProduitById(id);
	 Page<produit> prods = produitService.getAllProduitsParPage(page,
	size);
	 modelMap.addAttribute("produits", prods);
	 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	 modelMap.addAttribute("currentPage", page);
	 modelMap.addAttribute("size", size);
	 return "listeProduits";
	 }

	@RequestMapping("/modifierProduit")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap,
			 @RequestParam(name = "page", defaultValue = "0") int page,
			 @RequestParam(name = "size", defaultValue = "2") int size)
	 {
		produit p= produitService.getProduit(id);
	 modelMap.addAttribute("produit", p);
	 Page<produit> prods = produitService.getAllProduitsParPage(page,size);
				 modelMap.addAttribute("produits", prods);
				 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
				 modelMap.addAttribute("currentPage", page);
				 modelMap.addAttribute("size", size);
	 return "editerProduit";
	 }
	@RequestMapping("/updateProduit")
	public String updateProduit(@ModelAttribute("produit") produit produit,
	 @RequestParam("date") String date,
	 ModelMap modelMap  ,@RequestParam(name = "page", defaultValue = "0") int page,
	 @RequestParam(name = "size", defaultValue = "2") int size) throws ParseException
	 {
	 //conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 produit.setDateCreation(dateCreation);
	 produitService.updateProduit(produit);
	 Page<produit> prods = produitService.getAllProduitsParPage(page,size);
	 modelMap.addAttribute("produits", prods);
	 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	 modelMap.addAttribute("currentPage", page);
	 modelMap.addAttribute("size", size);
	 return "listeProduits";
	 } 




}

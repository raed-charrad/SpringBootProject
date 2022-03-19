package com.example.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.produits.dao.ProduitRepository;
import com.example.produits.entities.produit;
import com.example.produits.service.ProduitServiceImpl;

@SpringBootTest
class ProduitsApplicationTests {
	
	@Autowired

	private ProduitRepository produitRepository;
	@Autowired
	private ProduitServiceImpl service; 

	@Test
	public void contextLoads() {
		
	}
	@Test
	public void testFindByNomProduitContains()
	 {
	 Page<produit> prods = service.getAllProduitsParPage(0,2);
	 System.out.println(prods.getSize());
	 System.out.println(prods.getTotalElements());

	 System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());});
	}

	@Test
	public void testCreateProduit() {
	produit prod = new produit("PC Asus",1500.500,new Date());
	produitRepository.save(prod);
	//service.saveProduit(prod);
	}
	@Test
	public void testFindProduit()
	 {
	 produit p = produitRepository.findById(1L).get();
//			 
	 System.out.println(p);
	 }

	@Test
	public void testUpdateProduit()
	 {
		produit p = produitRepository.findById(1L).get();
	p.setPrixProduit(2000.0);
	produitRepository.save(p);

	 System.out.println(p);
	 }

	@Test
	public void testDeleteProduit()
	 {
	 produitRepository.deleteById(1L);
	 } 

	@Test
	public void testFindAllProduits()
	 {
	 List<produit> prods = produitRepository.findAll();
	
	 for (produit p:prods)
	 System.out.println(p);
	
	 }

}

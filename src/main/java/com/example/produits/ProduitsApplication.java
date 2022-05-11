package com.example.produits;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.produits.dao.UserRepository;
import com.example.produits.entities.User;
import com.example.produits.entities.produit;
import com.example.produits.service.ProduitServiceImpl;

@SpringBootApplication
public class ProduitsApplication implements CommandLineRunner{
	@Autowired
	private ProduitServiceImpl service;
	@Autowired
	private UserRepository UserRepo;
	public static void main(String[] args) {
	 SpringApplication.run(ProduitsApplication.class, args);
	 }
	@Override
	public void run(String... args) throws Exception {
	 // TODO Auto-generated method stub
	  produit prod1 = new produit("PC Asus",1500.500,new Date());
	  produit prod2 = new produit("PC Dell",2000.500,new Date());
	  produit prod3 = new produit("PC Toshiba",2500.500,new Date());
	  service.saveProduit(prod1);
	  service.saveProduit(prod2);
	  service.saveProduit(prod3);
	  User u1= new User();
	  u1.setUsername("admin");
	  u1.setPassword("admin");
	  UserRepo.save(u1);
	 }
}
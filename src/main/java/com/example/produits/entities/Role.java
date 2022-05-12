package com.example.produits.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	 @Id
	 @Column(name = "role_id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 public Long getId() {
	 return id;
	 }
	 public Role(String name) {
	 super(); 
	 this.name = name;
	 }
	 
	public Role() {
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 

 

}

package com.example.produits.dao;

import java.util.List;
import java.util.Optional;

import com.example.produits.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String role);
    Optional<Role> findById(Long id);
    List<Role> findAll();
}

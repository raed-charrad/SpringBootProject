package com.example.produits.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.produits.dao.RoleRepository;
import com.example.produits.entities.Role;
import com.example.produits.entities.UserForm;
import com.example.produits.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @RequestMapping("/register")
    public String register(ModelMap modelMap) {
        List<Role> roles = roleRepository.findAll();
        modelMap.addAttribute("roles", roles);
        modelMap.addAttribute("user", new UserForm());
        return "register";
    }
    @RequestMapping("/saveUser")
    public String saveUser(@Valid UserForm userForm,ModelMap modelMap, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Role> roles = roleRepository.findAll();
            modelMap.addAttribute("roles", roles);
            modelMap.addAttribute("user", new UserForm());
            return "register";
        }
        userService.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
        return "login";

    }

}

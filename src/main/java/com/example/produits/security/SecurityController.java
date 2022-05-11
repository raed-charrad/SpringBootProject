package com.example.produits.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {
	@GetMapping("/accessDenied")
	    public String geterror() {
	        return "accessDenied";
	    }
    @PostMapping("/accessDenied")
	    public String posterror() {
	        return "accessDenied";
	    }
    @GetMapping("/login")
	    public String login()
	    {
	    return "login";
	    } 
    @GetMapping("/logout")
	    public String logout(HttpServletRequest request) throws ServletException
	    {
	    request.logout();
	    return "redirect:/login";
	    }
} 

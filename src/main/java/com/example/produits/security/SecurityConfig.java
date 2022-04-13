package com.example.produits.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 // TODO Auto-generated method stub
auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
auth.inMemoryAuthentication().withUser("Najla").password("{noop}123").roles("AGENT","USER");
auth.inMemoryAuthentication().withUser("user1").password("{noop}123").roles("USER");
 }
@Override
protected void configure(HttpSecurity http) throws Exception {
 // TODO Auto-generated method stub
 http.authorizeRequests().antMatchers("/showCreate","/saveProduit").hasAnyRole("ADMIN","AGENT");
 http.authorizeRequests().antMatchers("/ListeProduits").hasAnyRole("ADMIN","AGENT","USER");
 http.authorizeRequests().antMatchers("/supprimerProduit","/modifierProduit","/updateProduit").hasAnyRole("ADMIN");
 http.authorizeRequests().anyRequest().authenticated();
 http.formLogin();

 }

} 

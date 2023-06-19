package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Produit;
import com.inti.service.IProduitService;



@Controller
public class ProduitController {
	
	@Autowired
	IProduitService ips;
	
	@GetMapping("affichage")
	public String affichageNomProduit(@RequestParam(value = "nom", required = true, defaultValue = "Samsung S23") String nom, Model m)
	{
		m.addAttribute("nom", nom);
		
		return "afficherNomProduit";
	}
	
	@GetMapping("prix")
	public String affichagePrixProduit(@RequestParam(value = "prix", required = true, defaultValue = "1099") double prix, Model m)
	{
		m.addAttribute("prix", prix);
		
		return "afficherPrixProduit";
	}
	
	
	@GetMapping("ajouterP")
	public String ajoutProduit()
	{
		return "ajouterProduit";
	}
	
	@PostMapping("saveProduit")
	public String enregistrerProduit(@ModelAttribute("prod") Produit p)
	{
		ips.saveProduit(p);
		
		return "redirect:/afficherProduits";
	}
	
	@GetMapping("afficherProduits")
	public String afficherProduits(Model m)
	{
		m.addAttribute("listeP", ips.getProduits());
		
		return "afficherProduits";
	}
	
	@GetMapping("deleteProduit/{id}")
	public String deleteProduit(@PathVariable int id)
	{
		ips.deleteProduit(id);
		return "redirect:/afficherProduits";
	}
	
	@GetMapping("getProduit/{id}")
	public String getProduit(@PathVariable int id, Model m)
	{
		m.addAttribute("produit", ips.getProduit(id));
		
		return "updateProduit";
	}
}
	

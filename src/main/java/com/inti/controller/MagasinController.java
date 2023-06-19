package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Magasin;
import com.inti.service.IMagasinService;

@Controller
public class MagasinController {
	@Autowired
	IMagasinService ims;
	
	
	@GetMapping("ajouterM")
	public String ajoutMagasin()
	{
		return "ajouterMagasins";
	}
	
	@PostMapping("saveMagasin")
	public String enregistrerMagasin(@ModelAttribute("mag") Magasin m)
	{
		ims.saveMagasin(m);
		
		return "redirect:/afficherMagasins";
	}
	
	@GetMapping("afficherMagasins")
	public String afficherMagasins(Model m)
	{
		m.addAttribute("listeM", ims.getMagasins());
		
		return "afficherMagasins";
	}
	
	@GetMapping("deleteMagasin/{id}")
	public String deleteMagasin(@PathVariable int id)
	{
		ims.deleteMagasin(id);
		return "redirect:/afficherMagasins";
	}
	
	@GetMapping("getMagasin/{id}")
	public String getMagasin(@PathVariable int id, Model m)
	{
		m.addAttribute("Magasin", ims.getMagasin(id));
		
		return "updateMagasin";
	}

}

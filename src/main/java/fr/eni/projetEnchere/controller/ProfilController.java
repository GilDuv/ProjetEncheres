package fr.eni.projetEnchere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.projetEnchere.bll.UtilisateurService;
import fr.eni.projetEnchere.bo.Utilisateur;

@Controller
public class ProfilController {
	
	private UtilisateurService utilisateurService;
	
	public ProfilController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	@GetMapping("/creation")
	public String creationCompte(Model model) {		
		model.addAttribute("utilisateurs", new Utilisateur());
		
		return "profilCreation";
	}
	
	@PostMapping("/creation")
	public String creationCompte(@ModelAttribute("utilisateurs") Utilisateur utilisateur ) {
		System.out.println("nouveau utilisateur :" + utilisateur);
		this.utilisateurService.creerUtilisateur(utilisateur);
		return "redirect:/";
		
	}

	@GetMapping("/modification")
    public String modificationCompte(@RequestParam("pseudo") String pseudo, Model model) {
       Utilisateur u = this.utilisateurService.consulterUtilisateurParId(pseudo);
       model.addAttribute("utilisateur",u);
       return "profilModification";
	}
	
	@PostMapping("/modification")
	public String modificationCompte(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		System.out.println("utilisateur modifié :" + utilisateur);
		this.utilisateurService.modifierUtilisateur(utilisateur);
		return "redirect:/";
	}
	
}

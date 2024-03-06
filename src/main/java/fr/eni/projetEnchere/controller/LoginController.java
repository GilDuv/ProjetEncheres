package fr.eni.projetEnchere.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.projetEnchere.bll.UtilisateurService;
import fr.eni.projetEnchere.bo.Utilisateur;

@Controller
public class LoginController {

	UtilisateurService utilisateurService;
	
	private PasswordEncoder passwordEncoder;
	
	public LoginController(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder) {
		this.utilisateurService = utilisateurService;
		this.passwordEncoder = passwordEncoder;
	}


	@GetMapping("/connexion")
	public String affichageConnexion() {
		return "connexion";
	}
	
	

}

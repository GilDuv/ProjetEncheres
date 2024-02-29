package fr.eni.projetEnchere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AffichageControler {
	
	@GetMapping("/")
		public String affichageAccueil() {
			return "index";
		}

}

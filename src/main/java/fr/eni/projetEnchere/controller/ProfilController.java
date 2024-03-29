package fr.eni.projetEnchere.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.projetEnchere.bll.UtilisateurService;
import fr.eni.projetEnchere.bo.Utilisateur;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProfilController {

	private UtilisateurService utilisateurService;
	
	private PasswordEncoder passwordEncoder;


	public ProfilController(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder) {
		this.utilisateurService = utilisateurService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/creation")
	public String creationCompte(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());

		return "profilCreation";
	}

	@PostMapping("/creation")
	public String creationCompte(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
			BindingResult bindingResult,Model model) {
		
		try {

			if(bindingResult.hasErrors()) {
				return "profilCreation";
			}else {
				this.utilisateurService.creerUtilisateur(utilisateur);
				System.out.println("nouveau utilisateur :" + utilisateur);
				return "redirect:/";			
			}
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("errorMessagePseudo", "Le pseudo ou l'email est déjà utilisé. Veuillez en choisir un autre.");
            return "profilCreation";
		}
	}

		

	@GetMapping("/modification")
	public String modificationCompte(@RequestParam("noUtilisateur") Integer noUtilisateur, Model model) {
		Utilisateur u = this.utilisateurService.consulterUtilisateurParId(noUtilisateur);
		model.addAttribute("utilisateur", u);
		System.out.println(noUtilisateur);
		return "profilModification";
	}

	@PostMapping("/modification")
	public String modificationCompte(@ModelAttribute(name="utilisateurs") Utilisateur utilisateur,
	        @RequestParam("nouveauMotDePasse") String nouveauMotDePasse,
	        @RequestParam("confirmationMotDePasse") String confirmationMotDePasse) {
		if (nouveauMotDePasse.equals(confirmationMotDePasse)) {
            // Mettez à jour le mot de passe dans la base de données
            utilisateur.setMotDePasse(passwordEncoder.encode(nouveauMotDePasse));
            utilisateurService.modifierUtilisateur(utilisateur);
		}else {
		utilisateurService.modifierUtilisateur(utilisateur);
		}
		return "redirect:/";
	}
	
	@GetMapping("/supprimer")
	public String supprimerUtilisateur(@RequestParam("noUtilisateur") Integer noUtilisateur, HttpSession session) {
		utilisateurService.supprimerUtilisateur(noUtilisateur);
		session.invalidate();
		return "redirect:/";
	}
	

}

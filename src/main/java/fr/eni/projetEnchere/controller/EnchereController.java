package fr.eni.projetEnchere.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import fr.eni.projetEnchere.bll.ArticleService;
import fr.eni.projetEnchere.bll.UtilisateurService;
import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Enchere;
import fr.eni.projetEnchere.bo.Utilisateur;

public class EnchereController {
	
	private UtilisateurService utilisateurService;
	
	private ArticleService articleService;
	
	
	
	public EnchereController(UtilisateurService utilisateurService, ArticleService articleService) {
		super();
		this.utilisateurService = utilisateurService;
		this.articleService = articleService;
	}



	
	

	// ...

	@PostMapping("/enchere")
	public String faireEnchere(@RequestParam("noArticle") Integer noArticle, Model model, Authentication authentication) {
	    // Récupérer l'utilisateur connecté
	    Utilisateur utilisateur = (Utilisateur) authentication.getPrincipal();

	    // ... autres logiques pour gérer l'enchère
	    Enchere enchere = new Enchere();
		model.addAttribute("enchere",enchere);
		model.addAttribute("article", articleService.getArticleById(noArticle));
		System.out.println(enchere);
	    return "article-detail";
	}
}

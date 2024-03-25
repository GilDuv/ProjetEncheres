package fr.eni.projetEnchere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.projetEnchere.bll.ArticleService;
import fr.eni.projetEnchere.bll.CategorieService;

import fr.eni.projetEnchere.bll.UtilisateurService;
import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;


@Controller
public class AffichageControler {
	
	//Service
	private ArticleService articleService;
	private UtilisateurService utilisateurService;
	private CategorieService categorieService;


	
	//Controller Service
	
	

	public AffichageControler(ArticleService articleService, UtilisateurService utilisateurService,
			CategorieService categorieService) {
		this.articleService = articleService;
		this.utilisateurService = utilisateurService;
		this.categorieService = categorieService;
	}


	@GetMapping("/")
		public String affichageAccueil(Model model,
				@RequestParam(name = "q",required = false) String query,
				@RequestParam(name = "category",required = false) Integer category,
				@RequestParam(name = "type",required = false) String type,
				@RequestParam(name = "vente",required = false) List<String> ventesChecked,
				@RequestParam(name = "achat",required = false) List<String> achatsChecked) {
		
		System.err.println(query);
		System.err.println(type);
		System.err.println(ventesChecked);
		System.err.println(achatsChecked);
		model.addAttribute("categories", categorieService.consulterCategorie());
		
		List<Article> article = this.articleService.consulterArticles();
		List<Categorie> categorieSession = categorieService.consulterCategorie();
		
		if(query!=null || category!=null ) {
			article = articleService.search(query, category, type);
		}
		
		
		model.addAttribute("article", article);
		model.addAttribute("categorieSession", categorieSession);
			return "index";
		}




}

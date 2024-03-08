package fr.eni.projetEnchere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eni.projetEnchere.bll.ArticleService;
import fr.eni.projetEnchere.bll.CategorieService;
import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;

@Controller
public class AffichageControler {
	
	//Service
	private ArticleService articleService;
	private CategorieService categorieService;
	//Controller Service
	public AffichageControler(ArticleService articleService, CategorieService categorieService) {
		this.articleService = articleService;
		this.categorieService = categorieService;
	}
	
	
	
	@GetMapping("/")
		public String affichageAccueil(Model model) {
		List<Article> article = this.articleService.consulterArticles();
		List<Categorie> categorieSession = categorieService.consulterCategorie();
		
		model.addAttribute("article", article);
		model.addAttribute("categorieSession", categorieSession);
			return "index";
		}




}

package fr.eni.projetEnchere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.TPFilmotheque.bo.Participant;
import fr.eni.projetEnchere.bll.ArticleService;
import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.ArticleRepository;

@Controller
public class EnchereController {
	
	private ArticleService articleService;

	private ArticleRepository articleRepository;
	
	

	public EnchereController(ArticleService articleService) {
		this.articleService = articleService;
	}

	public EnchereController(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	@GetMapping("/vendre")
	public String vendreArticleForm(Model model) {		
		model.addAttribute("article", new Article());
		
		return "articleVente";
	}
	
	@PostMapping("/vendre")
	public String vendreArticleSubmit(@ModelAttribute("article") Article article) {		
		
		
		return "articleVente";
	}
	
	
	@ModelAttribute("categorieSession")
	public List<Categorie> chargeCategorieEnSession(){
		System.out.println("chargement des categories en session");
		return this.articleService.consulterCategories();
	}
	
}

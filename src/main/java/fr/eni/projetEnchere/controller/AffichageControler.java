package fr.eni.projetEnchere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eni.projetEnchere.bll.ArticleService;
import fr.eni.projetEnchere.bo.Article;

@Controller
public class AffichageControler {
	
	//Service
	private ArticleService articleService;
	//Controller Service
	public AffichageControler(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}

	
	@GetMapping("/")
		public String affichageAccueil(Model model) {
		List<Article> article = this.articleService.consulterArticles();
		
		model.addAttribute("article", article);
			return "index";
		}

}

package fr.eni.projetEnchere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eni.projetEnchere.bll.ArticleService;
import fr.eni.projetEnchere.bo.Article;

@Controller
public class ListArticleController {
	
	//Service
	private ArticleService articleService;
	//Controller Service
	public ListArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
	
	
	@GetMapping("/Liste")
	public String afficherArticle(Model model) {
		List<Article> article = this.articleService.consulterArticles();
		System.out.println(article);
		model.addAttribute("article", article);
		return "article-liste";
	}
	
}

package fr.eni.projetEnchere.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.projetEnchere.bll.ArticleService;
import fr.eni.projetEnchere.bll.CategorieService;
import fr.eni.projetEnchere.bll.UtilisateurService;
import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;

@Controller
@SessionAttributes({"categorieSession"})
public class ArticleController {
		private UtilisateurService utilisateurService;
		
		private CategorieService categorieService;
		
		private ArticleService articleService;
		
		
		
		public ArticleController(UtilisateurService utilisateurService, CategorieService categorieService,
				ArticleService articleService) {
			this.utilisateurService = utilisateurService;
			this.categorieService = categorieService;
			this.articleService = articleService;
		}

		@GetMapping("/vendre")
		public String vendreArticleForm(@RequestParam("noUtilisateur") Integer noUtilisateur, Model model) {		
			model.addAttribute("article", new Article());
			model.addAttribute("utilisateur", this.utilisateurService.consulterUtilisateurParId(noUtilisateur));
			return "articleVente";
		}
		
		@PostMapping("/vendre")
		public String vendreArticleSubmit(@ModelAttribute("article") Article article) {		
			this.articleService.creerArticle(article);
			System.out.println(article);
			return "redirect:/";
		}
		
		
		@ModelAttribute("categorieSession")
		public List<Categorie> chargeCategorieEnSession(){
			System.out.println("chargement des categories en session");
			return this.categorieService.consulterCategorie();
		}
	
		
		//Détails Articles
		@GetMapping("/details/{noArticle}")
		public String afficherArticle(@PathVariable("noArticle") Integer noArticle, Model model) {
		    Optional<Article> optionalArticle = this.articleService.getArticleById(noArticle);
		    if (optionalArticle.isPresent()) {
		        Article article = optionalArticle.get();
		        System.err.println(article);
		        model.addAttribute("article", article);
		    }
		    
		    return "article-detail";
		}


	
	}


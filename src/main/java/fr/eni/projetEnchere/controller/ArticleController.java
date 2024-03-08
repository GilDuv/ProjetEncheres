package fr.eni.projetEnchere.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
import fr.eni.projetEnchere.bll.EnchereService;
import fr.eni.projetEnchere.bll.UtilisateurService;
import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Enchere;
import fr.eni.projetEnchere.bo.Utilisateur;

@Controller
@SessionAttributes({"categorieSession"})
public class ArticleController {
		private UtilisateurService utilisateurService;
		
		private CategorieService categorieService;
		
		private ArticleService articleService;
		
		private EnchereService enchereService;
		
		
		public ArticleController(UtilisateurService utilisateurService, CategorieService categorieService,
				ArticleService articleService, EnchereService enchereService) {
			this.utilisateurService = utilisateurService;
			this.categorieService = categorieService;
			this.articleService = articleService;
			this.enchereService = enchereService;
		}

		@GetMapping("/vendre")
		public String vendreArticleForm(@RequestParam("noUtilisateur") Integer noUtilisateur,Utilisateur utilisateur, Model model) {		
			Article article = new Article();
			model.addAttribute("article",article );
			model.addAttribute("utilisateur", utilisateurService.consulterUtilisateurParId(noUtilisateur));
			return "articleVente";
		}
		
		@PostMapping("/vendre")
		public String vendreArticleSubmit(@ModelAttribute(name="article") Article article, Utilisateur utilisateur,Model model) {
			
			// On Obtient l'utilisateur actuellement authentifié à partir de Spring Security
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			
			 // Utilisation du service utilisateur pour récupérer l'objet Utilisateur associé au nom d'utilisateur
		    Utilisateur utilisateurVendeur = utilisateurService.consulterUtilisateurParPseudo(username);
			

		    // Association de l'utilisateur (vendeur) à l'article
			 Utilisateur vendeur = new Utilisateur();
		     article.setVendeur(vendeur);
		        
			model.addAttribute("utilisateur", utilisateurService.consulterUtilisateurParId(utilisateur.getNoUtilisateur()));
			article.getVendeur().setNoUtilisateur(utilisateur.getNoUtilisateur());
			article.getVendeur().setPseudo(utilisateur.getPseudo());
			article.getVendeur().setNom(utilisateur.getNom());
			article.getVendeur().setPrenom(utilisateur.getPrenom());
			article.getVendeur().setEmail(utilisateur.getEmail());
			article.getVendeur().setTelephone(utilisateur.getTelephone());
			article.getVendeur().setRue(utilisateur.getRue());
			article.getVendeur().setCodePostal(utilisateur.getCodePostal());
			article.getVendeur().setVille(utilisateur.getVille());
			article.getVendeur().setMotDePasse(utilisateur.getMotDePasse());
			
			this.articleService.creerArticle(article,utilisateur);
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

		@PostMapping("/enchere/{noArticle}")
		public String soumettreEnchere(@PathVariable("noArticle") Integer noArticle, @RequestParam("montant_enchere") Integer montantEnchere, Model model,
				@AuthenticationPrincipal Utilisateur utilisateur // utilisateur connecté
				) {
		    Optional<Article> optionalArticle = articleService.getArticleById(noArticle);
		    if (optionalArticle.isPresent()) {
		        Article article = optionalArticle.get();
		        if (montantEnchere > article.getMiseAPrix() && montantEnchere > article.getPrixVente()) {
		           // faut utiliser th:field et th:object dans form
		            Enchere enchere = new Enchere();
		            model.addAttribute("enchere", articleService.getArticleById(noArticle));
		            enchere.setDateEnchere(new Date());
		            enchere.setMontant_enchere(montantEnchere);
		            enchere.setEnchérisseur(utilisateur);
		            enchere.setArticle(article);
		            System.out.println("ArticleController.soumettreEnchere()");
		            System.err.println(enchere);
		            
		            // Soumettre l'enchère en utilisant EnchereService
		            try {
		                enchereService.creerEnchere(enchere);
		                return "redirect:/"; // Redirection vers une page appropriée après la soumission de l'enchère
		            } catch (IllegalArgumentException e) {
		                model.addAttribute("erreur", e.getMessage());
		                model.addAttribute("article", article);
		                return "article-detail"; // Redirection vers la page de détails de l'article avec un message d'erreur
		            }
		        } else {
		            model.addAttribute("erreur", "La proposition de l'enchérisseur est insuffisante");
		            model.addAttribute("article", article);
		            return "article-detail"; // Redirection vers la page de détails de l'article avec un message d'erreur
		        }
		    } else {
		        // Gérer le cas où l'article n'est pas trouvé
		        return "redirect:/"; // Redirection vers une page appropriée si l'article n'est pas trouvé
		    }
		}

		private Utilisateur getUtilisateurConnecte() {
		    // Implémentation de méthode pour récupérer l'utilisateur connecté
		    return null;
		}


}


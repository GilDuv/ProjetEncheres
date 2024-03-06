package fr.eni.projetEnchere.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;

public interface ArticleRepository {

	List<Article> findAllArticles();
	
	public Article creerArticle(Article article,Utilisateur utilisateur);

	Optional<Article> findArticleById(Integer id);

}

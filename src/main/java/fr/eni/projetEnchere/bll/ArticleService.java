package fr.eni.projetEnchere.bll;

import java.util.List;
import java.util.Optional;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;

public interface ArticleService {
	List<Article> consulterArticles();

	Optional<Article> getArticleById(Integer noArticle);

	

}

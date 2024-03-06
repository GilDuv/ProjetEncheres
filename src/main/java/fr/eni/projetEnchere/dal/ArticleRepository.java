package fr.eni.projetEnchere.dal;

import java.util.List;

import fr.eni.projetEnchere.bo.Article;

public interface ArticleRepository {

	List<Article> findAllArticles();
	
	Article creerArticle(Article article);

}

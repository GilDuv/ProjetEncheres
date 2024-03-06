package fr.eni.projetEnchere.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;

public interface ArticleRepository {

	List<Article> findAllArticles();

	Optional<Article> findArticleById(Integer id);

}

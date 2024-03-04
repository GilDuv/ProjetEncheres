package fr.eni.projetEnchere.bll;

import java.util.List;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;

public interface ArticleService {
	List<Article> consulterArticles();

	List<Categorie> consulterCategories();

}

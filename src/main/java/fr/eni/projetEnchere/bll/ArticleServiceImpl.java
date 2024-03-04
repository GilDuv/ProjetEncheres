package fr.eni.projetEnchere.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.ArticleRepository;

@Primary
public class ArticleServiceImpl implements ArticleService {

	//Couplage faible
	private ArticleRepository articleRepository;
	
	//Constructeur
	public ArticleServiceImpl (ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;		
	}
	//Attribut
	private static List<Article> lstArticles = new ArrayList<>();
	
	
	
	//Methode
	public List<Article> consulterArticles(){
		return lstArticles;
	}



	@Override
	public List<Categorie> consulterCategories() {
		// TODO Auto-generated method stub
		return null;
	}
}

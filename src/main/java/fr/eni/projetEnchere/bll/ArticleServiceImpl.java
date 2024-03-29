package fr.eni.projetEnchere.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.ArticleRepository;

@Service
@Primary
public class ArticleServiceImpl implements ArticleService {

	//Couplage faible
	private ArticleRepository articleRepository;
	
	//Constructeur Couplage faible
	public ArticleServiceImpl (ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;		
	}
	
	
	//Methode
	public List<Article> consulterArticles(){
		return articleRepository.findAllArticles();
	}

	
	public Optional<Article> getArticleById(Integer id) {
	    return articleRepository.findArticleById(id);
	}

	@Override
	public Article creerArticle(Article article,Utilisateur utilisateur) {
		return articleRepository.creerArticle(article, utilisateur);
	}

	@Override
	public List<Article> search(String query,int category,String type){
		return articleRepository.search(query, category, type);
	}



}

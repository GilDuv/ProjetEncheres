package fr.eni.projetEnchere.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.dal.ArticleRepository;

@Service
@Primary
public class ArticleServiceImpl implements ArticleService {

	//Couplage faible
	private ArticleRepository articleRepository;
	
	//Constructeur
	public ArticleServiceImpl (ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;		
	}
	
	
	//Methode
	public List<Article> consulterArticles(){
		return articleRepository.findAllArticles();
	}
}

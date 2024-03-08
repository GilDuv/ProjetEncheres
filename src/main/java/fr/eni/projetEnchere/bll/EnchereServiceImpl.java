package fr.eni.projetEnchere.bll;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Enchere;
import fr.eni.projetEnchere.dal.EnchereRepository;


@Service
@Primary
public class EnchereServiceImpl implements EnchereService{
	
	// Couplage faible 
	private EnchereRepository enchereRepository;
	//Constructeur Couplage faible
	public EnchereServiceImpl(EnchereRepository enchereRepository) {
		super();
		this.enchereRepository = enchereRepository;
	}
	
	//Méthode
	
	public Enchere creerEnchere(Enchere enchere) {
		
		Article article = enchere.getArticle();
		//Vérifier dans la Bd qui est déjà supérieur
		if (enchere.getMontant_enchere() > article.getMiseAPrix()) {
			return enchereRepository.creerEnchere(enchere);
		}else {
			throw new IllegalArgumentException("La proposition de l'enchérisseur est insuffisante");
		}
		
	}




	
}

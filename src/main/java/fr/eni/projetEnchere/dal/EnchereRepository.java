package fr.eni.projetEnchere.dal;

import java.util.List;

import fr.eni.projetEnchere.bo.Enchere;

public interface EnchereRepository {

	List<Enchere> findAllEncheres();

	Enchere creerEnchere(Enchere enchere);
	
	
}

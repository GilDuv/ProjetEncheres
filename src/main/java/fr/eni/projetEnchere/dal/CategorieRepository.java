package fr.eni.projetEnchere.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.projetEnchere.bo.Categorie;

public interface CategorieRepository {
	
	public List<Categorie> findAllCategorie();

	public Optional<Categorie> findCategorieById(Integer noCategorie);
	
}

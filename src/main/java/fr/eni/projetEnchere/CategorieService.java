package fr.eni.projetEnchere;

import java.util.List;

import fr.eni.projetEnchere.bo.Categorie;

public interface CategorieService {

	public List<Categorie> consulterCategorie();
	public Categorie consulterCategorieParId(Integer noCategorie);
}

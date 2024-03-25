package fr.eni.projetEnchere.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.projetEnchere.bll.CategorieService;
import fr.eni.projetEnchere.bo.Categorie;

@Component
public  class StringToCategorieConverter implements Converter<String, Categorie>{

	private CategorieService categorieService;
	
	public StringToCategorieConverter(CategorieService categorieService) {
		this.categorieService = categorieService;
	}

	@Override
	public Categorie convert(String noCategorie) {
		Categorie categorie= this.categorieService.consulterCategorieParId(Integer.parseInt(noCategorie));
		return categorie;
	}

}

package fr.eni.projetEnchere.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.projetEnchere.bll.UtilisateurService;
import fr.eni.projetEnchere.bo.Utilisateur;

@Component
public class StringToUtilisateurConverter implements Converter<String, Utilisateur>{
	
	private UtilisateurService utilisateurService;

	public StringToUtilisateurConverter(UtilisateurService utilisateurService) {
		super();
		this.utilisateurService = utilisateurService;
	}

	@Override
	public Utilisateur convert(String noUtilisateur) {
		int noUtilisateurEntier = Integer.parseInt(noUtilisateur);
		Utilisateur utilisateur = this.utilisateurService.consulterUtilisateurParId(noUtilisateur);
		
		return utilisateur;
	}
	
	
	

}

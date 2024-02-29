package fr.eni.projetEnchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.UtilisateurRepository;

public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurRepository utilisateurRepository;
	
	
	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
				
	}
	//Attribut static
	private static List<Utilisateur> lstUtilisateur = new ArrayList<>();
	
	
	//Methode
	
	public List<Utilisateur> consulterUtilisateurs(){
		return utilisateurRepository.findAllProfil();
	}
	
	public Utilisateur consulterUtilisateurParId(Integer id) {
		return lstUtilisateur.stream().filter(item -> item.getNoUtilisateur() == id).findAny().orElse(null);
	}
	
	
}

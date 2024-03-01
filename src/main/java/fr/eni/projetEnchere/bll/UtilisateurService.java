package fr.eni.projetEnchere.bll;

import java.util.List;

import fr.eni.projetEnchere.bo.Utilisateur;

public interface UtilisateurService {
	
	public List<Utilisateur> consulterUtilisateurs();
	
	public Utilisateur consulterUtilisateurParId(String pseudo);
	
	public void creerUtilisateur(Utilisateur utilisateur);
	
	public void supprimerUtilisateur(Integer idUtilisateur);
	
	public void modifierUtilisateur(Utilisateur utilisateur);

	
	
}

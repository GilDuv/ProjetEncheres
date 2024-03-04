package fr.eni.projetEnchere.bll;

import java.util.List;

import fr.eni.projetEnchere.bo.Utilisateur;

public interface UtilisateurService {
	
	public List<Utilisateur> consulterUtilisateurs();
	
	public Utilisateur consulterUtilisateurParPseudo(String pseudo);
	
	public Utilisateur consulterUtilisateurParId(Integer noUtilisateur);
	
	public void creerUtilisateur(Utilisateur utilisateur);
	
	public void supprimerUtilisateur(Integer idUtilisateur);
	
	public void modifierUtilisateur(Utilisateur utilisateur);

	
	
}

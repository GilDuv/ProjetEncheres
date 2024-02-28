package fr.eni.projetEnchere.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.projetEnchere.bo.Utilisateur;

public interface UtilisateurRepository {

	public List<Utilisateur>  findAllProfil();
	
	public Optional<Utilisateur> findProfilByPseudo(String pseudo);
	
	public Utilisateur creerProfil(Utilisateur utilisateur);
	
	public Utilisateur modifierProfil(Utilisateur utilisateur);
	
	public void supprimerProfil(Integer idUtilisateur);
	
	
}

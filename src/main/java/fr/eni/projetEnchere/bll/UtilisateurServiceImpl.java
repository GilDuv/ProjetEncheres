package fr.eni.projetEnchere.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.UtilisateurRepository;
import fr.eni.projetEnchere.exceptions.UtilisateurNotFoundRuntimeException;


@Primary
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurRepository utilisateurRepository;
	
	
	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
				
	}
	//Attribut static
	private static List<Utilisateur> lstUtilisateur = new ArrayList<>();
	private static int indexUtilisateur = 1;
	
	
	//Methode
	
	public List<Utilisateur> consulterUtilisateurs(){
		return utilisateurRepository.findAllProfil();
	}
	
	public Utilisateur consulterUtilisateurParId(String pseudo) {
		Optional<Utilisateur> optGenre = utilisateurRepository.findProfilByPseudo(pseudo);
		
		if(optGenre.isPresent()) {
			return optGenre.get();
		}
		
		throw new UtilisateurNotFoundRuntimeException(); 
	}
	
	public void creerUtilisateur(Utilisateur utilisateur) {
		//Sauvegarde de l'utilisateur
		utilisateur.setNoUtilisateur(indexUtilisateur++);
		lstUtilisateur.add(utilisateur);
	}
	
}

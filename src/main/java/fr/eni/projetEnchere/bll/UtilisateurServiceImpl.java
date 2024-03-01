package fr.eni.projetEnchere.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.UtilisateurRepository;
import fr.eni.projetEnchere.exceptions.UtilisateurNotFoundRuntimeException;

@Service
@Primary
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurRepository utilisateurRepository;
	
	
	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
				
	}
	
	//Attribut static
	//private static List<Utilisateur> lstUtilisateur = new ArrayList<>();
	//private static int indexUtilisateur = 1;
	
	
	//Methode
	
	public List<Utilisateur> consulterUtilisateurs(){
		return utilisateurRepository.findAllProfil();
	}
	
	public Utilisateur consulterUtilisateurParId(String pseudo) {
		Optional<Utilisateur> optPseudo = utilisateurRepository.findProfilByPseudo(pseudo);
		
		if(optPseudo.isPresent()) {
			return optPseudo.get();
		}
		
		throw new UtilisateurNotFoundRuntimeException(); 
	}

	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		//Sauvegarde de l'utilisateur
		//utilisateur.setNoUtilisateur(indexUtilisateur++);
		//lstUtilisateur.add(utilisateur);
		System.err.println("UtilisateurServiceImpl.creerUtilisateur()");
		return utilisateurRepository.creerProfil(utilisateur);
	}
	
	public void supprimerUtilisateur(Integer idUtilisateur) {
		utilisateurRepository.supprimerProfil(idUtilisateur);
	}
	
	public void modifierUtilisateur(Utilisateur utilisateur) {
		utilisateurRepository.modifierProfil(utilisateur);
	}


	
}

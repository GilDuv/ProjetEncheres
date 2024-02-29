package fr.eni.projetEnchere.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Component;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.UtilisateurRepository;


	@Component
	public class TrocencheresUserDetailService implements UserDetailsService {
		private UtilisateurRepository utilisateurRepository;
		
		public TrocencheresUserDetailService(UtilisateurRepository utilisateurRepository) {
			this.utilisateurRepository = utilisateurRepository;
		}


		//loadUserByUsername est appelée par Spring à chaque fois 
		// qu'un utilisateur se connecte
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
			Optional<Utilisateur> optUtilisateur = utilisateurRepository.findProfilByPseudo(username);

			if(optUtilisateur.isEmpty()) {
				throw new UsernameNotFoundException("utilisateur non trouve : "+username);
			}

			Utilisateur utilisateur = optUtilisateur.get();
			
			 UserBuilder userBuilder = User.withUsername(utilisateur.getPseudo())
	            .password(utilisateur.getMotDePasse())
	            .roles("Utilisateur");
			 
			 if(utilisateur.isAdministrateur()) {
				 userBuilder.roles("Utilisateur", "ADMINISTRATEUR");
			 }	
			 UserDetails user = userBuilder.build();
			 
			
			return user;
		}

		
}


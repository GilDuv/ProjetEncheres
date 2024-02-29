package fr.eni.projetEnchere;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.UtilisateurRepositoryImpl;
import fr.eni.projetEnchere.exceptions.UtilisateurNotFound;

@SpringBootTest
public class UtilisateurApplicationTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UtilisateurRepositoryImpl utilisateurRepository;
	
	@Test
	@DisplayName("Test findAllProfil")
	void testFindAllUtilisateur() {
		List<Utilisateur> utilisateurResultat = utilisateurRepository.findAllProfil();
		System.out.println(utilisateurResultat);
	}
	
	@Test
	@DisplayName("Test findProfilByPseudo")
	void testFindProfilByPseudo() {
		//on applique la méthode pour trouver le genre par l'id
		Optional<Utilisateur> optUtilisateur = utilisateurRepository.findProfilByPseudo("bool");
		//on vérifie que l'utilisateur est présent 
		assertTrue(optUtilisateur.isPresent());
		//on compare le pseudo test avec le pseudo présent dans sql
		assertEquals("bool", optUtilisateur.get().getPseudo());
		//on compare la liste avec la liste présente dans sql
		assertEquals(new Utilisateur(1,"bool","Dupont","Bernard","beber@live.fr","0652764587","18 rue du soleil","44000","nantes","pa$$w0rd",0,true), optUtilisateur.get());
		System.out.println(optUtilisateur);
	}
	
	@Test
	@DisplayName("Test creerProfil")
	void testCreerProfil() {
		Utilisateur utilisateur=new Utilisateur("boby", "Marley", "Bob", "boby@gmail.com", "0685749632", "39 rue de la paix", "44000", "Nantes", "Pa$$w0rd", 0, false);
		Utilisateur utilisateurResultat;
		try {
			utilisateurResultat = utilisateurRepository.creerProfil(utilisateur);
			assertNotNull(utilisateurResultat);
			System.out.println(utilisateurResultat);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	

	@Test
	@DisplayName("Test modifierProfil")
	void testmodifierProfil() throws UtilisateurNotFound{
		Utilisateur utilisateur = new Utilisateur(1,"bool","Dupont","Bernard","beber44@live.fr","0652764587","18 rue du soleil","44000","nantes","pa$$w0rd",0,true);
		utilisateurRepository.modifierProfil(utilisateur);
		Optional<Utilisateur> optUtilisateur = utilisateurRepository.findProfilByPseudo("bool");
		assertTrue(optUtilisateur.isPresent());
		assertEquals("beber44@live.fr", optUtilisateur);
		
	}
	
}

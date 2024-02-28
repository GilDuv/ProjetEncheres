package fr.eni.projetEnchere;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.UtilisateurRepositoryImpl;

@SpringBootTest
public class UtilisateurApplicationTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UtilisateurRepositoryImpl utilisateurRepository;
	
	@Test
	@DisplayName("Test findAllUtilisateur")
	void testFindAllUtilisateur() {
		List<Utilisateur> utilisateurResultat = utilisateurRepository.findAllProfil();
		System.out.println(utilisateurResultat);
	}
	
	
}

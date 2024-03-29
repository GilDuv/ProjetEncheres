package fr.eni.projetEnchere;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.UtilisateurRepositoryImpl;
import fr.eni.projetEnchere.exceptions.UtilisateurNotFound;

@SpringBootTest
public class UtilisateurApplicationTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UtilisateurRepositoryImpl utilisateurRepository;
	
	@BeforeEach
	void initTest() {
		jdbcTemplate.execute(" DELETE FROM UTILISATEURS");
		jdbcTemplate.execute("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)VALUES ('bool','Dupont','Bernard','beber@live.fr','0652764587','18 rue du soleil','44000','nantes','{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,true)");
		jdbcTemplate.execute("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)VALUES ('Rintintin','Durant','David','tontondavid@live.fr','0652765648','18 rue du soleil levant','79000','niort','{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,false)");
//		jdbcTemplate.execute("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)VALUES (1,'bool','Dupont','Bernard','beber@live.fr','0652764587','18 rue du soleil','44000','nantes','{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,true)");
//		jdbcTemplate.execute("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)VALUES (2,'Rintintin','Durant','David','tontondavid@live.fr','0652765648','18 rue du soleil levant','79000','niort','{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,false)");
	}
	
//	@BeforeEach
//	void initTest() {
//		jdbcTemplate.execute(" DELETE FROM UTILISATEURS");
//		jdbcTemplate.execute("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)VALUES ('bool','Dupont','Bernard','beber@live.fr','0652764587','18 rue du soleil','44000','nantes','{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,true)");
//		jdbcTemplate.execute("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)VALUES ('Rintintin','Durant','David','tontondavid@live.fr','0652765648','18 rue du soleil levant','79000','niort','{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,false)");
//		jdbcTemplate.execute("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)VALUES (1,'bool','Dupont','Bernard','beber@live.fr','0652764587','18 rue du soleil','44000','nantes','{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,true)");
//		jdbcTemplate.execute("INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)VALUES (2,'Rintintin','Durant','David','tontondavid@live.fr','0652765648','18 rue du soleil levant','79000','niort','{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,false)");
//	}
//	
//	@Test
//	@DisplayName("Test findAllProfil")
//	void testFindAllUtilisateur() {
//		List<Utilisateur> utilisateurResultat = utilisateurRepository.findAllProfil();
//		System.out.println("UtilisateurApplicationTest.testFindAllUtilisateur()");
//		System.out.println(utilisateurResultat);
//	}
//	
//	@Test
//	@DisplayName("Test findProfilByPseudo")
//	void testFindProfilByPseudo() {
//		//on applique la méthode pour trouver le genre par l'id
//		Optional<Utilisateur> optUtilisateur = utilisateurRepository.findProfilByPseudo("bool");
//		//on vérifie que l'utilisateur est présent 
//		assertTrue(optUtilisateur.isPresent());
//		//on compare le pseudo test avec le pseudo présent dans sql
//		assertEquals("bool", optUtilisateur.get().getPseudo());
//		//on compare la liste avec la liste présente dans sql
//		assertEquals(new Utilisateur("bool","Dupont","Bernard","beber@live.fr","0652764587","18 rue du soleil","44000","nantes","{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW",0,true), optUtilisateur.get());
//		System.out.println("UtilisateurApplicationTest.testFindProfilByPseudo()");
//		System.out.println(optUtilisateur);
//	}
//	
	@Test
	@DisplayName("Test findProfilById")
	void testFindProfilById() {
		//on applique la méthode pour trouver le genre par l'id
		Optional<Utilisateur> optUtilisateur = utilisateurRepository.findProfilById(61);
		//on vérifie que l'utilisateur est présent 
		assertTrue(optUtilisateur.isPresent());
		//on compare le pseudo test avec le pseudo présent dans sql
		assertEquals(61, optUtilisateur.get().getNoUtilisateur());
		//on compare la liste avec la liste présente dans sql
		assertEquals(new Utilisateur(61,"babass","baba","baba","baba@live.fr","0101010101","baba","79200","baba","$2a$10$65rWcnHaRXsRNG86M9DJOewXcDSlEr2PVmOsM1kDHsZukMIzKYAY2",0,false), optUtilisateur.get());
		System.out.println("UtilisateurApplicationTest.testFindProfilByPseudo()");
		System.out.println(optUtilisateur);
	}
	
//	
//	@Test
//	@DisplayName("Test creerProfil")
//	void testCreerProfil() {
//		Utilisateur utilisateur=new Utilisateur("boby", "Marley", "Bob", "boby@gmail.com", "0685749632", "39 rue de la paix", "44000", "Nantes", "{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW$$w0rd",0,false);
//		Utilisateur utilisateurResultat;
//		try {
//			utilisateurResultat = utilisateurRepository.creerProfil(utilisateur);
//			assertNotNull(utilisateurResultat);
//			System.out.println("UtilisateurApplicationTest.testCreerProfil()");
//			System.out.println(utilisateurResultat);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//
//	
//
//	@Test
//	@DisplayName("Test modifierProfil")
//	void testmodifierProfil() throws UtilisateurNotFound{
//		Utilisateur utilisateur = new Utilisateur("bool","Dupont","Bernard","beber@live.fr","0652764587","18 rue du soleil","44000","Paris","{bcrypt}$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW",0,true);
//		utilisateurRepository.modifierProfil(utilisateur);
//		Optional<Utilisateur> optUtilisateur = utilisateurRepository.findProfilByPseudo("bool");
//		assertTrue(optUtilisateur.isPresent());
//		System.out.println("UtilisateurApplicationTest.testmodifierProfil()");
//
//		assertEquals("Paris", optUtilisateur.get().getVille());
//
//		System.out.println(optUtilisateur);
//		
//	}
//	
}

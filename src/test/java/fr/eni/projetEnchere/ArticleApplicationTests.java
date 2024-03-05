package fr.eni.projetEnchere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.dal.ArticleRepository;
import fr.eni.projetEnchere.dal.UtilisateurRepositoryImpl;

@SpringBootTest
public class ArticleApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ArticleRepository articleRepository;
	
//	@Test
//	@DisplayName("Test creerArticle")
//	void testCreerArticle() {
//		Article article=new Article("pc","pc","05/03/2024","06/03/2024",350,21,1);
//		Article articleResultat;
//		try {
//			articleResultat = articleRepository.creerArticle(article);
//			assertNotNull(articleResultat);
//			System.out.println("UtilisateurApplicationTest.testCreerProfil()");
//			System.out.println(articleResultat);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
}

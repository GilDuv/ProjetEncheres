package fr.eni.projetEnchere.dal;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {


	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public ArticleRepositoryImpl(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
		this.jdbcTemplate = namedJdbcTemplate.getJdbcTemplate();
	}
	
	@Override
	public List<Article> findAllArticles(){
		String sql = "select no_categorie, libelle from Ar"
	}
	
	
}

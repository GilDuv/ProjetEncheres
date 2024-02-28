package fr.eni.projetEnchere.dal;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
 
import fr.eni.projetEnchere.bo.Article;
 
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
		String sql = "select no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente";
		RowMapper<Article> rowMapper = new RowMapper<>() {
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				Article article = new Article();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
				article.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				return article;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
}
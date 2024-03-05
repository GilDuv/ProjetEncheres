package fr.eni.projetEnchere.dal;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
		String sql = "select no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ARTICLES";
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

	@Override
	public Article creerArticle(Article article) {

		String sql="insert into articles (nom_article,description,prix_initial,date_debut_encheres,date_fin_encheres,no_utilisateur,no_categorie) VALUES (:nomArticle,:description,:miseAPrix,:dateDebutEncheres,:dateFinEncheres,:noUtilisateur,:noCategorie)";
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("nom_article", article.getNomArticle());
		parameterSource.addValue("description", article.getDescription());
		parameterSource.addValue("prix_initial", article.getMiseAPrix());
		parameterSource.addValue("date_debut_encheres", article.getDateDebutEncheres());
		parameterSource.addValue("date_fin_encheres", article.getDateFinEncheres());
		parameterSource.addValue("no_utilisateur", article.getVendeur().getNoUtilisateur());
		parameterSource.addValue("no_categorie", article.getCategorieArticle().getNoCategorie());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		int nbrRow = namedJdbcTemplate.update(sql, parameterSource, keyHolder, new String[] {"no_article"});
		article.setNoArticle(keyHolder.getKey().intValue());
		//System.out.println(nbrRow);
		//System.err.println("UtilisateurRepositoryImpl.creerProfil() fin");
		return article;
	}
	

	
	
	
}
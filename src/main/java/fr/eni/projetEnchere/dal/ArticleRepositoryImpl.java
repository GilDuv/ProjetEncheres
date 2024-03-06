package fr.eni.projetEnchere.dal;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;
 
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
		String sql = "SELECT a.*, u.pseudo FROM ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur";
		RowMapper<Article> rowMapper = new RowMapper<>() {
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				Article article = new Article();
				Utilisateur vendeur = new Utilisateur();
				
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
				article.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				
		        // Set du vendeur
		        vendeur.setPseudo(rs.getString("pseudo"));
		        article.setVendeur(vendeur);
				
				
				return article;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

	
	public Article creerArticle(Article article,Utilisateur utilisateur) {		
		
		article.getVendeur().setNoUtilisateur(utilisateur.getNoUtilisateur());
		String sql="insert into articles (nom_article,description,prix_initial,date_debut_encheres,date_fin_encheres,no_utilisateur,no_categorie) VALUES (:nom_article,:description,:prix_initial,:date_debut_encheres,:date_fin_encheres,:no_utilisateur,:no_categorie) ";
		
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
	

	
	
	

	public Optional<Article> findArticleById(Integer noArticle) {
	    String sql = "SELECT a.*, c.libelle, u.pseudo FROM ARTICLES a INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur WHERE a.no_article = ?";
	    System.err.println(sql);

	    Optional<Article> optArticle = null;

	    RowMapper<Article> rowMapper = new RowMapper<Article>() {
	        @Override
	        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Article article = new Article();
	            Utilisateur vendeur = new Utilisateur();
	            Categorie categorie = new Categorie();

	            article.setNoArticle(rs.getInt("no_article"));
	            article.setNomArticle(rs.getString("nom_article"));
	            article.setDescription(rs.getString("description"));
	            article.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
	            article.setDateFinEncheres(rs.getDate("date_fin_encheres"));
	            article.setMiseAPrix(rs.getInt("prix_initial"));
	            article.setPrixVente(rs.getInt("prix_vente"));

	            // Set du vendeur
	            vendeur.setPseudo(rs.getString("pseudo"));
	            article.setVendeur(vendeur);

	            // Set de la categorie
	            categorie.setLibelle(rs.getString("libelle"));
	            article.setCategorieArticle(categorie);

	            return article;
	        }
	    };

	    try {
	        Article article = jdbcTemplate.queryForObject(sql, rowMapper, noArticle);
	        System.out.println(article);
	        optArticle = Optional.of(article);
	    } catch (EmptyResultDataAccessException exc) {
	    
	        optArticle = Optional.empty();
	    }
	    return optArticle;
	}



}
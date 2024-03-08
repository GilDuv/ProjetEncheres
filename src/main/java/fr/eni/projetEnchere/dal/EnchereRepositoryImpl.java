package fr.eni.projetEnchere.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Enchere;
import fr.eni.projetEnchere.bo.Utilisateur;

@Repository
public class EnchereRepositoryImpl implements EnchereRepository{
	//JdbcTemplate
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	
	//Constructeur JdbcTemplate
	public EnchereRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	

	@Override
	public List<Enchere> findAllEncheres(){
		String sql = "SELECT e.*, u.pseudo AS enchere_pseudo, a.nom_article FROM ENCHERES e " +
                "INNER JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur " +
                "INNER JOIN ARTICLES a ON e.no_article = a.no_article";
		
		RowMapper<Enchere> rowMapper = new RowMapper<>() {
			public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
				Enchere enchere = new Enchere();
				Utilisateur encherisseur = new Utilisateur();
				Article article = new Article();
				
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				
		        // Set de l'enchérisseur
		        encherisseur.setNoUtilisateur(rs.getInt("no_utilisateur"));
		        enchere.setEnchérisseur(encherisseur);
		        
		        article.setNoArticle(rs.getInt("no_article"));
		        enchere.setArticle(article);
		        
				return enchere;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	
	@Override
	public Enchere creerEnchere(Enchere enchere) {
	    String sql = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) " +
	                 "VALUES (:no_utilisateur, :no_article, :date_enchere, :montant_enchere)";
	    System.out.println("EnchereRepositoryImpl.creerEnchere()");
	    System.err.println(enchere);
	    MapSqlParameterSource parameterSource = new MapSqlParameterSource();
	    parameterSource.addValue("no_utilisateur", enchere.getEnchérisseur().getNoUtilisateur());
	    parameterSource.addValue("no_article", enchere.getArticle().getNoArticle());
	    parameterSource.addValue("date_enchere", enchere.getDateEnchere());
	    parameterSource.addValue("montant_enchere", enchere.getMontant_enchere());

	    // Exécution de la requête SQL pour insérer une nouvelle enchère
	    namedParameterJdbcTemplate.update(sql, parameterSource);

	    return enchere;
	}

	

}

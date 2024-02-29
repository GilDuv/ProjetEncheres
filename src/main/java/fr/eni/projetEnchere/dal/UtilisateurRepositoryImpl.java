package fr.eni.projetEnchere.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.projetEnchere.bo.Article;
import fr.eni.projetEnchere.bo.Utilisateur;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository{

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public UtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Utilisateur>  findAllProfil() {
		String sql="SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe ,credit,administrateur FROM UTILISATEURS";
				
		RowMapper<Utilisateur> rowMapper= new RowMapper<Utilisateur>() {
			
			@Override
			public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("CodePostal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("motDePasse"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				return utilisateur;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

	
	
	@Override
	public Optional<Utilisateur> findProfilByPseudo(String pseudo) {
		
			String sql="SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe ,credit,administrateur where no_utilisateur = ?";
			Optional<Utilisateur> optUtilisateur =null;
			
			RowMapper<Utilisateur> rowMapper= new RowMapper<Utilisateur>() {
				
				@Override
				public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("CodePostal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("motDePasse"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
					return utilisateur;
				}
			};
			
			
			try {
				Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, rowMapper,pseudo);
				optUtilisateur = Optional.of(utilisateur);
			} catch (EmptyResultDataAccessException exc) {
				optUtilisateur = Optional.empty();
			}
		return optUtilisateur;
	}

	
	
	@Override
	public Utilisateur creerProfil(Utilisateur utilisateur) {
		String sql="insert into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe ,credit,administrateur) values (:pseudo,:nom,:prenom,:email,:telephone,:rue,:code_postal,:ville,mot_de_passe ,:credit,:administrateur";
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("pseudo", utilisateur.getPseudo());
		parameterSource.addValue("nom", utilisateur.getNom());
		parameterSource.addValue("prenom", utilisateur.getPrenom());
		parameterSource.addValue("email", utilisateur.getEmail());
		parameterSource.addValue("telephone", utilisateur.getTelephone());
		parameterSource.addValue("rue", utilisateur.getRue());
		parameterSource.addValue("CodePostal", utilisateur.getCodePostal());
		parameterSource.addValue("ville", utilisateur.getVille());
		parameterSource.addValue("motDePasse", utilisateur.getMotDePasse());
		parameterSource.addValue("credit", utilisateur.getCredit());
		parameterSource.addValue("administrateur", utilisateur.isAdministrateur());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, new String[] {"noUtilisateur"});
		utilisateur.setNoUtilisateur(keyHolder.getKey().intValue());
		
		return utilisateur;
	}

	
	
	@Override
	public Utilisateur modifierProfil(Utilisateur utilisateur) {
		String sql = "update utilisateurs set nom=?, prenom=?, email=?, telephone=?, rue=?, CodePostal=?, ville=?, motDePasse=?, credit=?, administrateur=?";
		
		return null;
	}

	@Override
	public void supprimerProfil(Integer idUtilisateur) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<String> getAllPseudos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> getAllArticlesVendus(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}


	
	



}

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
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.exceptions.UtilisateurNotFoundRuntimeException;

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
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				return utilisateur;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

	
	
	@Override
	public Optional<Utilisateur> findProfilByPseudo(String pseudo) {
		

			String sql="SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe ,credit,administrateur FROM UTILISATEURS WHERE pseudo = ?";


			Optional<Utilisateur> optUtilisateur =null;
			
			RowMapper<Utilisateur> rowMapper= new RowMapper<Utilisateur>() {
				
				@Override
				public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("code_postal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					return utilisateur;
				}
			};
			
			
			try {
				Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, rowMapper,new Object[]{pseudo});
				optUtilisateur = Optional.of(utilisateur);
			} catch (EmptyResultDataAccessException exc) {
				optUtilisateur = Optional.empty();
			}
		return optUtilisateur;
	}

	
	@Override
	public Utilisateur creerProfil(Utilisateur utilisateur) {
		//System.out.println("UtilisateurRepositoryImpl.creerProfil()");
		String sql="insert into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe ,credit,administrateur) values (:pseudo,:nom,:prenom,:email,:telephone,:rue,:code_postal,:ville,:mot_de_passe ,:credit,:administrateur)";
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("pseudo", utilisateur.getPseudo());
		parameterSource.addValue("nom", utilisateur.getNom());
		parameterSource.addValue("prenom", utilisateur.getPrenom());
		parameterSource.addValue("email", utilisateur.getEmail());
		parameterSource.addValue("telephone", utilisateur.getTelephone());
		parameterSource.addValue("rue", utilisateur.getRue());
		parameterSource.addValue("code_postal", utilisateur.getCodePostal());
		parameterSource.addValue("ville", utilisateur.getVille());
		parameterSource.addValue("mot_de_passe", utilisateur.getMotDePasse());
		parameterSource.addValue("credit", utilisateur.getCredit());
		parameterSource.addValue("administrateur", utilisateur.isAdministrateur());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		int nbrRow = namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, new String[] {"no_utilisateur"});
		utilisateur.setNoUtilisateur(keyHolder.getKey().intValue());
		//System.out.println(nbrRow);
		//System.err.println("UtilisateurRepositoryImpl.creerProfil() fin");
		return utilisateur;
	}

	
	
	@Override
	public Utilisateur modifierProfil(Utilisateur utilisateur) {
		String sql = "update utilisateurs set pseudo=?, nom=?, prenom=?, email=?, "
				+ "telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?"
				+" where pseudo=?";
		
		int nbLignes = jdbcTemplate.update(sql,
				utilisateur.getPseudo(),
				utilisateur.getNom(),
				utilisateur.getPrenom(),
				utilisateur.getEmail(),
				utilisateur.getTelephone(),
				utilisateur.getRue(),
				utilisateur.getCodePostal(),
				utilisateur.getVille(),
				utilisateur.getMotDePasse(),
				utilisateur.getPseudo());

		if (nbLignes == 0) {
			throw new UtilisateurNotFoundRuntimeException();
		}
		return utilisateur;
	}
	

	@Override
	public void supprimerProfil(Integer idUtilisateur) {

		String sql = "delete from utilisateurs where no_utilisateur=?";
		int nbLignes = jdbcTemplate.update(sql,idUtilisateur);
		if (nbLignes == 0) {
			throw new UtilisateurNotFoundRuntimeException();
		}
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

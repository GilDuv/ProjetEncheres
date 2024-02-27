package fr.eni.projetEnchere.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
				utilisateur.setAdministrateur(rs.getInt("administrateur"));
				
				return utilisateur;
			}
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Optional<Utilisateur> findProfilById(Integer id) {
		
			String sql="SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe ,credit,administrateur where no_utilisateur = ?";
			Optional<Utilisateur> optUtilisateur =null;
			try {
				Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Utilisateur>(Utilisateur.class),id);
				optUtilisateur = Optional.of(utilisateur);
			} catch (EmptyResultDataAccessException exc) {
				optUtilisateur = Optional.empty();
			}
		return optUtilisateur;
	}

	@Override
	public Utilisateur creerProfil(Utilisateur utilisateur) {
		String sql="insert into utilisateurs";
		return null;
	}

	@Override
	public Utilisateur modifierProfil(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerProfil(Integer idUtilisateur) {
		// TODO Auto-generated method stub
		
	}


	
	



}

package fr.eni.projetEnchere.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
		String sql="SELECT pseudo,nom,prenom,email,telephone,rue,code_postal,ville FROM UTILISATEURS";
				
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Utilisateur.class));
	}



	@Override
	public Utilisateur creerProfil(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
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

	@Override
	public Optional<Utilisateur> findProfilById(Integer id) {
		
			String sql="SELECT pseudo,nom,prenom,email,telephone,rue,code_postal,ville FROM UTILISATEURS where no_utilisateur = ?";
			Optional<Utilisateur> optUtilisateur =null;
			try {
				Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Utilisateur>(Utilisateur.class),id);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		
		return Optional.empty();
	}
	
	



}

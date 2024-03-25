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

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;


@Repository
public class CategorieRepositoryImpl implements CategorieRepository {
	
	//JdbcTemplate
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	//Constructeur JdbcTemplate
	public CategorieRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	

	@Override
	public List<Categorie> findAllCategorie() {
		String sql ="SELECT no_categorie, libelle FROM CATEGORIES";
		
		RowMapper<Categorie> rowMapper = new RowMapper<Categorie>() {
			
			@Override
			public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
				Categorie categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				return categorie;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
	

	@Override
	public Optional<Categorie> findCategorieById(Integer noCategorie) {
		

			String sql="SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = ?";


			Optional<Categorie> optCategorie =null;
			
			RowMapper<Categorie> rowMapper= new RowMapper<Categorie>() {
				
				@Override
				public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
					Categorie categorie = new Categorie();
					categorie.setNoCategorie(rs.getInt("no_categorie"));
					categorie.setLibelle(rs.getString("libelle"));
					return categorie;
				}
			};
			
			
			try {
				Categorie categorie = jdbcTemplate.queryForObject(sql, rowMapper,new Object[]{noCategorie});
				optCategorie = Optional.of(categorie);
			} catch (EmptyResultDataAccessException exc) {
				optCategorie = Optional.empty();
			}
		return optCategorie;
	}


	
	
}

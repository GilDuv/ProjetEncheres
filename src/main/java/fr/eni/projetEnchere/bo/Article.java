package fr.eni.projetEnchere.bo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Article {

	private Integer noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
	
	private Utilisateur acheteur;
	private Utilisateur vendeur;
	List<Enchere> encheres;
	private Categorie categorieArticle;
	private Retrait lieuRetrait;
	
	public Article() {
	}
 
	
	
	public Article(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			Integer miseAPrix, Utilisateur vendeur, Categorie categorieArticle) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.vendeur = vendeur;
		this.categorieArticle = categorieArticle;
	}



	public Article(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			Integer miseAPrix) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
	}



	public Article(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			Integer miseAPrix, Integer prixVente, String etatVente, Utilisateur acheteur, Utilisateur vendeur,
			List<Enchere> encheres, Categorie categorie, Retrait retrait) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.acheteur = acheteur;
		this.vendeur = vendeur;
		this.encheres = encheres;
		this.categorieArticle = categorie;
		this.lieuRetrait = retrait;
	}



	public Article(Integer noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente, Utilisateur acheteur,
			Utilisateur vendeur, List<Enchere> encheres, Categorie categorie, Retrait retrait) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.acheteur = acheteur;
		this.vendeur = vendeur;
		this.encheres = encheres;
		this.categorieArticle = categorie;
		this.lieuRetrait = retrait;
	}
	
	public Integer getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public Integer getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public Integer getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	public Utilisateur getAcheteur() {
		return acheteur;
	}
	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}
	public Utilisateur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	public List<Enchere> getEncheres() {
		return encheres;
	}
	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	
	public Categorie getCategorieArticle() {
		return categorieArticle;
	}


	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}


	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}


	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}


	public Retrait getRetrait() {
		return lieuRetrait;
	}
	public void setRetrait(Retrait retrait) {
		this.lieuRetrait = retrait;
	}

	
	

	@Override
	public int hashCode() {
		return Objects.hash(noArticle);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(noArticle, other.noArticle);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [noArticle=");
		builder.append(noArticle);
		builder.append(", nomArticle=");
		builder.append(nomArticle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebutEncheres=");
		builder.append(dateDebutEncheres);
		builder.append(", dateFinEncheres=");
		builder.append(dateFinEncheres);
		builder.append(", miseAPrix=");
		builder.append(miseAPrix);
		builder.append(", prixVente=");
		builder.append(prixVente);
		builder.append(", etatVente=");
		builder.append(etatVente);
		builder.append(", acheteur=");
		builder.append(acheteur);
		builder.append(", vendeur=");
		builder.append(vendeur);
		builder.append(", encheres=");
		builder.append(encheres);
		builder.append(", categorie=");
		builder.append(categorieArticle);
		builder.append(", retrait=");
		builder.append(lieuRetrait);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}

package fr.eni.projetEnchere.bo;

import java.util.List;
import java.util.Objects;

public class Categorie {

	private Integer noCategorie;
	private String libelle;
	
	List<Article> articles;

	public Categorie() {
	}
	
	public Categorie(String libelle, List<Article> articles) {
		super();
		this.libelle = libelle;
		this.articles = articles;
	}


	public Categorie(Integer noCategorie, String libelle, List<Article> articles) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.articles = articles;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(noCategorie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		return Objects.equals(noCategorie, other.noCategorie);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", articles=");
		builder.append(articles);
		builder.append("]");
		return builder.toString();
	}
	
	
}

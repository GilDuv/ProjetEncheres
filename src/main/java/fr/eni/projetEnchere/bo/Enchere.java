package fr.eni.projetEnchere.bo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Enchere {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date dateEnchere;
	private Integer montant_enchere;
	
	private Utilisateur enchérisseur;
	private Article article;
	
	
	
	public Enchere() {
	}
	
	public Enchere(Date dateEnchere, Integer montant_enchere, Utilisateur enchérisseur, Article article) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.enchérisseur = enchérisseur;
		this.article = article;
	}
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public Integer getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	public Utilisateur getEnchérisseur() {
		return enchérisseur;
	}
	public void setEnchérisseur(Utilisateur enchérisseur) {
		this.enchérisseur = enchérisseur;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montant_enchere=");
		builder.append(montant_enchere);
		builder.append(", enchérisseur=");
		builder.append(enchérisseur);
		builder.append(", article=");
		builder.append(article);
		builder.append("]");
		return builder.toString();
	}
	
	
}

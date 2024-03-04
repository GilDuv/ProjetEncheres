package fr.eni.projetEnchere.bo;

import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Utilisateur {
	
	//Attributs

	private Integer noUtilisateur;
	
	//Patterns pour le formulaire d'inscription
	@NotBlank
	@Size(max = 30)
	private String pseudo;
	
	@NotBlank
	@Size(max = 30)
	private String nom;
	
	@NotBlank
	@Size(max = 30)
	private String prenom;
	
	@Email
	//@Pattern(regexp = "\\w+@campus-eni.fr")
	//@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String email;
	
	//@Pattern(regexp="^0[1-9]([-. ]?[0-9]{2}){4}$")
	private String telephone;
	
	@NotBlank
	@Size(max = 30)
	private String rue;
	
	//@Pattern(regexp="^(?:[0-8][0-9]|9[0-8])\\d{3}$")
	@Size(max = 10)
	private String codePostal;
	
	@NotBlank
	@Size(max = 30)
	private String ville;
	
	@NotBlank
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()_{}|:;<>,.?/~\\-]).{8,}$")
	@Size(max = 256)
	private String motDePasse;
	
	
	private Integer credit = 0;
	private boolean administrateur = false;
	
	List<Article> articlesVendus;
	List<Article> articlesAchetés;
	List<Enchere> encheres;
	
	//Constructeurs
	public Utilisateur() {
	}
	
	public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
	}

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}



	public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}



	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur,
			List<Article> ventes, List<Article> achats,List<Enchere> encheres) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.articlesVendus = ventes;
		this.articlesAchetés = achats;
		this.encheres= encheres;
	}


	public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur,
			List<Article> ventes, List<Article> achats,List<Enchere> encheres) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.articlesVendus = ventes;
		this.articlesAchetés = achats;
		this.encheres= encheres;
	}
	
	
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = 0;
	}
	
	public List<Article> getVentes() {
		return articlesVendus;
	}
	public void setVentes(List<Article> ventes) {
		this.articlesVendus = ventes;
	}
	public List<Article> getAchats() {
		return articlesAchetés;
	}
	public void setAchats(List<Article> achats) {
		this.articlesAchetés = achats;
	}

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(noUtilisateur);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(noUtilisateur, other.noUtilisateur);
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [noUtilisateur=");
		builder.append(noUtilisateur);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", CodePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append(", credit=");
		builder.append(credit);
		builder.append(", administrateur=");
		builder.append(administrateur);
		builder.append(", ventes=");
		builder.append(articlesVendus);
		builder.append(", achats=");
		builder.append(articlesAchetés);
		builder.append(", encheres=");
		builder.append(encheres);
		builder.append("]");
		return builder.toString();
	}




	
	
	
}

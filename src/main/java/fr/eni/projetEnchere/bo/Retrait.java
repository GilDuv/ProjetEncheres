package fr.eni.projetEnchere.bo;

public class Retrait {
	
	private String rue;
	private String code_postal;
	private String ville;
	
	private Article article;

	
	public Retrait() {
	}

	public Retrait(String rue, String code_postal, String ville, Article article) {
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.article = article;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
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
		builder.append("Retrait [rue=");
		builder.append(rue);
		builder.append(", code_postal=");
		builder.append(code_postal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", article=");
		builder.append(article);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

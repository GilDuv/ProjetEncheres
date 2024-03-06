CREATE TABLE CATEGORIES (
    no_categorie   SERIAL PRIMARY KEY,
    libelle        VARCHAR(30) NOT NULL
);
 
CREATE TABLE UTILISATEURS (
    no_utilisateur   SERIAL PRIMARY KEY,
    pseudo           VARCHAR(30) NOT NULL UNIQUE,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(20) NOT NULL UNIQUE,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     VARCHAR(256) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   BOOLEAN NOT NULL
);
 
CREATE TABLE ARTICLES (
    no_article                    SERIAL PRIMARY KEY,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           DATE NOT NULL,
    date_fin_encheres             DATE NOT NULL,
    prix_initial                  INTEGER,
    prix_vente                    INTEGER,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL,
	FOREIGN KEY (no_utilisateur) REFERENCES UTILISATEURS (no_utilisateur) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (no_categorie) REFERENCES CATEGORIES (no_categorie) ON DELETE NO ACTION ON UPDATE NO ACTION
);
 
CREATE TABLE ENCHERES (
    no_utilisateur   INTEGER NOT NULL,
    no_article       INTEGER NOT NULL,
    date_enchere     TIMESTAMP NOT NULL,
	montant_enchere  INTEGER NOT NULL,
	PRIMARY KEY (no_utilisateur, no_article),
    FOREIGN KEY (no_article) REFERENCES ARTICLES (no_article) ON DELETE NO ACTION ON UPDATE NO ACTION
);
 
CREATE TABLE RETRAITS (
	no_article         INTEGER PRIMARY KEY,
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
	FOREIGN KEY (no_article) REFERENCES ARTICLES (no_article) ON DELETE NO ACTION ON UPDATE NO ACTION
);
 

-- Suppression des contraintes étrangères
ALTER TABLE ENCHERES DROP CONSTRAINT IF EXISTS encheres_articles_fk;
ALTER TABLE RETRAITS DROP CONSTRAINT IF EXISTS retraits_articles_fk;
ALTER TABLE ARTICLES DROP CONSTRAINT IF EXISTS articles_utilisateurs_fk;
ALTER TABLE ARTICLES DROP CONSTRAINT IF EXISTS articles_categories_fk;
 
-- Suppression des tables
DROP TABLE IF EXISTS ENCHERES;
DROP TABLE IF EXISTS RETRAITS;
DROP TABLE IF EXISTS ARTICLES;
DROP TABLE IF EXISTS UTILISATEURS;
DROP TABLE IF EXISTS CATEGORIES;

-- Voir les tables
SELECT * FROM UTILISATEURS
SELECT * FROM ARTICLES
SELECT * FROM CATEGORIES
SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente
FROM ARTICLES;

-- DELETE TABLES
DELETE FROM ARTICLES
DELETE FROM UTILISATEURS

-- INSERT TEST UTILISATEURS

INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)
VALUES ('bool','Dupont','Bernard','beber@live.fr','0652764587','18 rue du soleil','44000','nantes','$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,'true');
INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)
VALUES ('Rintintin','Durant','David','tontondavid@live.fr','0652765648','18 rue du soleil levant','79000','niort','$2a$10$NGjU/wi4Sp3nzZsNL.ZEgOkLFsMXnRsbBJzKZYyzPk4vEyH.2NYmW',0,'false');

-- INSERT LIBELLE CATEGORIES
INSERT INTO CATEGORIES (libelle) VALUES('Informatique')
INSERT INTO CATEGORIES (libelle) VALUES('Ameublement')
INSERT INTO CATEGORIES (libelle) VALUES('Vêtement')
INSERT INTO CATEGORIES (libelle) VALUES('Sport&Loisirs')

-- INSERT TEST ARTICLES
INSERT INTO ARTICLES (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)
VALUES ('Funko Pop','Pika vénére','20-12-2018','22-12-2018',350,375,31,2)

INSERT INTO ARTICLES (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)
VALUES ('TV LED','TV de ouf','20-12-2020','22-12-2021',1350,1375,32,2)


-- TEST UTILISATEURS
SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe ,credit,administrateur FROM UTILISATEURS

-- TEST INNER JOIN
SELECT 
	a.*,
	c.libelle,
	u.pseudo
	FROM ARTICLES a
	INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur
	INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie WHERE a.no_article = 5
	
	
SELECT a.*, c.libelle, u.pseudo FROM ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie WHERE a.no_article = 5

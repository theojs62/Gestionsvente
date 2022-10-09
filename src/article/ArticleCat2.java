package article;
/**
 * Un objet de la classe Article correspond Article 1
 * @author Ethan JOAO
 * @version 1, 05/04/2022
 */

import util.Util;

public class ArticleCat2 extends Article implements Livrable{
	/**
	 * Titre du livre.*/
	private String titre;
	/**
	 * Auteur.e(s) du livre.*/
	private String auteur;
	/**
	 * editeur du livre.*/
	private String editeur;
	/**
	 * Genre du livre.*/
	private Genre genre;
	/**
	 * Poids du livre (en kg)*/
	private double poids;
	/**
	 * hauteur du colis (en cm)*/
	private int hauteur;
	/**
	 *largeur du colis (en cm)*/
	private int largeur;
	/**
	 * profondeur du colis (en cm)*/
	private int profondeur;
/**
	 * Constructeur permettant de creer un nouveau livre avec comme categorie "Livre". Son numero de reference est genere automatiquement. Les autres informations sont saisies au clavier avec la methode saisirInfos().
	 * @param designation - La désignation de l'article.
	 * @param prix - Le prix de l'article (si strictement inférieur Ã  0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock - La quantité initiale en stock de l'article (si strictement inférieur Ã  0 alors 0 est mis comme quantité).
	 * @param titre - Titre du livre.
	 * @param auteur - Nom de l'auteur du livre.
	 * @param editeur - Nom de l'éditeur du livre.
	 * @param genre - Genre du livre.
	 * @param poids - Poids du livre.
	 * @param hauteur - Hauteur du livre.
	 * @param largeur - Largeur du livre.
	 * @param profondeur - Profondeur du livre.
	 */
	public ArticleCat2(String designation, double prix, int quantiteStock, String titre, String auteur, String editeur , Genre genre,double poids, int hauteur, int largeur, int profondeur) {
		super("Livre",designation,prix,quantiteStock);
		this.titre=titre;
		this.auteur=auteur;
		this.genre=genre;
		this.poids=poids;
		this.hauteur=hauteur;
		this.largeur=largeur;
		this.profondeur=profondeur;
	}
	
	/**
	 * Constructeur permettant de creer un nouveau livre avec comme categorie "Livre". Son numero de reference est genere automatiquement. Les autres informations sont saisies au clavier avec la methode saisirInfos().
	 */
	public ArticleCat2() {
		super("Livre","",0,0);
		saisirInfos();
	}
	
	
	//methods
	
	/*
	 * Méthode permettant de saisir la désignation, le prix, la quantite en stock,le titre, le ou les auteurs.es, l'editeur, le genre, le poids ainsi que les dimensions d'un livre. La categorie n'est pas saisie.
	 */
	public void saisirInfos() {
		super.saisirInfos();
		titre=Util.saisirChaine("Titre du livre: ");
		auteur=Util.saisirChaine("Auteur.e(s) du livre: ");
		editeur=Util.saisirChaine("Éditeur du livre :");
		boolean retenter = true;
		while(retenter) {
			try {
				genre = Genre.valueOf(Util.saisirChaine("Genre du livre :"));
				retenter = false;
			}
			catch(java.lang.IllegalArgumentException e) {System.out.println("Erreur, Genre impossible, veuillez retenter :");}
		}
		poids = Util.saisirDoublePositif("Poids du livre (en kg) : ");
		hauteur = Util.saisirEntierPositif("Hauteur du livre (en cm) : ");
		largeur = Util.saisirEntierPositif("Largeur du livre (en cm) : ");
		profondeur = Util.saisirEntierPositif("Profondeur du livre (en cm) : ");
	}
	
	public String toString() {
		return super.toString() + "\nTitre : "+titre+"\nAuteur : "+auteur+"\nEditeur : "+editeur+"\nGenre : "+genre+"\n"+this.infosLivrable();
	}
	
	//getters
	/*
	 * Cette méthode retourne le titre du livre.
	 * @return le titre du livre.
	 */
	public String getTitre() {
		return titre;
	}
	/*
	 * Cette méthode retourne le ou les auteurs.es du livre.
	 * @return le ou les auteurs.es du livre.
	 */
	public String getAuteur() {
		return auteur;
	}
	/*
	 * Cette méthode retourne l'éditeur du livre.
	 * @return l'éditeur du livre.
	 */
	public String getEditeur() {
		return editeur;
	}
	/*
	 * Cette méthode retourne le genre du livre.
	 * @return le genre du livre.
	 */
	public Genre getGenre() {
		return genre;
	}
	/**
	 * Méthode indiquant la hauteur du colis de l'article en cm.
	 * @return La hauteur du colis en cm.
	 */
	public int getHauteurColis() {
		return hauteur;
	}

	/**
	 * Méthode indiquant la largeur du colis de l'article en cm.
	 * @return La largeur du colis en cm.
	 */
	public int getLargeurColis() {
		return largeur;
	}

	/**
	 * Méthode indiquant la profondeur du colis de l'article en cm.
	 * @return La profondeur du colis en cm.
	 */
	public int getProfondeurColis() {
		return profondeur;
	}

	/**
	 * Méthode retournant le poids du colis en Kg.
	 * @return Le poids du colis en Kg.
	 */
	public double getPoidsKgColis() {
		return poids;
	}
}

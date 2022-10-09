package article;
/**
 * Un objet de la classe Article correspond Article 1
 * @author Ethan JOAO et Théo JOURNEE
 * @version 2, 06/04/2022
 */

import util.Util;
public class ArticleCat1 extends Article{
	/**
	 * Titre du livre audio.*/
	private String titre;
	/**
	 * Auteur.e(s) du livre audio.*/
	private String auteur;
	/**
	 * editeur du livre audio*/
	private String editeur;
	/**
	 * Genre du livre audio*/
	private Genre genre;
	/**
	 * Nom du doubleur du livre audio*/
	private String nomDoubleur;
	
	//constructor
	/**
	 * Constructeur permettant de creer un nouveau livre avec comme categorie "Livre audio". Son numero de reference est genere automatiquement. Les autres informations sont saisies au clavier avec la methode saisirInfos().
	 * @param designation - La dÃésignation de l'article.
	 * @param prix - Le prix de l'article (si strictement inférieur à  0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock - La quantité initiale en stock de l'article (si strictement inférieur Ã  0 alors 0 est mis comme quantité).
	 * @param titre - Titre du livre audio .
	 * @param auteur - Nom de l'auteur du livre audio.
	 * @param editeur - Nom de l'éditeur du livre audio.
	 * @param genre - Genre du livre audio.
	 * @param nomDoubleur Correspond au nom du doubleur.
	 */	
	//constructor
	public ArticleCat1(String designation, double prix, int quantiteStock,String titre, String auteur, String editeur, Genre genre, String nomDoubleur) {
		super("Livre audio",designation,prix,quantiteStock);
		this.titre=titre;
		this.auteur=auteur;
		this.genre=genre;
		this.editeur=editeur;
		this.nomDoubleur=nomDoubleur;
	}
	/**
	 * Constructeur permettant de creer un nouveau livre audio avec comme categorie "Livre audio". Son numéro de reference est generer automatiquement. Les autres informations sont saisies au clavier avec la methode saisirInfos().
	 */
	public ArticleCat1() {
		super("Livre audio","",0,0);
		saisirInfos();
	}
	//methods
	/**
	 * Methode permettant de saisir la designation, le prix, la quantite en stock,le titre, le ou les auteurs.es, l'editeur, le genre et le nom du doubleur d'un livre audio. La categorie n'est pas saisie.
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
		nomDoubleur=Util.saisirChaine("Nom du doubleur du livre audio : ");
	}
	/**
	 * Methode (redefinition de toString()) retournant une representation textuelle. Cette representation contient la reference, la designation, la categorie, le prix unitaire, la quantite en stock, le titre, le ou les auteurs.es, l'editeur, le genre et le nom du doubleur du livre audio.
	 * @return Representation textuelle du livre audio
	 */
	public String toString() {
		return super.toString() + "\nTitre : "+titre+"\nAuteur : "+auteur+"\nEditeur : "+editeur+"\nGenre : "+genre+"\nNom du doubleur : "+nomDoubleur;
	}
	
	//getters 
	/**
	 * Cette methode retourne le titre du livre audio.
	 * @return le titre du livre audio.
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * Cette methode retourne le ou les auteurs.es du livre audio.
	 * @return le ou les auteurs.es du livre audio.
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * Cette methode retourne l'editeur du livre audio.
	 * @return l'éditeur du livre audio.
	 */
	public String getEditeur() {
		return editeur;
	}
	/**
	 * Cette methode retourne le genre du livre audio.
	 * @return le genre du livre audio.
	 */
	public Genre getGenre() {
		return genre;
	}
	/**
	 * Cette methode retourne  le nom du doubleur 
	 * @return le nom du doubleur
	 */
	
	public String getNomDoubleur() {
		return nomDoubleur;
	}
}


package article;
/**
 * Un objet de la classe Article correspond Article 3
 * @author : Maxence dewadder
 */

import util.Util;
public class ArticleCat3 extends Article{
	/**
	 * Titre de l'eBook.*/
	private String titre;
	/**
	 * Auteur.e(s) de l'eBook.*/
	private String auteur;
	/**
	 * editeur de l'eBook*/
	private String editeur;
	/**
	 * Genre de l'eBook*/
	private Genre genre;

	//constructor
	/**
	 * Constructeur permettant de creer un nouveau livre avec comme categorie "eBook". Son numero de reference est genere automatiquement. Les autres informations sont saisies au clavier avec la methode saisirInfos().
	 * @param designation - La désignation de l'article.
	 * @param prix - Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock - La quantité initiale en stock de l'article (si strictement inférieur à 0 alors 0 est mis comme quantité).
	 * @param titre - Titre de l'eBook .
	 * @param auteur - Nom de l'eBook.
	 * @param editeur - Nom de l'eBook.
	 * @param genre - Genre de l'eBook.
	 */	
	
	public ArticleCat3(String designation, double prix, int quantiteStock,String titre, String auteur, String editeur, Genre genre) {
		super("eBook",designation,prix,quantiteStock);
		this.titre=titre;
		this.auteur=auteur;
		this.genre=genre;
		this.editeur=editeur;
	}
	/**
	 * Constructeur permettant de creer un nouveau livre audio avec comme categorie "eBook". Son num�ro de reference est generer automatiquement. Les autres informations sont saisies au clavier avec la methode saisirInfos().
	 */
	public ArticleCat3() {
		super("eBook","",0,0);
		saisirInfos();
	}
	//methods
	/**
	 * Methode permettant de saisir la designation, le prix, la quantite en stock,le titre, le ou les auteurs.es, l'editeur, le genre de l'eBook. La categorie n'est pas saisie.
	 */
	public void saisirInfos() {
		super.saisirInfos();
		titre=Util.saisirChaine("Titre de l'eBook: ");
		auteur=Util.saisirChaine("Auteur.e(s) de l'eBook: ");
		editeur=Util.saisirChaine("editeur de l'eBook :");
		boolean retenter = true;
		while(retenter) {
			try {
				genre = Genre.valueOf(Util.saisirChaine("Genre de l'eBook :"));
				retenter = false;
			}
			catch(java.lang.IllegalArgumentException e) {System.out.println("Erreur, Genre impossible, veuillez retenter :");}
		}
	}
	/**
	 * Methode (redefinition de toString()) retournant une representation textuelle. Cette representation contient la reference, la designation, la categorie, le prix unitaire, la quantite en stock, le titre, le ou les auteurs.es, l'editeur, le genre de l'eBook.
	 * @return Representation textuelle de l'eBook
	 */
	public String toString() {
		return super.toString() + "\nTitre : "+titre+"\nAuteur : "+auteur+"\nEditeur : "+editeur+"\nGenre : "+genre;
	}
	
	//getters 
	/**
	 * Cette methode retourne le titre de l'eBook.
	 * @return le titre de l'eBook.
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * Cette methode retourne le ou les auteurs.es de l'eBook.
	 * @return le ou les auteurs.es de l'eBook.
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * Cette methode retourne l'editeur de l'eBook.
	 * @return l'�diteur de l'eBook.
	 */
	public String getEditeur() {
		return editeur;
	}
	/**
	 * Cette methode retourne le genre de l'eBook.
	 * @return le genre de l'eBook.
	 */
	public Genre getGenre() {
		return genre;
	}
}


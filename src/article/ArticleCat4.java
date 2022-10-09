package article;
/**
 * Un objet de la classe Article correspond Article 4
 * @author : Maxence dewadder
 */

import util.Util;
public class ArticleCat4 extends Article implements Livrable{
	/**
	 * matériau du Marque page.*/
	private String materiau;
	/**
	 * Poids du Marque page (en kg)*/
	private double poids;
	/**
	 * hauteur du colis (en cm)*/
	private int hauteur;
	/**
	 *largeur du colis (en cm)*/
	private int largeur;
	/**
	 * profondeur du colis (en cm)*/
	private int profondeur=1;
	 
	
	/**
	 * Constructeur permettant de creer un nouveau livre avec comme categorie "Livre". Son numero de reference est genere automatiquement. Les autres informations sont saisies au clavier avec la methode saisirInfos(). La profondeur d'un Marque page est par défaut de 1cm.
	 * @param designation - La désignation de l'article.
	 * @param prix - Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock - La quantité initiale en stock de l'article (si strictement inférieur à 0 alors 0 est mis comme quantité).
	 * @param poids - Poids du Marque page.
	 * @param hauteur - Hauteur du Marque page.
	 * @param largeur - Largeur du Marque page.
	 * @param profondeur -Profondeur du Marque page.
	 * @param materiau - Matériau utilisé pour fabriquer le Marque page.
	 */
	public ArticleCat4(String designation, double prix, int quantiteStock,double poids, int hauteur, int largeur,int profondeur, String materiau) {
		super("Marque page",designation,prix,quantiteStock);
		this.poids=poids;
		this.hauteur=hauteur;
		this.largeur=largeur;
		this.materiau = materiau;
		this.profondeur = profondeur;
	}
	/**
	 * Constructeur permettant de creer un nouvel article avec comme categorie "Marque page". Son num�ro de reference est generer automatiquement. Les autres informations sont saisies au clavier avec la methode saisirInfos().
	 */
	public ArticleCat4() {
		super("Marque page","",0,0);
		saisirInfos();
		

	}
	//methods
	/**
	 * Methode permettant de saisir la designation, le prix, la quantite en stock,le nom du marque page. La categorie n'est pas saisie.
	 */
	public void saisirInfos() {
		super.saisirInfos();
		materiau=Util.saisirChaine("Materiau du marque page : ");
		poids = Util.saisirDoublePositif("Poids du marque page (en kg) : ");
		hauteur = Util.saisirEntierPositif("Hauteur du marque page (en cm) : ");
		largeur = Util.saisirEntierPositif("Largeur du marque page (en cm) : ");
	}
	/**
	 * Methode (redefinition de toString()) retournant une representation textuelle. Cette representation contient la reference, la designation, la categorie, le prix unitaire, la quantite en stock, le nom du marque page.
	 * @return Representation textuelle du marque page
	 */
	public String toString() {
		return super.toString() + "\nMateriau du marque page : "+materiau+this.infosLivrable();
	}
	
	//getters 
	/**
	 * Cette methode retourne le nom du marque page.
	 * @return le titre du marque page.
	 */
	public String getmateriau() {
		return materiau;
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
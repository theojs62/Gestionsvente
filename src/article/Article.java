package article;

import util.Util;
/**
 * Un objet de la classe Article correspond à un article/produit vendu par l'entreprise. Chaque article consideration  se vend à l'unite (il ne se vend pas par exemple au kilo). Chaque article a un numero de reference (un entier) qui lui est propre et qui permet de l'identifier, une catégorie (une chaîne de caractères), une désignation (une chaîne de caractères), un prix à l'unite en euros (un double) et une quantite en stock (un entier).
 * @version : 1.0
 * @author : Ethan JOAO 
 */
public class Article {
	/**
	 * Le nombre d'articles crees (qui sera notamment utilise pour la generation du numero de reference de chaque article). Il sera initialiser à 0.*/
	private static int nbArticles = 0;
	/**
Le numero de reference de l'article. Le premier article aura la reference 0, le deuxieme la reference 1, le troisieme la reference 2 ...*/
	private int reference; 
	/*La catégorie de l'article.*/
	private String categorie; 
	/*La désignation de l'article.*/
	private String designation; 
	/*Le prix à l'unité.*/
	private double prix;
	/*La quantité en stock.*/
	private int quantiteStock;
	
	//constructors
	
	/**
	 * Constructeur permettant de créer un nouvel article. Son numero de référence est généré automatiquement.
	 * @param categorie - La catégorie de l'article.
	 * @param designation - La désignation de l'article.
	 * @param prix - Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock - La quantité initiale en stock de l'article (si strictement inferieur à 0 alors 0 est mis comme quantité).
	 */
	protected Article(String categorie, String designation, double prix, int quantiteStock) {
		this.categorie = categorie;
		this.designation = designation;
		this.reference = nbArticles;
		nbArticles++;
		if(prix<0.0) {
			this.prix = 0.0;
		}
		else {
			this.prix = prix;
		}
		if(quantiteStock < 0) {
			this.quantiteStock = 0;
		}
		else {
			this.quantiteStock = quantiteStock;
		}
	}
	
	/**
	 * Constructeur permettant de créer un nouvel article avec comme catégorie "Aucune". Son numero de référence est généré automatiquement.
	 * @param designation - La désignation de l'article.
	 * @param prix - Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
	 * @param quantiteStock - La quantité initiale en stock de l'article ( si strictement inférieur à 0 alors 0 est mis comme quantité).
	 */
	public Article(String designation, double prix, int quantiteStock) {
		this("Aucune",designation,prix,quantiteStock);
	}
	
	/**
	 * Constructeur permettant de créer un nouvel article avec comme catégorie "Aucune". Son numéro de référence est généré automatiquement. Les autres informations sont saisies au clavier avec la méthode saisirInfos().
	 */
	public Article() {
		this.saisirInfos();
		reference = nbArticles;
		nbArticles++;
		categorie = "Aucune";
	}
	
	//getters
	/**
	 * Méthode retournant le prix de l'article.
	 * @return Le prix de l'article.
	 */
	public double getPrix() {
		return prix;
	}
	
	/**
	 * Méthode retournant la quantité en stock de l'article.
	 * @return La quantité en stock de l'article.
	 */
	public int getQuantiteStock() {
		return quantiteStock;
	}
	
	/*
	 * Méthode retournant le numéro de référence de l'article.
	 * @return la référence de l'article.
	 */
	public int getReference() {
		return reference;
	}
	
	/**
	 * Méthode retournant la catégorie de l'article.
	 * @return La catégorie de l'article.
	 */
	public String getCategorie() {
		return categorie;
	}
	
	/*
	 * Méthode retournant la désignation de l'article.
	 * @return désignation de l'article.
	 */
	public String getDesignation() {
		return designation;
	}
	
	//setters
	/**
	 * Méthode permettant de modifier le prix d'un article. Dans lz cas où le prix donné en paramètre est strictement inférieur à 0.0, la valeur 0.0 est mise comme prix.
	 * @param prix - Le nouveau prix de l'article.
	 */
	public void setPrix(double prix) {
		if(prix<0.0) {
			this.prix = 0.0;
		}
		else {
			this.prix = prix;
		}
	}
	
	/**
	 * Méthode permettant de modifier la quantité en stock de l'article. Dans le cas où la quantité en stock donnée en paramètre est strictement inférieure à 0 alors 0 est mis à la place.
	 * @param quantiteStock - La nouvelle quantité en stock de l'article
	 */
	public void setQuantiteStock(int quantiteStock) {
		if(quantiteStock<0) {
			this.quantiteStock = 0;
		}
		else {
			this.quantiteStock = quantiteStock;
		}
	}
	
	//methods
	/**
	 * Méthode permettant de saisir la désignation, le prix et la quantité en stock d'un article. La catégorie n'est pas saisie. Il faut qu'elle soit initialisée par ailleurs.
	 */
	public void saisirInfos() {
		designation = Util.saisirChaine("Veuillez insérer la désignation de l'article : ");
		prix = Util.saisirDoublePositif("Veuillez insérer le prix de l'article : ");
		quantiteStock = Util.saisirEntierPositif("Veuillez insérer la quantité en stock de l'article : ");
	}
	
	/**
	 * Méthode retournant si le produit est disponible ou  non (i.e. si sa quantité en stock est strictement supérieure à 0).
	 * @return true si et seulement si sa quantité en stock est strictement supérieure à 0.
	 */
	public boolean estDisponible() {
		return quantiteStock>0;
	}
	
	/**
	 * Méthode permettant d'ajouter une certaine quantité à la quantité en stock de l'article. Dans le cas où la quantité à ajouter est strictement inférieure à 0 alors la quantité en stock n'est pas modifiée.
	 * @param quantite - La quantité à ajouter à la quantité en stock de l'article.
	 */
	public void ajouterQuantiteStock(int quantite) {
		if(quantite>=0) {
			this.quantiteStock += quantite;
		}
	}
	
	/**
	 * Methode permettant de supprimer une quantité à la quantité en stock de l'article. Dans le cas où la quantité à enlever est strictement inférieure à 0 alors la quantité en stock n'est pas modifié. Dans le cas où la quantité à enlever est supérieure à la quantité en stock alors la quantité en stock devient 0.
	 * @param quantite - La quantité à enlever.
	 */
	public void enleverQuantiteStock(int quantite) {
		if(quantite>=0) {
			if(quantite>quantiteStock) {
				this.quantiteStock = 0;
			}
			else {
				quantiteStock -= quantite;
			}
		}
	}
	
	/**
	 * Méthode (redéfinition de toString()) retournant une représentation textuelle. Cette représentation contient la référence, la désignation, la catégorie, le prix unitaire et la quantité en stock de l'article.
	 * @return Representation textuelle de l'article.
	 */
	public String toString() {
		return "Référence n°"+getReference()+"\nCatégorie : "+getCategorie()+"\nDésignation : "+getDesignation()+"\nPrix : "+getPrix()+"€\nQuantité en stock : "+getQuantiteStock();
	}
	
	/**
	 * Méthode permettant de tester si deux articles sont les mêmes : deux articles sont les mêmes si et seulement si ils ont le meme numéro de référence.
	 * @param article - Un objet supposé être instance de la classe Article et non null.
	 */
	public boolean equals(Object article) {
		if((article==null)||(!(article instanceof Article))) return false;
		else return ((Article) article).getReference() == this.getReference();
	}
	
	/**
	 * Methode permettant d'afficher les articles d'un tableau d'articles.
	 * @param articles - Le tableau contenant les articles à afficher, chaque élément du tableau contient une référence non null.
	 */
	public static void afficherTabArticles(Article[] articles) {
		for(int i=0; i<articles.length;i++) {
			System.out.println("***Article n°"+i+"***\n"+articles[i].toString()+"\n");
		}
	}
	
}

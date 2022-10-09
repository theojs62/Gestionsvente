package article;

import java.util.ArrayList;
/**
 * Cette classe correspond au stock.
 * 
 * @author Théo JOURNEE
 * @version 1, 04/04/2022
 *
 */
public class Stock {
	/**
	 * le nombre maximal d'articles dans le stock
	 */
	public static final int  MAX_ARTICLES=100;
	/**
	 * le nombre s'articles dans le stock.
	 */
	private int nbArticles;
	/**
	 * le nom du stock
	 */
	private String nom;
	/*
	 * Les articles se trouvant dans le stock
	 */
	private Article[] articles;
	/**
	 * Constructeur permettant de construire un nouveau stock
	 * @param nom permettant de savoir le nom du stock 
	 * 
	 */
	public Stock(String nom) {
		this.nom=nom;
		nbArticles=0;
		articles = new Article[MAX_ARTICLES];
	}
	/**
	 * Méthode testant si le stock est plein 
	 * @return true si le stock est plein.
	 */
	public boolean estPlein() {
		return MAX_ARTICLES == nbArticles;
	}
	/**
	 * Méthode testant si le stock est vide
	 * @return true si le stock est compl�tement vide.
	 */
	public boolean estVide() {
		return nbArticles==0;
	}
	/**
	 * Méthode cherchant un article dans le tableau articles correspondant
	 * @param article - Un article (supposé non null).
	 * @return L'indice où se trouve cet article dans le tableau articles. Dans le cas où l'article n'est pas présent -1 est retourné.

	 */
	private int chercherIndiceArticle(Article  article) {
		if (article != null) {
			for (int i = 0; i < nbArticles; i++) {
				if (articles[i].equals(article)) {
					return i;
				}
			}
			return -1;
		}
		else return -1;
	}
	/**
	 * Méthode permettant d'ajouter un article dans le stock. Dans le cas où le stock est plein ou bien l'article est déjà présent dans le stock, rien est fait. Dans le cas contraire l'article est inséré dans le stock.
	 * @param article - Un article (supposé non null).
	 */
	public void ajouterArticle(Article article){
		if (article != null) {
			if (!this.estPlein() || this.chercherIndiceArticle(article) == -1) {
				articles[nbArticles] = article;
				nbArticles++;
			}
		}
	}
	/**
	 * Méthode permettant de supprimer un article du stock. Rien est fait dans le cas où l'article n'est pas présent dans le stock.
	 * @param article - Un article (supposé non null).
	 */
	public void supprimerArticle(Article article){
		int indice;
		if (article != null) {
			indice = this.chercherIndiceArticle(article);
			if(!(indice==-1)) {
				articles[indice] = articles[nbArticles- 1];
				articles[nbArticles - 1] = null;
				nbArticles--;
			}
		}
	}
	/**
	 * Méthode permettant de chercher un article dans le stock avec son numéro de référence.
	 * @param refArticle - La référence de l'article recherché.
	 * @return L'article dans le stock ayant refArticle comme référence ou null si un tel article n'existe pas.
	 */
	public Article rechercherArticleParReference(int  refArticle) {
		for (int i = 0; i < nbArticles; i++) {
			if (articles[i].getReference() == refArticle) {
				return articles[i];
			}
		}
		return null;	
	}
	/**
	 * Méthode retournant un nouveau tableau contenant les articles du stock.
	 * @return Un nouveau tableau non null contenant les articles du stock.
	 */
	public  Article[] articlesDansStock() {
		Article[] tab=new Article[getNbArticles()];
		for(int i =0;i<nbArticles;i++) {
			tab[i] = articles[i];
		}		
		return tab;
	}
	/**
	 * Méthode permettant de chercher les articles du stock d'une certaine catégorie. La méthode retourne un tableau d'articles (toujours non null et pouvant contenir aucun �l�ment si aucun article a �t� s�lectionn�).
	 * @param categorie - La catégorie pour laquelle nous souhaitons les articles.
	 * @return Un tableau contenant les articles trouvés dans le stock avec la catégorie passée en paramètre.
	 */
	public Article[] rechercherArticlesCategorie(String categorie) {
		ArrayList<Article> tab = new ArrayList<Article>();
		for(int i=0;i<nbArticles;i++) {
			if(articles[i].getCategorie().equals(categorie)) {
				tab.add(articles[i]);
			}
		}
		return  tab.toArray(new Article[0]);
	}

/**
 * Méthode retournant le nom du stock.
 * @return le nom du stock
 */
	
	public String getNom() {
		return nom;
	}
	/**
	 * Méthode permettant de modifier le nom du stock.
	 * @param nom - le nouveau du stock 
	 */
		
	public void setNom(String nom) {
		this.nom=nom;
	}
	/**
	 * Méthode retournant le nombre d'articles du stock.
	 * @return Le nombre d'articles du stock 
	 */
	public int getNbArticles(){
		return nbArticles;
	}
	
}
	

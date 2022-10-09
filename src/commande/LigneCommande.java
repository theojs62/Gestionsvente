package commande;

import article.Article;
import article.Livrable;
import util.Util;

/**
 * Création d'une ligne de commande de l'entreprise, une ligne de commande correspond à un seul et même article qui peut être commandé plusieurs fois
 * @author Maxence DEWADDER
 * @version 2, 06/04/22
 */
public class LigneCommande {
	/**
	 * Article correspondant à la ligne de commande.
	 */
	private Article article;
	/**
	 * Quantité d'article présente sur la commande.
	 */
	private int quantite;

	/**
	 * Constructeur permettant de créer une ligne de commande pour un article donné avec une quantité commandée.
	 * @param article Article à selectionner
	 * @param quantite quantité d'article
	 */
	public LigneCommande(Article article,int quantite) {
		try {
			if(quantite<0) throw new IllegalArgumentException("/!\\ quantite négative impossible !");
		}
		catch(IllegalArgumentException e) {
			quantite= Util.saisirEntierPositif(e.getMessage()+"\nVeuillez insérer une nouvelle quantité : ");
			}
		this.article=article;
		if(quantite>article.getQuantiteStock()) {
			this.quantite = article.getQuantiteStock();
		}
		else this.quantite = quantite;
		article.enleverQuantiteStock(this.quantite);

	}

	/**
	 * Méthode permettant d'ajouter à la quantité commandé de l'article une quantité supplémentaire à commander.
	 * @param quantite - quantité à ajouter
	 */
	public void ajouterQuantite(int quantite) {
		if(quantite>article.getQuantiteStock()) {
			this.quantite+=article.getQuantiteStock();
			article.enleverQuantiteStock(article.getQuantiteStock());
		}
		else {
			article.enleverQuantiteStock(quantite);
			this.quantite+=quantite;
		}
	}

	/**
	 * Méthode retournant l'article de la ligne de commande.
	 * @return retourne l'article 
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 *	Méthode retournant le montant correspondant à la ligne de commande sans livraison (la quantité commandée * le prix de l'article).
	 *  @return retourne le montant total de la commande 
	 */
	public double getMontant() {
		return quantite*article.getPrix();
	}

	/**
	 *	Méthode retournant le montant correspondant à la ligne de commande sans livraison (la quantité commandée * le prix de l'article).
	 *  @return retourne le montant total de la commande en comptant la livraison 
	 */
	public double getMontantAvecLivraison() {
		return quantite*(article.getPrix()+((Livrable) article).coutLivraison());
	}

	/**
	 * Méthode retournant la quantité commandée.
	 * @return retourne la quantite de la commande
	 */
	public int getQuantite() {
		return quantite;
	}
	
	/**
	 * Méthode retournant une représentation textuelle de la ligne de commande.
	 * @return retourne les informations de la commande
	 */
	public String toString() {
		return "Référence Article : " + article.getReference()+"("+article.getDesignation()+")"+" | Prix Unitaire : "+article.getPrix() + "\nQuantité : " + quantite;
	}

}

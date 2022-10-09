package commande;

import java.util.ArrayList;

import article.Article;
import article.Livrable;
import client.Client;


/**
 * Un objet de la classe Commande correspond à une commande d'articles. Chaque commande a un numéro de référence et contient un ensemble de lignes de commande. Deux lignes de commande d'une commande ne peuvent pas être associées à un même produit. Une ligne de commande d'une commande ne peut pas être associée à la quantité 0. Une commande ne peut pas contenir plus de Commande.MAX_LIGNES lignes de commande. Une commande peut être clôturée. Lors de la clôture, les points de fidélite du client concerné sont mis à jour. Une fois clôturée, une commande ne peut plus être éditée/modifiée.
 * 
 * @author Maxence DEWADDER et Ethan JOAO
 * @version 1, 06/04/2022
 *
 */
public class Commande{
	/**
	 * Le nombre maximal de lignes de commande pouvant être dans une commande (valué à 10).
	 */
	private static final int MAX_LIGNES = 10;
	/**
	 * Le nombre de commande créés (sert également pour attribuer un numéro de référence).
	 */
	private static int nbCommandes=0;
	/**
	 * Numéro de référence de la commande.
	 */
	private int reference;
	/**
	 * Numéro de référence de la commande.
	 */
	private Client client;
	/**
	 * Booléen indiquant si la commande est clôturée.
	 */
	private boolean cloturee;
	/**
	 * Les lignes de commande se trouvant dans la commande.
	 */
	private ArrayList<LigneCommande> lignesCommande;
	
	/**
	 * Constructeur permettant de construire un nouvelle commande ne contenant aucune ligne de commande et associée au client passé en paramètre.
	 * @param client - Le client associé à la commande. 
	 */
	public Commande(Client client) {
		reference=nbCommandes;
		nbCommandes++;
		lignesCommande = new ArrayList<LigneCommande>();
		cloturee=false;
		this.client=client;
	}
	
	/**
	 * Méthode testant si la commande est pleine (si on ne peut pas ajouter de nouvelles commandes).
	 * @return true si et seulement si la commande est pleine.
	 */
	public boolean estPleine() {
		if (lignesCommande.size()==MAX_LIGNES) {
			return true;
		}
		return false;
	}
	
	/**
	 * Méthode testant si la commande est vide (il n'y a aucune ligne dans la commande).
	 * @return retourne true si la liste est pleine sinon, false	 */
	public boolean estVide() {
		if (lignesCommande.size()==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Méthode retournant l'article correspondant à une des lignes de commande de la commande.
	 * @param numLigneCommande - numéro de la ligne à retourner
	 * @return Article de rang numLigneCommande
	 */
	public Article getArticle(int numLigneCommande) {
		return lignesCommande.get(numLigneCommande).getArticle();
	}
	
	/**
	 * Méthode retournant le montant total de la commande sans livraison.
	 * @return retourne le montant de la commande.
	 */
	public double getMontant() {
		int somme = 0;
		for (int i=0;i<lignesCommande.size();i++) {
			somme+=lignesCommande.get(i).getMontant();
		}
		return somme-(somme*(client.getRistourne()/100));
	}
	
	/**
	 * Méthode retournant le montant total de la commande avec livraison.
	 * @return retourne le montant de la commande.
	 */
	public double getMontantAvecLivraison() {
		int somme = 0;
		for (int i=0;i<lignesCommande.size();i++) {
			if((lignesCommande.get(i)).getArticle() instanceof Livrable) {
				somme+=(lignesCommande.get(i).getMontantAvecLivraison());
			}
			else somme+=(lignesCommande.get(i).getMontant());
		}
		return somme-(somme*(client.getRistourne()/100));
	}
	
	/**
	 * 	Méthode retournant le nombre de lignes de commande de la commande.
	 *  @return nombre de ligne de la commande
	 */
	public int getNbLignesCommande() {
		return lignesCommande.size();
	}
	
	/**
	 * Méthode retournant la quantité commandée correspondant à une des lignes de commande de la commande.
	 * @param numLigneCommande - numéro de la ligne à modifier
	 * @return retourne quantite d'article de la commande de cet indice
	 */
	public int getQuantite(int numLigneCommande) {
		return lignesCommande.get(numLigneCommande).getQuantite();
	}
	
	/**
	 * Méthode retournant la référence de la commande.
	 * @return reference de la commande
	 */
	public int getReference() {
		return reference;
	}
	
	/**
	 * Méthode testant si la commande est pleine (si on ne peut pas ajouter de nouvelles commandes).
	 * @return état de la commande.
	 */
	public boolean estCloturee() {
		return cloturee;
	}
	
	/**
	 * Méthode permettant de commander une quantité d'un certain article.
	 * @param article article à commander
	 * @param quantite quantité a commander
	 * @return retourne false si impossible, true si on peut le commander.
	 */
	public boolean commander(Article article,int quantite) {
		if(((lignesCommande.size()>=MAX_LIGNES))||cloturee||(quantite==0)||(quantite>article.getQuantiteStock())){
			return false;
		}
		else { 
			if (this.chercherLigneCommande(article.getReference())!=null) {
				for (int i=0;i<lignesCommande.size();i++) {
					if((lignesCommande.get(i).getArticle().getReference())==article.getReference()) {
						lignesCommande.get(i).ajouterQuantite(quantite);
					}
				}
			}
			else {
				LigneCommande ajout = new LigneCommande(article,quantite);
				lignesCommande.add(ajout);
				nbCommandes++;
			}
			article.enleverQuantiteStock(quantite);
			return true;
		}
	}
	
	/**
	 * Méthode cherchant une ligne de commande dans la commande concernant un certaine référence d'article.
	 * @param refArticle - référence de l'article à chercher
	 * @return renvoie la ligne de commande correspodante à l'article mis en paramètre, sinon null
	 */
	private LigneCommande chercherLigneCommande(int refArticle) {
		for(int i=0;i<lignesCommande.size();i++) {
			if(lignesCommande.get(i).getArticle().getReference()==refArticle) {
				return lignesCommande.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Méthode permettant de supprimer une ligne de commande de la commande.
	 * @param refArticle - référence de l'article à supprimer
	 * @return true si la suppression est faite sinon false.
	 */
	public boolean supprimerLigneCommande(int refArticle) {
		LigneCommande lig = chercherLigneCommande(refArticle);
		if((!cloturee)&&(!(lig==null))){
			lig.getArticle().ajouterQuantiteStock(lig.getQuantite());
			lignesCommande.remove(lig);
			return true;
		}
		return false;
	}
	
	/**
	 * Méthode retournant si la commande est clôturée ou non.
	 * @param livraison - true si livraison sinon false
	 */
	public void cloturer(boolean livraison) {
		if (!cloturee) {
			if(livraison) {
				client.setPointsFidelite(client.getPointsFidelite()+(int)(this.getMontantAvecLivraison()/10));
			}
			else {
				client.setPointsFidelite(client.getPointsFidelite()+(int)(this.getMontant()/10));
			}
			cloturee=true;
		}
	}
	public String toString() {
		StringBuffer str = new StringBuffer("Numéro de commande : "+this.reference);
		if(this.cloturee) {str.append(" (Clôturée)");}
		else {str.append(" (Non clôturée)");}
		str.append("\nClient :" + client.toString()+"\nArticles commandés");
		for(int i =0;i<lignesCommande.size();i++) {
			str.append("\n***Ligne n°"+i+"***\n"+lignesCommande.get(i).toString()+"\n**************\n");
		}
		str.append("\nMontants \n Montant sans livraison : +" + this.getMontant() +"€\n Montant avec livraison "+ this.getMontantAvecLivraison()+"€");
		return str.toString();
	}

}

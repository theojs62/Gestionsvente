package commande;

import java.util.ArrayList;

/**
 * Un objet de la classe EnsembleCommandes correspond à un ensemble de commandes. Une nouvelle commande peut être créée et être insérée dans un ensemble de commandes. Une commande (clôturée) peut être également enlevée d'un ensemble de commandes. Au maximum MAX_COMMANDES pourront se trouver dans un ensemble de commandes.
 * 
 * @author Sébastien COZE
 * @version 1, 05/04/2022
 *
 */
public class EnsembleCommandes {
	
	/**
	 * Les commandes se trouvant dans l'ensemble de commandes.
	 */
	private ArrayList<Commande> commandes;
	/**
	 * Le nombre maximal de commandes dans un ensemble de commandes (valué à 1000).
	 */
	public static final int MAX_COMMANDES = 1000;
	
	/**
	 * Constructeur permettant de construire un nouvel ensemble de commandes ne contenant aucune commande.
	 */
	public EnsembleCommandes() {
		commandes = new ArrayList<Commande>();
	}
	
	/**
	 * Méthode testant si l'ensemble de commande est plein.
	 * @return true si et seulement si l'ensemble de commandes est plein.
	 */
	public boolean estPlein() {
		if (commandes.size() == MAX_COMMANDES) {
			return true;
		}
		else return false;
	}
	
	/**
	 * Méthode testant si l'ensemble de commandes est vide.
	 * @return true si et seulement si l'ensemble de commandes est vide.
	 */
	public boolean estVide() {
		if (commandes.size() == 0) {
			return true;
		}
		else return false;
	}
	
	/**
	 * Méthode cherchant une commande dans l'ensemble de commandes avec un certain numéro de référence. Dans le cas où il n'y a aucune commande correspondant au numéro de référence null est retourné.
	 * @param refCommande - Un entier supposé être une référence de commande.
	 * @return La commande de l'ensemble de commandes avec ce numéro de référence ou null si il n'existe pas une telle commande.
	 */
	public Commande chercherCommande​(int refCommande) {
		for (int i = 0; i < commandes.size(); i++) {
			if (commandes.get(i).getReference() == refCommande) {
				return commandes.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Méthode permettant de supprimer une commande de l'ensemble de commandes correspondant à un numéro de référence. Si la commande avec ce numéro de référence n'est pas dans l'ensemble rien est fait et false est retourné. Si la commande est présente mais n'est pas clôturée alors rien est fait et false est retourné. Dans les autres cas, la commande est supprimée de l'ensemble et true est retourné.
	 * @param refCommande - Un entier supposé être une référence de commande.
	 * @return true si et seulement une suppression effective de la commande a été réalisée.
	 */
	public boolean supprimerCommande​(int refCommande) {
		Commande cmd = this.chercherCommande​(refCommande);
		if ((cmd != null)&& !(estVide())) {
			if(cmd.estCloturee()) {
				commandes.remove(commandes.indexOf(cmd));
				return true;
			}
			else {
				return false;
			}
		}
		else return false;
	}
	
	/**
	 * Méthode permettant d'ajouter une commande à l'ensemble de commandes. Si l'ensemble est plein rien est fait.
	 * @param commande - La commande a ajouter (supposée non null).
	 */
	public void ajouterCommande​(Commande commande) {
		if (commande != null && !(estPlein())) commandes.add(commande);
	}
	
	/**
	 * Méthode retournant un nouveau tableau contenant toutes les commandes de l'ensemble.
	 * @return Un nouveau tableau contenant les commandes de l'ensemble.
	 */
	public Commande[] getCommandes() {
		return commandes.toArray(new Commande[commandes.size()]);
	}
	
	/**
	 * Méthode permettant d'afficher l'ensemble de commandes.
	 */
	public void afficher() {
		if (!this.estVide()) {
			for (int i = 0; i < commandes.size(); i++) {
				System.out.println(commandes.get(i).toString()+"\n");
			}
		}
		else System.err.print("/!\\ Cet ensemble de commande est vide.");
	}
	
}

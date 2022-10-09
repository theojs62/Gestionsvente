package client;

import util.Util;
/**
 * Un objet de la classe Client correspond à un client.
 * 
 * @author Maxence DEWADDER
 * @version 1, 04/04/2022
 *
 */
public abstract class Client {
	/**
	 * Le nombre de clients créés (à initialiser avec 0).
	 */
	private static int nbClients = 0;
	/**
	 * La référence du client.
	 */
	private int reference;
	/**
	 * Le nombre de points de fidélité.
	 */
	private int pointsFidelite;
	/**
	 * Le nom du client.
	 */
	private String nom;
	/**
	 * Le nom du client.
	 */
	private String adresse;
	
	/**
	 * Constructeur permettant d'initialiser un nouveau client avec son nom, son adresse et ses points de fidélité.
	 * @param nom - Le nom du client
	 * @param adresse - L'adresse du client
	 * @param pointsFidelite - Le nombre de points de fidelité du client
	 */
	protected Client(String nom, String adresse, int pointsFidelite) {
		this.nom=nom;
		this.adresse=adresse;
		this.pointsFidelite=pointsFidelite;
		reference = nbClients;
		nbClients++;
	}

	/**
	 * Constructeur permettant d'initialiser un nouveau client en effectuant la saisie au clavier de son nom, son adresse et ses points de fid�lit� (en utilisant la méthode saisirInfos()).
	 */
	protected Client() {
		saisirInfos();
		this.pointsFidelite=0;
		reference = nbClients;
		nbClients++;
	}

	/**
	 * Méthode permettant de saisir le nom et l'adresse du client.
	 */
	public void saisirInfos() {
		this.nom=Util.saisirChaine("Nom : ");
		this.adresse=Util.saisirChaine("Adresse : ");
	}

	/**
	 * Méthode retournant le nombre de points de fidélité du client.
	 * @return Retourne les points de fidélité du client.
	 */
	public int getPointsFidelite() {
		return pointsFidelite;
	}

	/**
	 * Les points de fidélité donnent droit à une ristourne sur le montant total d'une commande.
	 * @return Retourne le pourcentage de remise du client.
	 */
	public int getRistourne() {
		if((pointsFidelite>=100)&&(pointsFidelite<500)) {
			return 5;
		}
		if((pointsFidelite>=500)&&(pointsFidelite<100)) {
			return 10;
		}
		if (pointsFidelite>1000) {
			return 15;
		}
		return 0;
	}

	/**
	 * Définie les points de fidélité du client
	 * @param pointsFidelite - Le nouveau nombre de points de fidelité du client.
	 */
	public void setPointsFidelite(int pointsFidelite) {
		this.pointsFidelite = pointsFidelite;
	}

	/**
	 * Cette méthode permet de retourner le nom du client.
	 * @return Le nom du client.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode permettant de modifier le nom du client.
	 * @param nom - Le nouveau nom du client
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode retournant l'adresse du client.
	 * @return l'adresse du client.
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Méthode permettant de modifier l'adresse du client.
	 * @param adresse - La nouvelle adresse du client
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Méthode retournant le numéro de reference du client.
	 * @return Numero du client.
	 */
	public int getReference() {
		return reference;
	}

	/**
	 * Méthode (redéfinition de toString()) retournant une représentation textuelle d'un client.
	 * @return Retourne le nom, l'adresse,la reference et les points de fidete du client.
	 */
	public String toString() {
		return "Nom : "+ nom + "\nAdresse : " + adresse + "\nRéference : " + reference + "\nPointsFidelite : " + pointsFidelite; 
	}

	/**
	 * Méthode permettant de tester si deux clients sont les memes : deux clients sont les memes si et seulement ils ont la meme reference.
	 * @param client - L'objet (normalement non null et de type Client) qui sera comparé avec le client actuel
	 * @return Return vrai ou faux si les objets sont identiques ou non.
	 */
	public boolean equals(Object client) {
		if((client==null)||(!(client instanceof Client))) return false;
		else return ((Client) client).getReference() == this.getReference();
	}

	/**
	 * Méthode permettant d'afficher les clients d'un tableau de clients.
	 * @param clients - Le tableau de clients à afficher
	 */
	public static void afficherTabClients(Client[] clients) {
		for (int i=0;i<clients.length;i++) {
			System.out.println("***Client n°"+i+"***\n"+clients[i].toString()+"\n");
		}
	}
	
	/**
	 * Méthode permettant de trier un tableau de clients selon l'ordre alphabetique des noms des clients.
	 * @param clients - Le tableau de clients à trier
	 */
	public static void trierTabClients(Client[] clients) {
		for (int i=0;i<clients.length;i++) {
			for (int y=0;y<clients.length-1;y++) {
				if(clients[y].getNom().compareTo(clients[y+1].getNom())>0) {
					Client tmp;
					tmp=clients[y+1];
					clients[y+1]=clients[y];
					clients[y]=tmp;
				}
			}
		}
	}
}

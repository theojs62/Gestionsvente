package client;

import java.util.ArrayList;

/**
 * Cette classe correspond à un carnet de clients.
 * 
 * @author Sébastien COZE
 * @version 2, 06/04/2022
 *
 */
public class CarnetClients {
	
	/**
	 * Le nombre maximum de client dans un carnet. Il est à 25.
	 */
	public final int MAX_CLIENTS = 25;
	/**
	 * Le nombre de client dans le carnet.
	 */
	private int nbClients;
	/**
	 * Le nom du carnet de clients.
	 */
	private String nom;
	private Client[] clients;
	
	/**
	 * Constructeur permettant de créer un carnet de clients.
	 * @param nom - Le nom du carnet de clients
	 */
	public CarnetClients(String nom) {
		nbClients = 0;
		this.nom = nom;
		clients = new Client[MAX_CLIENTS];
	}
	
	/**
	 * Méthode permettant de savoir si le carnet est plein.
	 * @return true si le carnet est plein.
	 */
	public boolean estPlein() {
		return MAX_CLIENTS <= nbClients;
	}
	
	/**
	 * Méthode permettant de savoir si le carnet est vide.
	 * @return true si le carnet est complétement vide.
	 */
	public boolean estVide() {
		return nbClients == 0;
	}
	
	/**
	 * Méthode cherchant un client dans le tableau clients correspondant (ayant même référence) au client passé en parmaètre.
	 * @param client - Un client (supposé non null).
	 * @return L'indice où se trouve ce client dans le tableau clients. Dans le cas où le client n'est pas présent -1 est retourné.
	 */
	private int chercherIndiceClient(Client client) {
		if (client != null) {
			for (int i = 0; i < nbClients; i++) {
				if (clients[i].equals(client)) {
					return i;
				}
			}
			return -1;
		}
		else return -1;
	}
	
	/**
	 * Méthode permettant de supprimer un client du carnet. Rien est fait dans le cas où le client n'est pas présent dans le carnet.
	 * @param client - Un client (supposé non null).
	 */
	public void ajouterClient(Client client) {
		if (client != null) {
			if (!(this.estPlein()) || (this.chercherIndiceClient(client) == -1)) {
				clients[nbClients] = client;
				nbClients++;
			}
		}
	}
	
	/**
	 * Méthode permettant de supprimer un client du carnet. Rien est fait dans le cas où le client n'est pas présent dans le carnet.
	 * @param client - Un client (supposé non null).
	 */
	public void supprimerClient​(Client client) {
		int indice;
		if (client != null) {
			indice = this.chercherIndiceClient(client);
			clients[indice] = clients[nbClients - 1];
			clients[nbClients - 1] = null;
			nbClients--;
		}
	}
	
	/**
	 * Méthode permettant de chercher un client dans le carnet avec son numéro de référence.
	 * @param refClient - La référence du client recherché.
	 * @return Le client dans le carnet ayant refClient comme référence ou null si un tel client n'existe pas.
	 */
	public Client rechercherClientParReference​(int refClient) {
		for (int i = 0; i < nbClients; i++) {
			if (clients[i].getReference() == refClient) {
				return clients[i];
			}
		}
		return null;
	}
	
	/**
	 * Méthode retournant un nouveau tableau contenant les clients du carnet. Le tableau retourné a pour taille getNbClients().
	 * @return Un nouveau tableau non null contenant les clients du carnet.
	 */
	public Client[] clientsDansCarnet() {
		Client[] clients = new Client[this.getNbClients()];
		for (int i = 0; i < nbClients; i++) {
			clients[i] = this.clients[i];
		}
		return clients;
	}
	
	/**
	 * Méthode retournant un nouveau tableau contenant les clients de type particulier du carnet.
	 * @return Un nouveau tableau non null contenant les clients de type particulier du carnet.
	 */
	public Client[] clientsParticulierDansCarnet() {
		ArrayList<Client> clients= new ArrayList<Client>();
		for (int i = 0; i < nbClients; i++) {
			if (this.clients[i] instanceof ClientParticulier) {
				clients.add(this.clients[i]);
			}
		}
		return clients.toArray(new Client[0]);
	}

	/**
	 * Méthode retournant un nouveau tableau contenant les clients de type entreprise du carnet.
	 * @return Un nouveau tableau non null contenant les clients de type entreprise du carnet.
	 */
	public Client[] clientsEntrepriseDansCarnet() {
		ArrayList<Client> clients = new ArrayList<Client>();
		for (int i = 0; i < nbClients; i++) {
			if (this.clients[i] instanceof ClientEntreprise) {
				clients.add(this.clients[i]);
			}
		}
		return clients.toArray(new Client[0]);
	}
	
	/**
	 * Méthode permettant de chercher des clients se trouvant dans le carnet à l'aide d'un mot clé. Les clients sélectionnés sont ceux dont le nom ou l'adresse contient le mot clé spécifié. La sélection tient compte de la casse. La méthode retourne un tableau de clients (toujours non null et pouvant contenir aucun élément si aucun client a été sélectionné).
	 * @param motCle - Le mot clé cherché dans les noms et les adresses.
	 * @return Un tableau contenant les clients trouvés dans le carnet dont l'adresse ou le nom contient le motCle.
	 */
	public Client[] rechercherClientsParMotCle​(String motCle) {
		ArrayList<Client> tab= new ArrayList<Client>();
		if (motCle != null) {
				for (int i = 0; i < nbClients; i++) {
					if (this.clients[i].getNom().contains(motCle) || this.clients[i].getAdresse().contains(motCle)) {
						tab.add(clients[i]);
					}
				}
				return tab.toArray(new Client[0]);
		}
		else return null;
	}
	
	/**
	 * Méthode retournant le nom du carnet de clients.
	 * @return Le nom du carnet de clients.
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Méthode permettant de modifier le nom du carnet de clients.
	 * @param nom - Le nouveau nom du carnet.
	 */
	public void setNom​(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Méthode retournant le nombre de clients du carnet.
	 * @return Le nombre de clients dans le carnet.
	 */
	public int getNbClients() {
		return nbClients;
	}
	
}

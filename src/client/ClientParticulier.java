package client;

import util.Util;

/**
 * Un objet de la classe ClientParticulier represente un client correspondant a un particulier. Un client qui est un particulier a un nom de contact comme caracteristique supplementaire.
 * @author Dewadder Maxence 
 * @version 1, 04/04/2022
 */
public class ClientParticulier extends Client {
	/**
	 * Le genre du client de type particulier.
	 */
	private Genre genre;
	/**
	 * Le prénom du client de type particulier.
	 */
	private String prenom;
	/**
	 * Constructeur permettant d'initialiser un nouveau client de type particulier avec son nom, son adresse, son nom et son genre.
	 * @param nom - Le nom du particulier
	 * @param adresse - L'adresse du particulier
	 * @param pointsFidelite - Le nombre de points de fidelité du particulier
	 * @param prenom - Le prénom du particulier
	 * @param genre - Le genre du particulier (Homme ou Femme)
	 */
	public ClientParticulier(String nom, String adresse, int pointsFidelite,String prenom, Genre genre) {
		super(nom,adresse,pointsFidelite);
		this.prenom=prenom;
		this.genre=genre;
	}

	/**
	 * Constructeur permettant d'initialiser un nouveau client de type particulier en effectuant la saisie au clavier de son nom, son adresse, son nom et son genre (en utilisant la methode saisirInfos()).
	 */
	public ClientParticulier() {
		super();
	}

	/**
	 * Methode permettant de saisir le nom, l'adresse, le nom et le genre d'un client de type particulier.
	 */
	public void saisirInfos() {
		super.saisirInfos();
		this.prenom=Util.saisirChaine("PrÃ©nom : ");
		boolean retenter = true;
		while(retenter){
			try {
				this.genre=Genre.valueOf(Util.saisirChaine("Genre : "));
				retenter = false;
			}
			catch(java.lang.IllegalArgumentException e) {System.out.println("Erreur, Genre impossible, veuillez retenter :");}
		}
	}

	/**
	 * Methode retournant le genre du client de type particulier.
	 * @return Retourne le genre du client
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * Methode permettant de modifier le genre du client de type particulier.
	 * @param genre - Le nouveau genre du client particulier (Homme ou Femme)
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * 	Methode retournant le prénom du client de type particulier.
	 *  @return le prénom du client de type particulier
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Methode (redefinition de toString()) retournant une representation textuelle du client de type particulier.
	 *  @return Retourne le nom, l'adresse,la reference , les points du client et son nom. 
	 */
	public String toString() {
		return super.toString()+"\nPrÃ©nom : "+prenom;
	}
	
	/**
	 * Methode permettant de modifier le prénom du client de type particulier.
	 * @param prenom - Le nouveau prénom du particulier
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}

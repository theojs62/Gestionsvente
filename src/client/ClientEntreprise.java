package client;

import util.Util;

/**
 * Un objet de la classe ClientEntreprise represente un client correspondant a une entreprise. Un client qui est une entreprise a un nom de contact (une chaine de caracteres) comme caracteristique supplementaire.
 * @author Maxence DEWADDER et Sébastien COZE
 * @version 1, 04/04/2022
 */
public class ClientEntreprise extends Client {
	/**
	 * Le nom du contact de l'entreprise.
	 */
	private String contact;

	/**
	 * Constructeur permettant d'initialiser un nouveau client de type entreprise avec son nom, son adresse et le nom du contact. Son numero de reference est generer automatiquement.
	 * @param nom - Le nom de l'entreprise
	 * @param adresse - L'adresse de l'entreprise
	 * @param pointsFidelite - Le nombre de points de fidelité de l'entreprise
	 * @param contact - Le contact de l'entreprise 
	 */
	public ClientEntreprise(String nom, String adresse, int pointsFidelite, String contact) {
		super(nom,adresse,pointsFidelite);
		this.contact=contact;
	}

	/**
	 * Constructeur permettant d'initialiser un nouveau client de type entreprise en effectuant la saisie au clavier de son nom, son adresse et le nom de son contact (en utilisant la methode saisirInfos()). Son numero de reference est generer automatiquement.
	 */
	public ClientEntreprise() {
		super();
	}

	/**
	 * Methode permettant de saisir le nom, l'adresse et le contact d'un client de type entreprise.
	 */
	public void saisirInfos() {
		super.saisirInfos();
		this.contact=Util.saisirChaine("Contact : ");
	}

	/**
	 * Methode (redefinition de toString()) retournant une representation textuelle du client de type entreprise.
	 * @return Renvoie Retourne le nom, l'adresse,la reference et les points du client ainsi que son contact.
	 */
	public String toString() {
		return super.toString()+"\nContact : "+contact;
	}

	/**
	 * Methode retournant le contact de l'entreprise.
	 * @return renvoie le contact 
	 */
	public String getContact() {
		return contact;
	}
	
	/**
	 * Methode permettant de modifier le contact de l'entreprise.
	 * @param contact - Le nouveau contact de l'entreprise.
	 */
	public void setContact(String contact) {
		this.contact=contact;
	}
	
}

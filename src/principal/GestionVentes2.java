package principal;

import article.*;
import gestionnaire.*;
import client.*;
import commande.*;
/**
 * Le programme principal de l'application de gestion de ventes.
 * @author Jean-François Condotta
 * @version 17/03/22
 *
 */
public class GestionVentes2 {
	/**
	 * Le nom de l'entreprise réalisant les ventes d'articles.
	 */
	static final public String nomEntreprise="SmartLitterature";
	/**
	 * Les prénoms et noms des gérants.
	 */
	static final public String nomsGerants="Sébastien Coze & Journée Théo & Dewaderre Maxence & Joao Ethan";
	
	/**
	 * Le programme principal de l'application de gestion des ventes.
	 * @param args Pas d'arguments.
	 */
	public static void main(String[] args) {
		//ARTICLES
		Stock stock=new Stock("Stock 2022");
		//Articles sans satégorie
		stock.ajouterArticle(new Article("Lampe de Lecture LED",32.0,50));
		stock.ajouterArticle(new Article("Kindle",49.99,30));
		stock.ajouterArticle(new Article("Lampe de Lecture",20.0,25));
		stock.ajouterArticle(new Article("Lunettes de Lecture ALTAYA",5.0,100));
		stock.ajouterArticle(new Article("Kindle Lite",24.99,60));
		stock.ajouterArticle(new Article("Illustations Collector CONAN Le Cimmérien",10.00,25));
		stock.ajouterArticle(new Article("Illustrations Collector 'La Mort' de DiscWorld",10.00,25));
		stock.ajouterArticle(new Article("Illustrations Collector Harry Potter",10.00,50));
		stock.ajouterArticle(new Article("Illustrations Collector JoJo's Bizarre Adventures",10.00,10));
		stock.ajouterArticle(new Article("Lunettes de Lecture Ray-Boon",25.00,75));
		//Article catégorie 1 - AudioBook
		stock.ajouterArticle(new ArticleCat1("Temps des Tempête vers.Sar",9.99,200,"Le Temps des Tempêtes","Nicolas Sarkozy","Annulay",article.Genre.Drame,"Nicolas Sarkozy"));
		stock.ajouterArticle(new ArticleCat1("Bébés zappeurs vers.Lecordier",9.99,150,"Le Ras le bol des bébés zappeurs","Ségolène Royale","Robert Laffont",article.Genre.SF,"Brigitte Lecordier"));
		stock.ajouterArticle(new ArticleCat1("Petit Chap Rouge vers.Reignoux",9.99,150,"Le Petit Chaperon Rouge","Charles Perrault","Annulay",article.Genre.Drame,"Donald Reignoux"));
		stock.ajouterArticle(new ArticleCat1("Temps des Tempête vers.Lecordier",9.99,200,"Le Temps des Tempêtes","Nicolas Sarkozy","Annulay",article.Genre.Drame,"Brigitte Lecordier"));
		stock.ajouterArticle(new ArticleCat1("Ça T1 vers.Ratsito",9.99,150,"Ça Tome 1","Stephen King","Annulay",article.Genre.Horreur,"Enzo Ratsito"));
		stock.ajouterArticle(new ArticleCat1("Ça T2 vers.Ratsito",9.99,150,"Ça Tome 2","Stephen King","Annulay",article.Genre.Horreur,"Enzo Ratsito"));
		stock.ajouterArticle(new ArticleCat1("Ça T3 vers.Ratsito",9.99,150,"Ça Tome 3","Stephen King","Annulay",article.Genre.Horreur,"Enzo Ratsito"));
		stock.ajouterArticle(new ArticleCat1("principe responsabilité vers.Macro",9.99,150,"Le Principe responsabilité","Hans Jonas","Annulay",article.Genre.Science,"Emanuelle Macro"));
		stock.ajouterArticle(new ArticleCat1("Lethal Pursuit vers.Antony Ferguson", 9.99, 150, "Lethal Pursuit", "Will Thomas", "Baker & Llewelyyn Series", article.Genre.Policier, "Antony Ferguson"));
		stock.ajouterArticle(new ArticleCat1("Jekyll & Hyde vers.Eric&Ramzy",9.99,150,"L'Étrange Cas du docteur Jekyll et de M. Hyde ","Robert Louis Stevenson","Annulay",article.Genre.Fantasy,"Eric et Ramzy"));
		//Articles catégories 2 - Livres
		stock.ajouterArticle(new ArticleCat2("Assassin Royal T1",15.99,60,"L'Assassin Royal Tome 1 : L'Apprenti assassin","Robin Hobb","Pygmalion",article.Genre.Fantasy,1,18,11,30));
		stock.ajouterArticle(new ArticleCat2("Assassin Royal T2",15.99,60,"L'Assassin Royal Tome 2 : L'Apprenti du Roi","Robin Hobb","Pygmalion",article.Genre.Fantasy,1,18,11,30));
		stock.ajouterArticle(new ArticleCat2("Assassin Royal T3",15.99,60,"L'Assassin Royal Tome 3 : La Nef du Crépuscule","Robin Hobb","Pygmalion",article.Genre.Fantasy,1,18,11,30));
		stock.ajouterArticle(new ArticleCat2("Assassin Royal T4",15.99,60,"L'Assassin Royal Tome 4 : Le Poison de la vengeance","Robin Hobb","Pygmalion",article.Genre.Fantasy,1,18,11,30));
		stock.ajouterArticle(new ArticleCat2("Assassin Royal T5",15.99,60,"L'Assassin Royal Tome 5 : La Voie magique","Robin Hobb","Pygmalion",article.Genre.Fantasy,1,18,11,30));
		stock.ajouterArticle(new ArticleCat2("Assassin Royal T6",15.99,60,"L'Assassin Royal Tome 6 : La Reine solitaire","Robin Hobb","Pygmalion",article.Genre.Fantasy,1,18,11,30));
		stock.ajouterArticle(new ArticleCat2("Timbré",15.99,30,"Les Annales du Disque-monde : Timbré","Terry Pratchett","L'Atalante",article.Genre.Fantasy,1,18,11,20));
		stock.ajouterArticle(new ArticleCat2("Monnayé",15.99,30,"Les Annales du Disque-monde : Monnayé","Terry Pratchett","L'Atalante",article.Genre.Fantasy,1,18,11,20));
		stock.ajouterArticle(new ArticleCat2("Soeurcières",15.99,30,"Les Annales du Disque-monde : Trois soeurcières","Terry Pratchett","L'Atalante",article.Genre.Fantasy,1,18,11,20));
		stock.ajouterArticle(new ArticleCat2("Le Faucheur",15.99,30,"Les Annales du Disque-monde : Le Faucheur","Terry Pratchett","L'Atalante",article.Genre.Fantasy,1,18,11,20));

		//CLIENTS
		CarnetClients carnetClients=new CarnetClients("Carnet Clients 2022");
		//Clients Particuliers
		carnetClients.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62300 Lens, France",0,"Hector",client.Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Tournesol","123 rue des narcisses, 62300 Lens, France",2000,"Jonquille",client.Genre.Femme));
		carnetClients.ajouterClient(new ClientParticulier("Joao","666 rue des oeillets blancs, 62232 Hinges, France",150,"Ethan",client.Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Journée","42 rue du Centaurée, 62300 Lens, France",300,"Théo",client.Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Coze","32 rue du Centaurée, 62300 Lens, France",300,"Sébastien",client.Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Oedipe","54 rue des cactus, 62300 Lens, France",300,"Laïos",client.Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Dewaderre","177013 rue des Jasmins, 62160 Bully-Les-Mines, France",300,"Maxence",client.Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Galatée","69 rue du Myosotis, 62300 Lens, France",300,"Jeanne",client.Genre.Femme));
		carnetClients.ajouterClient(new ClientParticulier("Pygmalion","69 rue du Myosotis, 62300 Lens, France",300,"Jeanne",client.Genre.Homme));
		carnetClients.ajouterClient(new ClientParticulier("Pandore","69 rue des colchiques, 62400 Béthune, France",300,"Jeanne",client.Genre.Femme));

		//Clients Entreprise
		carnetClients.ajouterClient(new ClientEntreprise("KIRA and Co.","42 boulevard des Marguerites, 62300 Lens, France",10,"Francis Chêne"));
		carnetClients.ajouterClient(new ClientEntreprise("GIGA and Co.","22 impasse des Lilas, 62300 Lens, France",500,"René Tilleul"));
		carnetClients.ajouterClient(new ClientEntreprise("Nintendor","54 rue Zalde, 46201 Montcuq-en-Quercy-Blanc",750,"Reggie Fille-Aimé"));
		carnetClients.ajouterClient(new ClientEntreprise("Playstachouffle","62 impasse de l'inexplorée, 46201 Montcuq-en-Quercy-Blanc",150,"Kazua Mirai"));
		carnetClients.ajouterClient(new ClientEntreprise("Xboxard","54 boulevard Allo, 46201 Montcuq-en-Quercy-Blanc",2350,"Bill Portail"));
		carnetClients.ajouterClient(new ClientEntreprise("Pécéairedaigle","54 rue Cémieux, 46201 Montcuq-en-Quercy-Blanc",325,"Tux"));
		carnetClients.ajouterClient(new ClientEntreprise("MCQueensey","13 rue blanche, 75000 Paris",6000,"George Tuséki"));
		carnetClients.ajouterClient(new ClientEntreprise("Crypton INC","74 impasse Miku, 62232 Annezin",9999,"Kasane Teto"));
		carnetClients.ajouterClient(new ClientEntreprise("Colorful Palette","39 rue UTAU, 62232 Annezin",3939,"Kagamine Rin"));
		carnetClients.ajouterClient(new ClientEntreprise("Ghibly","1234 boulevard Totoro, 62400 Béthune",9393,"Hayato Miyazuki"));
		
		//COMMANDES
		EnsembleCommandes ensembleCommandes=new EnsembleCommandes();
		Commande commande1 = new Commande(carnetClients.rechercherClientParReference​(0));
		commande1.commander(stock.rechercherArticleParReference(0), 1);
		ensembleCommandes.ajouterCommande​(commande1);
		Commande commande2 = new Commande(carnetClients.rechercherClientParReference​(10));
		commande2.commander(stock.rechercherArticleParReference(10), 2);
		commande2.cloturer(false);
		ensembleCommandes.ajouterCommande​(commande2);
		Commande commande3 = new Commande(carnetClients.rechercherClientParReference​(5));
		commande3.commander(stock.rechercherArticleParReference(20), 1);
		commande3.commander(stock.rechercherArticleParReference(21), 1);
		commande3.cloturer(true);
		ensembleCommandes.ajouterCommande​(commande3);
		GestionnairePrincipal gestionnairePrincipal=new GestionnairePrincipal("Gestion des ventes - "+nomEntreprise+"\n"+nomsGerants,ensembleCommandes,carnetClients,stock);
		gestionnairePrincipal.afficherGererMenu();

	}

}

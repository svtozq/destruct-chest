import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class jeux {

    private boolean win;

    // Constructeur
    public jeux(){
        win = false;
    }

    public void demarelejeux() {
        // Crée un cadrillage avec 10 lignes et 11 colonnes
        Cadrillage cadrillage = new Cadrillage(10, 11);
        cadrillage.afficher();

        // Crée une liste pour les joueurs (personnages)
        ArrayList<Personage> joueurs = new ArrayList<>();
        ArrayList<String> pseudosUtilises = new ArrayList<>(); // Liste pour suivre les pseudos choisis
        ArrayList<String> personnagesUtilises = new ArrayList<>(); // Liste pour suivre les personnages choisis

        // Choisir les personnages pour 2 joueurs
        int nombreDeJoueurs = 2;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("conbien de jouer");
            try {
                nombreDeJoueurs = scanner.nextInt();

                if (nombreDeJoueurs > 0 && nombreDeJoueurs < 5) {
                    break;
                } else {
                    System.out.println("Choisissez un nombre persone entre 1 et 4.");
                }
            }catch (InputMismatchException e) {
                // Gérer l'erreur si l'utilisateur entre une lettre ou un caractère spécial
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier entre 1 et 4.");
                scanner.nextLine(); // Consommer la ligne erronée pour éviter une boucle infinie

            }
        }

        for (int i = 0; i < nombreDeJoueurs; i++) {
            Personage joueur = Personage.choisirPersonage(i+1, pseudosUtilises, personnagesUtilises);
            joueurs.add(joueur);

            // Ajouter le pseudo et le personnage à la liste des choix déjà effectués
            pseudosUtilises.add(joueur. recupPseudo());
            personnagesUtilises.add(joueur.recupPersonnage());

        }

        // Place les personnages dans le tableau
        for (int i = 0; i < joueurs.size(); i++) {
            Personage joueur = joueurs.get(i);
            cadrillage.placerPersonnage(i, i, joueur);
        }

        // Affiche le tableau avec les personnages
        cadrillage.afficher();
        this.partie(cadrillage, joueurs, nombreDeJoueurs);
    }

    public void partie(Cadrillage cadrillage, ArrayList<Personage> joueurs, int nombreDeJoueurs) {
        while(true){

            for(int i = 0; i < nombreDeJoueurs; i++){
                Personage joueur = joueurs.get(i);
                cadrillage.deplacerPersonnage(joueur);
                if(joueur.recupEnvie()) {
                    cadrillage.detruireterin();
                    cadrillage.afficher();
                }
            }
            byte jenvie=0;
            for(int i = 0; i < nombreDeJoueurs; i++){
                Personage joueur = joueurs.get(i);
                if(joueur.recupEnvie()){
                    jenvie++;
                }
                if(jenvie==2){
                    break;
                }
            }
            if(jenvie==1){
                this.win = true;
            }

            if(this.win){
                break;//partie ganier
            }
        }
        for(int i = 0; i < nombreDeJoueurs; i++){
            Personage joueur = joueurs.get(i);
            if(joueur.recupEnvie()){
                System.out.println(joueur.recupPseudo()+" a ganier la partie");
                Personage.GestionGagnant.ajoutGagnant("scores.txt", Personage.GestionGagnant.trouverGagnant(joueurs));
                break;
            }
        }
    }
}

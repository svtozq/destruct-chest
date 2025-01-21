import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Crée un cadrillage avec 10 lignes et 11 colonnes
        Cadrillage cadrillage = new Cadrillage(10, 11);
        cadrillage.afficher();

        // Crée une liste pour les joueurs (personnages)
        ArrayList<Personage> joueurs = new ArrayList<>();

        // Choisir les personnages pour 2 joueurs
        int nombreDeJoueurs = 2;
        for (int i = 0; i < nombreDeJoueurs; i++) {
            Personage joueur = Personage.choisirPersonage(i + 1);
            joueurs.add(joueur);
        }

        // Affiche le tableau après la destruction
        cadrillage.destruction(1, 1);
        cadrillage.destruction(2, 2);
        cadrillage.destruction(3, 3);
        cadrillage.destruction(2, 4);
        cadrillage.destruction(1, 5);
        cadrillage.afficher();

        // Place les personnages dans le tableau
        for (int i = 0; i < joueurs.size(); i++) {
            Personage joueur = joueurs.get(i);
            cadrillage.placerPersonnage(i, i, joueur.getPersonnage());
        }

        // Affiche le tableau avec les personnages
        cadrillage.afficher();
    }
}

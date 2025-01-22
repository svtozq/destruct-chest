import java.util.ArrayList;

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
        for (int i = 0; i < nombreDeJoueurs; i++) {
            Personage joueur = Personage.choisirPersonage(i+1, pseudosUtilises, personnagesUtilises);
            joueurs.add(joueur);

            // Ajouter le pseudo et le personnage à la liste des choix déjà effectués
            pseudosUtilises.add(joueur. recupPseudo());
            personnagesUtilises.add(joueur.recupPersonnage());

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
            cadrillage.placerPersonnage(i, i, joueur);
        }

        // Affiche le tableau avec les personnages
        cadrillage.afficher();
        cadrillage.deplacerPersonnage((byte)3,(byte)3,joueurs.get(0));
        cadrillage.deplacerPersonnage((byte)2,(byte)2,joueurs.get(0));
        cadrillage.deplacerPersonnage((byte)2,(byte)4,joueurs.get(0));
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
                break;
            }
        }
    }
}

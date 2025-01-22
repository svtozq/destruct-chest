public class Scores {
    private int lignes;
    private int colonnes;
    private String [][] tableau;

    // fonction du tableau
    public Scores(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.tableau = new String[lignes][colonnes];

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
            }
        }

    }

    // fonction d'affichage du tableau
    public void afficheScore () {
        // boucle qui affiche les lignes et colonnes du tableau
        for (int i = 0; i < lignes; i++ ){
            // boucle qui affiche les séparations
            for (int j = 0; j < lignes; j++) {
                System.out.println("----");
            }

            // boucle qui affiche les cases
            for (int j = 0; j < colonnes; i++){
                System.out.println("| " + tableau[i][j]);
            }
            System.out.println(" |");
        }
    }

    public static void main (String[] args) {

    }

}

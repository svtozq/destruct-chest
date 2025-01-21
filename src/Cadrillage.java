
public class Cadrillage {

    private int lignes;    // Nombre de lignes
    private int colonnes;  // Nombre de colonnes
    private String[][] tableau;  // Tableau pour stocker les données des cellules

    // Constructeur qui initialise le cadrillage avec un nombre de lignes et de colonnes
    public Cadrillage(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.tableau = new String[lignes][colonnes];  // Initialisation du tableau pour stocker les données

        // Remplir le tableau avec des valeurs par défaut, ici des numéros de cellule par exemple
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                tableau[i][j] = "\033[47m \033[0m";  // Exemple de données par défaut
            }
        }
    }

    // Méthode pour afficher le cadrillage dans la console
    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            // Afficher la ligne horizontale (séparateurs entre les cases)
            for (int j = 0; j < colonnes; j++) {
                System.out.print("+---");  // Un séparateur simple
            }
            System.out.println("+");

            // Afficher les données de chaque cellule
            for (int j = 0; j < colonnes; j++) {
                System.out.print("| " + tableau[i][j] + " ");  // Affichage des données dans chaque cellule
            }
            System.out.println("|");
        }

        // Dernière ligne horizontale en bas
        for (int j = 0; j < colonnes; j++) {
            System.out.print("+---");  // Un séparateur simple
        }
        System.out.println("+");
    }

    // Méthode pour afficher une casse du cadrillage en rouge
    public void destruction(int lignes , int colonnes){
        this.tableau[lignes][colonnes] = "\033[41m \033[0m";
    }

    // Méthode principale pour exécuter l'affichage
    public static void main(String[] args) throws InterruptedException {

        // Crée un cadrillage avec 5 lignes et 4 colonnes
        Cadrillage cadrillage = new Cadrillage(10, 11);
        cadrillage.afficher();
        Thread.sleep(2000);
        cadrillage.destruction(1, 1);
        cadrillage.destruction(2, 2);
        cadrillage.destruction(3, 3);
        cadrillage.destruction(2, 4);
        cadrillage.destruction(1, 5);
        cadrillage.afficher();
        System.out.println("\033[47m \033[0m");

    }
}

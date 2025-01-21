public class Cadrillage {

    private int lignes;    // Nombre de lignes
    private int colonnes;  // Nombre de colonnes
    private String[][] tableau;  // Tableau pour stocker les données des cellules

    // Constructeur
    public Cadrillage(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.tableau = new String[lignes][colonnes];  // Initialisation du tableau pour stocker les données

        // Remplir le tableau avec des valeurs par défaut
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                tableau[i][j] = "\033[47m  \033[0m";  // Exemple de données par défaut
            }
        }
    }

    // Méthode pour afficher le cadrillage dans la console
    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            // Afficher la ligne horizontale (séparateurs entre les cases)
            for (int j = 0; j < colonnes; j++) {
                System.out.print("+----");  // Un séparateur simple
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
            System.out.print("+----");  // Un séparateur simple
        }
        System.out.println("+");
    }

    // Méthode pour afficher une case du cadrillage en rouge
    public void destruction(int ligne, int colonne){
        this.tableau[ligne][colonne] = "\033[41m  \033[0m";
    }

    // Méthode pour placer un personnage dans le tableau
    public void placerPersonnage(int ligne, int colonne, String personnage) {
        this.tableau[ligne][colonne] = "\033[47m" + personnage + "\033[0m";
    }
}

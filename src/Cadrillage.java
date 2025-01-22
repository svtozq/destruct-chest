import java.util.Scanner;
import java.util.InputMismatchException;
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
    public void placerPersonnage(int ligne, int colonne, Personage joueur) {
        this.tableau[ligne][colonne] = "\033[47m" + joueur.recupPersonnage() + "\033[0m";
        joueur.defLigne((byte)ligne);
        joueur.defColonne((byte)colonne);
    }

    public void deplacerPersonnage(byte ligne, byte colonne, Personage joueur) {
        byte lignedepar = joueur.recupLigne();
        byte colonnedepar = joueur.recupColonne();
        this.tableau[lignedepar][colonnedepar] = "\033[47m  \033[0m";
        this.tableau[ligne][colonne] = "\033[47m" + joueur.recupPersonnage() + "\033[0m";
        joueur.defLigne((byte) ligne);
        joueur.defColonne((byte) colonne);
    }

    public void deplacerPersonnage(Personage joueur) {
        if ((!this.tableau[joueur.recupLigne()-1][joueur.recupColonne()].equals("\033[47m  \033[0m")) && (!this.tableau[joueur.recupLigne()+1][joueur.recupColonne()].equals("\033[47m  \033[0m")) && (!this.tableau[joueur.recupLigne()][joueur.recupColonne()-1].equals("\033[47m  \033[0m")) && (!this.tableau[joueur.recupLigne()][joueur.recupColonne()+1].equals("\033[47m  \033[0m"))){
            joueur.mort();
        } else {
            Scanner scanner = new Scanner(System.in);
            int ligne;
            int colonne;
            System.out.println("au toure de " + joueur.recupPseudo() + "de se deplacer");
            while (true) {
                while (true) {
                    System.out.println("choisiser la igne entre 1 est 10");
                    try {
                        ligne = scanner.nextInt();
                        if (ligne > 0 && ligne <= 10) {
                            break;
                        } else {
                            System.out.println("Choisissez un chifre entre 1 et 10.");
                        }
                    } catch (InputMismatchException e) {
                        // Gérer l'erreur si l'utilisateur entre une lettre ou un caractère spécial
                        System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                        scanner.nextLine(); // Consommer la ligne erronée pour éviter une boucle infinie
                    }
                }
                while (true) {
                    System.out.println("choisiser la colonne entre 1 est 11");
                    try {
                        colonne = scanner.nextInt();
                        if (colonne > 0 && colonne <= 11) {
                            break;
                        } else {
                            System.out.println("Choisissez un chifre entre 1 et 10.");
                        }
                    } catch (InputMismatchException e) {
                        // Gérer l'erreur si l'utilisateur entre une lettre ou un caractère spécial
                        System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                        scanner.nextLine(); // Consommer la ligne erronée pour éviter une boucle infinie
                    }
                }
                if (((joueur.recupLigne() - 1) == ligne-1) ^ ((joueur.recupLigne() + 1) == ligne-1) ^ ((joueur.recupColonne() - 1) == colonne-1) ^ ((joueur.recupColonne() + 1) == colonne-1)) {
                    if (this.tableau[(ligne-1)][(colonne-1)].equals("\033[47m  \033[0m")) {
                        break;
                    } else {
                        System.out.println("Choisissez une casse non occuper.");
                    }
                } else {
                    System.out.println("Choisissez une casse acoter de vous.");
                }
            }
            this.deplacerPersonnage((byte) (ligne-1), (byte) (colonne-1), joueur);
        }
    }

    public void detruireterin() {
        Scanner scanner = new Scanner(System.in);
        int ligne;
        int colonne;
        System.out.println("detruiser une casse");
        while (true) {
            while (true) {
                System.out.println("choisiser la ligne entre 1 est 10");
                try {
                    ligne = scanner.nextInt();
                    if (ligne > 0 && ligne <= 10) {
                        break;
                    } else {
                        System.out.println("Choisissez un chifre entre 1 et 10.");
                    }
                } catch (InputMismatchException e) {
                    // Gérer l'erreur si l'utilisateur entre une lettre ou un caractère spécial
                    System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                    scanner.nextLine(); // Consommer la ligne erronée pour éviter une boucle infinie
                }
            }
            while (true) {
                System.out.println("choisiser la colonne entre 1 est 11");
                try {
                    colonne = scanner.nextInt();
                    if (colonne > 0 && colonne <= 11) {
                        break;
                    } else {
                        System.out.println("Choisissez un chifre entre 1 et 10.");
                    }
                } catch (InputMismatchException e) {
                    // Gérer l'erreur si l'utilisateur entre une lettre ou un caractère spécial
                    System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                    scanner.nextLine(); // Consommer la ligne erronée pour éviter une boucle infinie
                }
            }
            System.out.println("debug ligne= "+ ligne + " colonne= " + colonne);
            if (this.tableau[(ligne-1)][(colonne-1)].equals("\033[47m  \033[0m")) {
                break;
            } else {
                System.out.println("Choisissez une casse non occuper.");
            }
        }
        this.destruction((byte) ligne-1, (byte) colonne-1);
    }

}
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            // Afficher les options du menu
            System.out.println("=== Menu Principal ===");
            System.out.println("1. JOUER");
            System.out.println("2. CHARGER LES SAUVEGARDES");
            System.out.println("3. REGLES");
            System.out.println("4. QUITTER");
            System.out.print("Veuillez choisir une option : ");

            // Lire le choix de l'utilisateur
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next(); // Consomme l'entrée invalide
            }
            choix = scanner.nextInt();

            // Exécuter l'action correspondante
            switch (choix) {
                case 1:
                    System.out.println("Vous avez choisi l'option 1.");
                    break;
                case 2:
                    System.out.println("Vous avez choisi l'option 2.");
                    break;
                case 3:
                    System.out.println("Vous avez choisi l'option 3.");
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0); // Le menu continue jusqu'à ce que l'utilisateur ecrit 0

        scanner.close();
    }
}

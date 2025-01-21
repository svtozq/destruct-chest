import java.util.Scanner;

public class Personage {

    private String pseudo;
    private String personnage;

    // Constructeur
    public Personage(String pseudo, String personnage) {
        this.pseudo = pseudo;
        this.personnage = personnage;
    }

    // Getter et setter pour pseudo
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    // Getter et setter pour personnage
    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

    // Méthode pour choisir un pseudo et un personnage
    public static Personage choisirPersonage(int numeroJoueur) {
        Scanner scanner = new Scanner(System.in);
        String pseudo;
        int choipersonage;
        while (true) {
            System.out.print("Joueur " + numeroJoueur + ", entrez un pseudonyme entre 2 et 15 caractères : ");
            pseudo = scanner.nextLine();

            // Vérifier la longueur du pseudo
            if (pseudo.length() >= 2 && pseudo.length() <= 15) {
                break;  // Pseudo valide
            } else {
                System.out.println("Le pseudonyme doit être entre 2 et 15 caractères. Essayez à nouveau.");
            }
        }

        String[] personnagesPossibles = {"😊", "😀", "😁", "😃", "☢️"};
        while (true) {
            System.out.print("Joueur " + numeroJoueur + ", choisissez un personnage (1:😊 2:😀 3:😁 4:😃 5:☢️): ");
            choipersonage = scanner.nextInt();

            if (choipersonage > 0 && choipersonage <= 5) {
                return new Personage(pseudo, personnagesPossibles[choipersonage - 1]);
            } else {
                System.out.println("Choisissez un personnage entre 1 et 5.");
            }
        }
    }
}

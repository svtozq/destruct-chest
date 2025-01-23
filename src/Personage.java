import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
public class Personage {

    private String pseudo;
    private String personnage;
    private byte ligne;
    private byte colonne;
    private boolean envie;


    // Constructeur
    public Personage(String pseudo, String personnage) {
        this.pseudo = pseudo;
        this.personnage = personnage;
        this.envie = true;
    }


    // recupere et definir pour pseudo

    /**
     * @return
     */
    public String recupPseudo() {
        return pseudo;
    }

    public void defPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    // recupere et definir pour personnage
    public String recupPersonnage() {
        return personnage;
    }

    public void defPersonnage(String personnage) {
        this.personnage = personnage;
    }

    public byte recupLigne() {
        return ligne;
    }

    public void defLigne(byte ligne) {
        this.ligne = ligne;
    }

    // recupere et definir pour colonne
    public byte recupColonne() {
        return colonne;
    }

    public void defColonne(byte colonne) {
        this.colonne = colonne;
    }

    //recupere et definir pour envie
    public boolean recupEnvie() {
        return envie;
    }

    public void mort() {
        this.envie = false;
    }

    // Méthode pour choisir un pseudo et un personnage

    /**
     * @param numeroJoueur
     * @param pseudosUtilises
     * @param personnagesUtilises
     * @return
     */
    public static Personage choisirPersonage(int numeroJoueur, ArrayList<String> pseudosUtilises, ArrayList<String> personnagesUtilises) {
        Scanner scanner = new Scanner(System.in);
        String pseudo;
        int choipersonage;

        // Demander et vérifier le pseudo
        while (true) {
            System.out.print("Joueur " + numeroJoueur + ", entrez un pseudonyme entre 2 et 15 caractères : ");
            pseudo = scanner.nextLine();

            // Vérifier la longueur du pseudo et s'il est déjà pris
            if (pseudo.length() >= 2 && pseudo.length() <= 15) {
                if (!pseudosUtilises.contains(pseudo)) {
                    break;  // Pseudo valide et unique
                } else {
                    System.out.println("Ce pseudonyme est déjà pris. Essayez un autre.");
                }
            } else {
                System.out.println("Le pseudonyme doit être entre 2 et 15 caractères. Essayez à nouveau.");
            }
        }

        String[] personnagesPossibles = {"😊", "😀", "😁", "😃", "☢️"};

        // Demander et vérifier le personnage
        while (true) {
            System.out.print("Joueur " + numeroJoueur + ", choisissez un personnage (1:😊 2:😀 3:😁 4:😃 5:☢️): ");
            try {
                choipersonage = scanner.nextInt();

                if (choipersonage > 0 && choipersonage <= 5) {
                    String personnageChoisi = personnagesPossibles[choipersonage - 1];

                    // Vérifier si le personnage est déjà choisi
                    if (!personnagesUtilises.contains(personnageChoisi)) {
                        return new Personage(pseudo, personnageChoisi); // Retourner le personnage valide et unique
                    } else {
                        System.out.println("Ce personnage est déjà pris. Essayez un autre.");
                    }
                } else {
                    System.out.println("Choisissez un personnage entre 1 et 5.");
                }
            } catch (InputMismatchException e) {
                // Gérer l'erreur si l'utilisateur entre une lettre ou un caractère spécial
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier entre 1 et 5.");
                scanner.nextLine(); // Consommer la ligne erronée pour éviter une boucle infinie

            }
        }
    }

    public class GestionGagnant {
        public static Personage trouverGagnant(ArrayList<Personage> joueurs) {
            for (Personage joueur : joueurs) {
                if (joueur.recupEnvie()) {
                    return joueur; // Retourne le joueur encore en vie
                }
            }
            return null; // Aucun gagnant trouvé
        }

        public static void ajoutGagnant (String cheminFichier, Personage gagnant) {

            if (gagnant != null) {
                String gagnantPseudo = gagnant.recupPseudo();
                boolean ligneModifiee = false;
                List<String> joueurs = new ArrayList<>();

                try {

                    try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
                        String lignes;
                        // lecture du fichier ligne par ligne
                        while ((lignes = reader.readLine()) != null) {
                            // remplace la ligne contenant le pseudo du gagnant
                            if (lignes.contains(gagnantPseudo)) {
                                String[] parts = lignes.split(":");
                                int score = Integer.parseInt(parts[1].trim());
                                score++; // incrémentation du score
                                joueurs.add(gagnantPseudo + " : " + score);
                                ligneModifiee = true;
                            } else {
                                joueurs.add(lignes);
                            }
                        }
                        // en cas d'erreur
                    } } catch (IOException e) {
                    System.err.println("Erreur lors de la lecture du fichier");
                }

                // Si la ligne n'a pas été trouvée, ajouter le gagnant avec un score initial de 1
                if (!ligneModifiee) {
                    joueurs.add(gagnantPseudo + " : 1");
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
                    for (String lignes : joueurs) {
                        writer.write(lignes);
                        writer.newLine();
                    }
                    System.out.println("Ajout du Gagnant dans le tableau avec succès !");
                } catch (IOException e) {
                    System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
                }
            } else {
                System.out.println("Aucun gagnant à écrire dans le fichier.");
            }
        }
    }
}




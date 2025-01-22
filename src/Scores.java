import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scores {
    public static void main (String[] args) {
        // chemin du fichier
        String cheminFichier = "scores.txt";

        String lignes;
        String ligneAModifier = "Joueur 2";
        String nouvelleLigne = "Joueur 2: 7";

        try {
            List<String> list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {

                // lecture du fichier ligne par ligne
                while ((lignes = reader.readLine()) != null) {
                    // remplace la ligne contenant le pseudo par le nouveau nombre de victoires
                    if (lignes.contains(ligneAModifier)) {
                        list.add(nouvelleLigne);
                    } else {
                        list.add(lignes);
                    }
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
                    for (String ligne : list) {
                        writer.write(ligne);
                        writer.newLine();
                    }
                }
                System.out.println("Modification effectué avec succès !");
                // en cas d'erreur
            } } catch (IOException e) {
            System.err.println("Erreur lors de la modification : " + e.getMessage());
        }

        verifierFichier(cheminFichier);

        afficherScores(cheminFichier);
    }

    public static void verifierFichier (String cheminFichier) {
        // fichier texte
        File file = new File(cheminFichier);

        // créer le fichier s'il n'existe pas
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Création du fichier : " + cheminFichier);

                    try (FileWriter writer = new FileWriter(file)) {
                        writer.write("Joueur 1 : 0");
                    }

                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
            }
        } else {
            System.out.println("Le Fichier existe déjà : " + cheminFichier);
            /*
                    try (FileWriter writer = new FileWriter(file)) {
                        writer.write("Joueur 1 : 0\nJoueur 1: 0\n");
                    }
                    */
        }
    }

    public static void afficherScores (String cheminFichier) {
        // utilisation d'une classe pour le contenu d'un fichier
            try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
                String ligne;
                System.out.println("Tableau des Scores");

                // lecture du fichier ligne par ligne
                while ((ligne = reader.readLine()) != null) {
                    // sépare les lignes en fonction du ':'
                    String[] parts = ligne.split(":");
                    // récupère et affiche les données des parties de la ligne
                    if (parts.length == 2) {
                        String pseudo = parts[0].trim();
                        String victoires = parts[1].trim();
                        System.out.println(pseudo + " a gagné " + victoires + " fois.");
                    } else {
                        System.out.println("Format invalide de la ligne : " + ligne);
                    }
                }
                // en cas d'erreur
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
    }


        }



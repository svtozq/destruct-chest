import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Scores {
    public static void main (String[] args) {
        // chemin du fichier
        String cheminFichier = "scores.txt";

        verifierFichier(cheminFichier);

        afficherScores(cheminFichier);

        ArrayList<Personage> joueurs = new ArrayList<>();

        Personage gagnant = Personage.GestionGagnant.trouverGagnant(joueurs);

        Personage.GestionGagnant.ajoutGagnant(cheminFichier, gagnant);

        lireScores(cheminFichier);

        afficherScoresTrie(cheminFichier, true);

        afficherTop10Scores(cheminFichier);
    }

    public static void verifierFichier (String cheminFichier) {
        // fichier texte
        File file = new File(cheminFichier);

        // créer le fichier s'il n'existe pas
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Création du fichier : " + cheminFichier);
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
                System.out.println("=== Tableau des Scores ===");

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


    // Affiche les scores triés dans l'ordre croissant ou décroissant
    public static void afficherScoresTrie(String cheminFichier, boolean croissant) {
        // Lire les scores depuis le fichier
        List<Map.Entry<String, Integer>> scores = lireScores(cheminFichier);

        // Trier les scores en fonction de l'ordre demandé
        scores.sort((a, b) -> croissant ? a.getValue() - b.getValue() : b.getValue() - a.getValue());

        // Affichage des scores triés
        System.out.println("=== Scores triés " + (croissant ? "croissant" : "décroissant") + " ===");
        for (Map.Entry<String, Integer> score : scores) {
            System.out.println(score.getKey() + " : " + score.getValue());
        }
    }

    // Affiche les 10 meilleurs scores dans l'ordre décroissant
    public static void afficherTop10Scores(String cheminFichier) {
        // Lire les scores depuis le fichier
        List<Map.Entry<String, Integer>> scores = lireScores(cheminFichier);

        // Trier dans l'ordre décroissant
        scores.sort((a, b) -> b.getValue() - a.getValue());

        // Afficher les 10 meilleurs scores
        System.out.println("=== Top 10 des meilleurs scores ===");
        for (int i = 0; i < Math.min(10, scores.size()); i++) {
            Map.Entry<String, Integer> score = scores.get(i);
            System.out.println((i + 1) + ". " + score.getKey() + " : " + score.getValue());
        }
    }


    // Lit les scores depuis le fichier et les retourne sous forme de liste de paires (pseudo, score)
    private static List<Map.Entry<String, Integer>> lireScores(String cheminFichier) {
        List<Map.Entry<String, Integer>> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(":");
                if (parts.length == 2) {
                    try {
                        // Extraire le pseudo et le score
                        String pseudo = parts[0].trim();
                        int score = Integer.parseInt(parts[1].trim());
                        scores.add(new AbstractMap.SimpleEntry<>(pseudo, score));
                    } catch (NumberFormatException e) {
                        System.err.println("Score invalide pour la ligne : " + ligne);
                    }
                } else {
                    System.err.println("Format invalide de la ligne : " + ligne);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return scores;
    }
}



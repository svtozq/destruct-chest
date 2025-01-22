// Classe principale qui gère la logique pour afficher les scores triés des joueurs
import java.util.*;

public class GameRules {

    // Méthode principale qui démarre le programme
    public static void main(String[] args) {
        // Liste des scores des joueurs
        List<Player> players = new ArrayList<>();

        // Ajout des joueurs et de leurs scores
        players.add(new Player("Alice", 150));
        players.add(new Player("Bob", 120));
        players.add(new Player("Charlie", 200));
        players.add(new Player("Diana", 100));

        // Vérifie si la liste des joueurs est vide
        if (players.isEmpty()) {
            System.out.println("Aucun joueur à afficher !");
            return;
        }

        // Trie les joueurs en fonction de leur score, du plus petit au plus grand
        players.sort(Comparator.comparingInt(Player::getScore));

        // Affiche les scores des joueurs
        showPlayerScores(players);
    }

    // Méthode qui affiche les scores des joueurs dans l'ordre croissant
    public static void showPlayerScores(List<Player> players) {
        System.out.println("\nVoici les scores triés des joueurs :\n");
        for (Player player : players) {
            System.out.println(player.getName() + " : " + player.getScore() + " points");
        }
    }
}

// Classe Player pour représenter un joueur et son score
class Player {
    private String name;
    private int score;

    // Constructeur pour initialiser le joueur avec validation du score
    public Player(String name, int score) {
        if (score < 0) {
            throw new IllegalArgumentException("Le score ne peut pas être négatif.");
        }
        this.name = name;
        this.score = score;
    }

    // Getter pour le nom du joueur
    public String getName() {
        return name;
    }

    // Getter pour le score du joueur
    public int getScore() {
        return score;
    }
}

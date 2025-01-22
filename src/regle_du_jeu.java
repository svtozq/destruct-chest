
// Classe principale qui lance le programme
public class regle_du_jeu {

    // Méthode principale qui démarre le programme
    public static void main(String[] args) {
        // Appel d'une méthode pour afficher les règles du jeu
        showGameRules();
    }

    // Méthode qui affiche les règles du jeu
    public static void showGameRules() {
        // Introduction pour l'utilisateur
        System.out.println("Bienvenue dans le jeu ! Voici les règles :\n");

        // Les règles du jeu sous forme de texte
        System.out.println("Pendant son tour un joueur peut déplacer son pion d’une case (verticalement ou");
        System.out.println("horizontalement), puis il détruit une case du plateau.");
        System.out.println("Le dernier joueur pouvant encore se déplacer gagne.\n");

        System.out.println("Contraintes :\n");
        System.out.println("- Un joueur ne peut pas détruire une case occupée.");
        System.out.println("- Un joueur ne peut pas occuper une case détruite ou une case déjà occupée.");
        System.out.println("- Un joueur bloqué pendant un tour est déclaré perdant.\n");

        // Message final
        System.out.println("Amusez-vous bien et que le meilleur gagne !");

    }
}


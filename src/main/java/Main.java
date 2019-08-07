package main.java;

public class Main {

    public static void main(String[] args) {
        IHM ihm = new IHM();

        System.out.println("Création du personnage du Joueur 1");
        Players player1 = new Players();

        player1.setPlayerNumber(1);

        ihm.choixRace(player1);
        ihm.choixCaracteristiques(player1);
        ihm.recap(player1);


        System.out.println("Création du personnage du Joueur 2");
        Players player2 = new Players();

        player2.setPlayerNumber(2);

        ihm.choixRace(player2);
        ihm.choixCaracteristiques(player2);
        ihm.recap(player2);

    }
}

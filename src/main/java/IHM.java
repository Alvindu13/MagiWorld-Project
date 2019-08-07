package main.java;

import java.util.Scanner;

public class IHM {

    public void choixRace(Players player){
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage" );
        Scanner sc = new Scanner(System.in);
        int raceInt = sc.nextInt();
        player.setChooseRace(raceInt);
    }

    public void choixCaracteristiques(Players player){
        Scanner sc = new Scanner(System.in);
        int niveau;
        int force;
        int agilite;
        int intelligence;

        System.out.println("Niveau du personnnage ?" );
        niveau = sc.nextInt();
        player.setNiveau(niveau);
        player.setVitalite(niveau*5);
        System.out.println("Force du personnnage ?" );
        force = sc.nextInt();
        player.setForce(force);
        System.out.println("Agilité du personnnage ?" );
        agilite = sc.nextInt();
        player.setAgilite(agilite);
        System.out.println("Intelligence du personnnage ?" );
        intelligence = sc.nextInt();
        player.setIntelligence(intelligence);
    }

    public void recap(Players player){
       if(player.getChooseRace() == 1){
           System.out.println("Wouarg, je  suis le guerrier Joueur "
                   + player.getPlayerNumber() + "Je possède "
                   + player.getVitalite() + " de vitalité,"
                   + player.getForce() + " de force, "
                   + player.getAgilite() + " d'agilité, "
                   + player.getIntelligence() + " d'intelligence !");
       }
    }
}

package main.java;
import java.util.Scanner;

public class IHM {

    public void choixRace(Players player){
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)" );
        Scanner sc = new Scanner(System.in);
        int raceInt = sc.nextInt();
        player.setChooseRace(raceInt);
    }

    public int setCaract(int caract, Players player, String paramCaract) {
        Scanner sc = new Scanner(System.in);
        while (caract > player.getCapacitiesPoint()){
            System.out.println("Vous n'avez pas assez de points à attribuer, vous avez : " + player.getCapacitiesPoint() + " points restants");
            System.out.println(paramCaract + " du personnnage ?" );
            caract = sc.nextInt();
        }
        return caract;
    }

    public void messagePoints(Players player){
        System.out.println("Il vous reste " + player.getCapacitiesPoint() + " points à attribuer à vos caractéristiques : ");
    }

    public void choixCaracteristiques(Players player){
        Scanner sc = new Scanner(System.in);

        System.out.println("Niveau du personnnage ?" );
        int niveau = sc.nextInt();
        player.setNiveau(niveau);
        player.setVitalite(niveau*5);
        player.setCapacitiesPoint(niveau);

        System.out.println("Vous avez " + player.getCapacitiesPoint() + " points à attribuer à vos caractéristiques : ");


        System.out.println("Force du personnnage ?" );
        int force = sc.nextInt();
        force = setCaract(force, player, ParamsCaracts.FORCE.getCaracteristique());
        player.setForce(force);
        player.setCapacitiesPoint(player.getCapacitiesPoint() - player.getForce());
        messagePoints(player);

        if(player.getCapacitiesPoint() > 0) {
            System.out.println("Agilité du personnnage ?");
            int agilite = sc.nextInt();
            agilite = setCaract(agilite, player, ParamsCaracts.AGILITE.getCaracteristique());
            player.setAgilite(agilite);
            player.setCapacitiesPoint(player.getCapacitiesPoint() - player.getAgilite());
            messagePoints(player);
        }
        else {
            player.setAgilite(0);
            System.out.println("Vous n'avez plus de points, votre agilité a été fixée à 0");
        }

        if(player.getCapacitiesPoint() > 0) {
            System.out.println("Intelligence du personnnage ?");
            int intelligence = sc.nextInt();
            player.setIntelligence(intelligence);
        }
        else {
            player.setIntelligence(0);
            System.out.println("Vous n'avez plus de points, votre intelligence a été fixée à 0");
        }
    }

    public void recap(Players player){

        if(player.getChooseRace() == 1){

           content(ParamsRace.GUERRIER.getRace(), player);

        } else if(player.getChooseRace() == 2) {

            content(ParamsRace.RODEUR.getRace(), player);

        } else if(player.getChooseRace() == 3) {

            content(ParamsRace.MAGE.getRace(), player);

        }
    }


    public void content(String params, Players player){
        if(params.equals("Guerrier")){
            System.out.print("Wouarg, je  suis le " + params + " Joueur ");
        }
        else if(params.equals("Rôdeur")){
            System.out.print("ZzzzZzz, je  suis le " + params + " Joueur ");
        }
        else if(params.equals("Mage")){
            System.out.print("Abracadabra, je  suis le " + params + " Joueur ");
        }

        System.out.println(
                + player.getPlayerNumber() + ". Je possède "
                + player.getVitalite() + " de vitalité, "
                + player.getForce() + " de force, "
                + player.getAgilite() + " d'agilité, et "
                + player.getIntelligence() + " d'intelligence !");
    }


    public void attackMode(Players player1, Players player2){
        Scanner sc = new Scanner(System.in);

        int number = 0;

        do{
            if(number % 2 == 0){
                System.out.println("Joueur 1 (" + player1.getVitalite() + " de vitalité)");
                System.out.println("Veuillez choisir votre action ( 1 : Attaque Basique, 2 : Attaque Spéciale )");
                int attackMode = sc.nextInt();
                Attacks attacks = new Attacks(player1.getChooseRace());
                attackPhase(attackMode, player1, attacks);
                attacks.lifeCalcul(player2);

            } else {
                System.out.println("Joueur 2 (" + player2.getVitalite() + " de vitalité)");
                System.out.println("Veuillez choisir votre action ( 1 : Attaque Basique, 2 : Attaque Spéciale)");
                int attackMode = sc.nextInt();
                    Attacks attacks = new Attacks(player2.getChooseRace());
                    attackPhase(attackMode, player2, attacks);
                    attacks.lifeCalcul(player1);
                }
            number++;
        } while(player1.getVitalite() > 0 && player2.getVitalite() > 0);
        if(player1.getVitalite() <= 0){
            System.out.println("Le joueur 1 est mort. Le joueur 2 gagne la partie");
        } else if (player2.getVitalite() <= 0){
            System.out.println("Le joueur 2 est mort. Le joueur 1 gagne la partie");
        }

    }


    public void attackPhase(int attackMode, Players player, Attacks attacks) {

        if (attackMode == 1) {
            attacks.basicAttack(player);
        } else if (attackMode == 2) {
            attacks.specialAttack(player);
        }
    }

}

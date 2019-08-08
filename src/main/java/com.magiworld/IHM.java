package com.magiworld;

import java.util.Scanner;

public class IHM {

    Scanner sc = new Scanner(System.in);


    public void choixRace(Players player){
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)" );
        int raceInt = sc.nextInt();
        player.setChooseRace(raceInt);
    }

    public int controlCaractsPoints(int caract, Players player, String paramCaract) {
        while (caract > player.getCapacitiesPoint()){
            System.out.println("Vous n'avez pas assez de points à attribuer, vous avez : " + player.getCapacitiesPoint() + " points restants");
            System.out.println(paramCaract + " du personnnage ?" );
            caract = sc.nextInt();
        }
        return caract;
    }

    public void totalPointsRestants(Players player){
        if(player.getCapacitiesPoint() > 0) {
            System.out.println("Il vous reste " + player.getCapacitiesPoint() + " points à attribuer à vos caractéristiques : \n");
        }
        else if(player.getCapacitiesPoint() == 0){
            System.out.println("Vous avez utilisé tous vos points. Vos caractéristiques restantes ont été fixées à 0.");
        }
    }

    public void choixCaracteristiques(Players player){

        System.out.println("Niveau du personnnage ?" );
        int niveau = sc.nextInt();
        player.setNiveau(niveau);
        player.setVitalite(niveau*5);
        setCapacitiesPoints(player, "empty");

        System.out.println("Force du personnnage ?" );
        int force = sc.nextInt();
        force = controlCaractsPoints(force, player, ParamsCaracts.FORCE.getCaracteristique());
        player.setForce(force);
        setCapacitiesPoints(player, ParamsCaracts.FORCE.getCaracteristique());
        totalPointsRestants(player);

        if(player.getCapacitiesPoint() > 0) {
            System.out.println("Agilité du personnnage ?");
            int agilite = sc.nextInt();
            agilite = controlCaractsPoints(agilite, player, ParamsCaracts.AGILITE.getCaracteristique());
            player.setAgilite(agilite);
            setCapacitiesPoints(player, ParamsCaracts.AGILITE.getCaracteristique());
            totalPointsRestants(player);
        }

        if(player.getCapacitiesPoint() > 0) {
            System.out.println("Intelligence du personnnage ?");
            int intelligence = sc.nextInt();
            intelligence = controlCaractsPoints(intelligence, player, ParamsCaracts.INTELLIGENCE.getCaracteristique());
            player.setIntelligence(intelligence);
        }

    }


    public void setCapacitiesPoints(Players player, String nameCaracts){

        if(nameCaracts.equals("empty")){
            player.setCapacitiesPoint(player.getNiveau());
            System.out.println("Vous avez " + player.getCapacitiesPoint() + " points à attribuer à vos caractéristiques : \n");

        } else if (nameCaracts.equals(ParamsCaracts.FORCE.getCaracteristique())){
            player.setCapacitiesPoint(player.getCapacitiesPoint() - player.getForce());
        } else if (nameCaracts.equals(ParamsCaracts.AGILITE.getCaracteristique())){
        player.setCapacitiesPoint(player.getCapacitiesPoint() - player.getAgilite());
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
            System.out.print("\n" + "Wouarg, je  suis le " + params + " Joueur ");
        }
        else if(params.equals("Rôdeur")){
            System.out.print("\n" + "ZzzzZzz, je  suis le " + params + " Joueur ");
        }
        else if(params.equals("Mage")){
            System.out.print("\n" + "Abracadabra, je  suis le " + params + " Joueur ");
        }

        System.out.println(
                + player.getPlayerNumber() + ". \n" + "Je possède : \n"
                + player.getVitalite() + " de vitalité, \n"
                + player.getForce() + " de force, \n"
                + player.getAgilite() + " d'agilité, \n" + "et "
                + player.getIntelligence() + " d'intelligence ! \n");
    }


    public void attackMode(Players player1, Players player2){

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

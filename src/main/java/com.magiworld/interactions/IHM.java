package com.magiworld.interactions;

import com.magiworld.Params.ParamsCaracts;
import com.magiworld.Params.ParamsRace;

import java.util.Scanner;

public class IHM {

    Scanner sc = new Scanner(System.in);

    /**
     * Permet de contrôler si le joueur a suffisamment de points de caractéristiques à attribuer à telle caract
     * @param caract caracteristiques injectées pour le contrôle en int pour les tests (conditions)
     * @param player
     * @param paramCaract caracteristiques injectées pour le contrôle en String pour affichage dynamique
     * @return
     */
    private int controlCaractsPoints(int caract, Players player, String paramCaract) {
        while (caract > player.getCapacitiesPoint()){
            System.out.println("Vous n'avez pas assez de points à attribuer, vous avez : " + player.getCapacitiesPoint() + " points restants");
            System.out.println(paramCaract + " du personnnage ?" );
            caract = sc.nextInt();
        }
        return caract;
    }

    /**
     * Affiche les points de caract restants
     * @param player
     */
    private void totalPointsRestants(Players player){
        if(player.getCapacitiesPoint() > 0) {
            System.out.println("Il vous reste " + player.getCapacitiesPoint() + " points à attribuer à vos caractéristiques : \n");
        }
        else if(player.getCapacitiesPoint() == 0){
            System.out.println("Vous avez utilisé tous vos points. Vos caractéristiques restantes ont été fixées à 0.");
        }
    }

    /**
     * Cette méthode permet de mettre à jour les points de caractéristiques après chaque attribution
     * @param player
     * @param nameCaracts nom de la caractéristique
     */
    private void setCapacitiesPoints(Players player, String nameCaracts){

        if(nameCaracts.equals("empty")){
            player.setCapacitiesPoint(player.getNiveau());
            System.out.println("Vous avez " + player.getCapacitiesPoint() + " points à attribuer à vos caractéristiques : \n");

        } else if (nameCaracts.equals(ParamsCaracts.FORCE.getCaracteristique())){
            player.setCapacitiesPoint(player.getCapacitiesPoint() - player.getForce());
        } else if (nameCaracts.equals(ParamsCaracts.AGILITE.getCaracteristique())){
            player.setCapacitiesPoint(player.getCapacitiesPoint() - player.getAgilite());
        }

    }

    /**
     * Contenu affiché dans la méthode recap
     * @param params paramètre de race sous forme d'un String
     * @param player
     */
    private void content(String params, Players player){
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

    /**
     * Permet de déployer les phases d'attaques du joueur en fonction du choix de son attaque
     * @param attackMode attaque basique ou spéciale
     * @param player
     * @param attacks Objets attacks qui contient les méthodes implémentées d'attaques des différentes races
     */
    private void attackPhase(int attackMode, Players player, Attacks attacks) {

        if (attackMode == 1) {
            attacks.basicAttack(player);
        } else if (attackMode == 2) {
            attacks.specialAttack(player);
        }
    }

    /**
     * Permet de choisir la race/classe du joueur
     * @param player
     */
    public void choixRace(Players player){
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)" );
        int raceInt = sc.nextInt();
        player.setChooseRace(raceInt);
    }

    /**
     * Permet au joueur de choisir les caract de son personnage
     * @param player
     */
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

    /**
     * Recapitulatif des caracts du joueur
     * @param player
     */
    public void recap(Players player){

        if(player.getChooseRace() == 1){

            content(ParamsRace.GUERRIER.getRace(), player);

        } else if(player.getChooseRace() == 2) {

            content(ParamsRace.RODEUR.getRace(), player);

        } else if(player.getChooseRace() == 3) {

            content(ParamsRace.MAGE.getRace(), player);

        }
    }

    /**
     * Déclenche la phase d'attaque et permet d'alterner tour à tour entre les 2 joueurs en paramètres
     * @param player1
     * @param player2
     */
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

}

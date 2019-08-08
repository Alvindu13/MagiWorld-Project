package com.magiworld.interactions;

public class Attacks {

    private int race;
    private int damage;

    public Attacks(int race) {
        this.race = race;
    }

    /**
     * Attaque basique
     * @param player
     */
    public void basicAttack(Players player){
        if(race == 1){
            System.out.println("Joueur " + player.getPlayerNumber() + " utilise Coup d'Épée et inflige " + player.getForce() + " dommages");
            damage = player.getForce();
        }
        else if(race == 2){
            System.out.println("Joueur " + player.getPlayerNumber() + " utilise Tir à l'Arc et inflige " + player.getAgilite() + " dommages");
            damage = player.getAgilite();
        }
        else if(race == 3){
            System.out.println("Joueur " + player.getPlayerNumber() + " utilise Boule de Feu et inflige " + player.getIntelligence() + " dommages");
            damage = player.getIntelligence();
        }

    }

    /**
     * Attaque spéciale
     * @param player
     */
    public void specialAttack(Players player){
        if(race == 1){
            System.out.println("Joueur " + player.getPlayerNumber() + " utilise Coup de Rage et inflige " + player.getForce()*2 + " dommages mais perd " + player.getForce()/2 + " de dommages propres.");
            damage = player.getForce()*2;
            int damageReturn = player.getForce()/2;
            System.out.println("Joueur " + player.getPlayerNumber() + " perd " + damageReturn + " points de vie.");
            player.setVitalite(player.getVitalite() - damageReturn);
        }
        else if(race == 2){
            System.out.println("Joueur " + player.getPlayerNumber() + " utilise Concentration et gagne " + player.getNiveau()/2 + " en agilité. ");
            player.setAgilite(player.getAgilite() + player.getNiveau()/2);
            damage = 0;
        }
        else if(race == 3){
            System.out.println("Joueur " + player.getPlayerNumber() + " utilise Soin et récupère des points de vitalité. ");
            int heal = player.getIntelligence()*2;
            if(player.getVitalite() + heal > player.getNiveau()*5){
                player.setVitalite(player.getNiveau()*5);
            } else {
                player.setVitalite(player.getVitalite() + heal);
            }
            damage = 0;
        }
    }

    /**
     * Calcul des dommages infligés
     * @param player
     */
    public void lifeCalcul(Players player){
        if(damage == 0){
            System.out.println("Joueur " + player.getPlayerNumber() + " n'a subit aucun dommage.");
        }else{
            System.out.println("Joueur " + player.getPlayerNumber() + " perd " + damage + " points de vie");
            player.setVitalite(player.getVitalite() - damage);
        }
    }
}

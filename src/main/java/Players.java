package main.java;

public class Players {


    private int niveau;
    private int force;
    private int agilite;
    private int intelligence;
    private int vitalite;
    private int chooseRace;
    private int playerNumber;

    public Players() {
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getChooseRace() {
        return chooseRace;
    }

    public void setChooseRace(int chooseRace) {
        this.chooseRace = chooseRace;
    }

    public int getVitalite() {
        return vitalite;
    }

    public void setVitalite(int vitalite) {
        this.vitalite = vitalite;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    @Override
    public String toString() {
        return "Players{" +
                "niveau=" + niveau +
                ", force=" + force +
                ", agilite=" + agilite +
                ", intelligence=" + intelligence +
                ", vitalite=" + vitalite +
                ", chooseRace=" + chooseRace +
                '}';
    }
}

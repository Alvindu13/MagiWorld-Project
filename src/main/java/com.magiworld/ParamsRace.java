package com.magiworld;

public enum ParamsRace {
    RODEUR("Rôdeur"),
    GUERRIER("Guerrier"),
    MAGE("Mage");

    private String race = "";

    ParamsRace(String race) {
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "ParamsRace{" +
                "race='" + race + '\'' +
                '}';
    }
}

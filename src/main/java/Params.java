package main.java;

public enum Params {
    RODEUR("Rôdeur"),
    GUERRIER("Guerrier"),
    MAGE("Mage");

    private String race = "";

    Params(String race) {
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
        return "Params{" +
                "race='" + race + '\'' +
                '}';
    }
}

package main.java;

public enum ParamsCaracts {

    NIVEAU("Niveau"),
    FORCE("Force"),
    AGILITE("Agilité"),
    INTELLIGENCE("Intelligence"),
    VITALITE("Vitalité");



    private String caracteristique = "";

    ParamsCaracts(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    @Override
    public String toString() {
        return "ParamsCaracts{" +
                "caracteristique='" + caracteristique + '\'' +
                '}';
    }
}

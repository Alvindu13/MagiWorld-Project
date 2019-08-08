package com.magiworld.Params;

public enum ParamsCaracts {

    FORCE("Force"),
    AGILITE("Agilité"),
    INTELLIGENCE("Intelligence");

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

package com.supinfo.supsale.entity;


public enum Categorie {
    Vehicules("Véhicules"),
    Employement("Employement"),
    Real_Estate("Real Estate"),
    Holidays("Holidays"),
    Multimedia("Multimédia"),
    Professional_Equipement("Professional équipement"),
    Home("Home"),
    Hobbies("Hobbies"),
    Services("Services"),
    Other("Other");

    private String name;

    private Categorie(String s){
        name = s;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return name;
    }
}

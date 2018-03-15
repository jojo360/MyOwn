package fr.digitecgame.myown;

/**
 * Created by Digitec Game on 15/03/2018.
 */

public class Module {
    private String nom;
    private double note;



    public Module(String a,double b){
        nom=a;
        note=b;
    }

    public String getNom () {
        return nom;
    }

    public double getNote () {
        return note;
    }

    public void setNom (String x) {
        nom=x;
    }

    public void setNote (double y) {
        note=y;
    }
}

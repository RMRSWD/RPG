package modele.Joueur;

import modele.Objet.Objet;

import java.util.ArrayList;

public class Joueur {
    private String nomJoueur;
    private ArrayList<Objet> equipement;


    public Joueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
        this.equipement = new ArrayList<>();
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public ArrayList<Objet> getEquipement() {
        return equipement;
    }

    public void setEquipement(Objet o) {
        this.equipement.add(o);
    }

    public void removeAllObjet() {
        this.equipement.clear();
    }
}

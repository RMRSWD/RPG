package modele.Joueur;

import modele.Objet.Objet;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private List<Objet> listeObjets;
    private int capaciteMax = 0;

    public Inventaire() {
        this.listeObjets = new ArrayList<>();
    }

    public void setCapaciteMax(int force) {
        this.capaciteMax += force;
    }

    public void setListeObjets(List<Objet> listeObjets) {
        this.listeObjets = listeObjets;
    }

    public void ajouterObjet(Objet objet) {
        this.listeObjets.add(objet);

    }


    public int getCapaciteMax() {
        return capaciteMax;
    }


    public List<Objet> getListeObjets() {
        return listeObjets;
    }

    public void removeObjet(String objetSup) {
        for (int i = 0; i < listeObjets.size(); i++) {
            if (listeObjets.get(i).getNomObjet().equals(objetSup)) {
                listeObjets.remove(i);
                break;
            }
        }
    }

    public Inventaire clone() {
        try {
            return (Inventaire) super.clone();
        } catch (CloneNotSupportedException e) {
            Inventaire inventaire = new Inventaire();
            inventaire.capaciteMax = this.getCapaciteMax();
            inventaire.listeObjets = new ArrayList<>();
            for (Objet objet : this.listeObjets) {
                inventaire.listeObjets.add(objet.clone());
            }
            return inventaire;
        }
    }


    public void removeAllObjet() {
        this.listeObjets.clear();
    }
}
package modele.Ennemi;

public class Ennemi {
    private String nomEnnemi;
    private int pointDeVie;
    private int pointDeVieMax;
    private int degatMonstre;

    public Ennemi() {
    }

    public Ennemi(String nom, int pointDeVieMax, int pointDeVie, int degatMonstre) {
        this.nomEnnemi = nom;
        this.pointDeVieMax = pointDeVieMax;
        this.pointDeVie = pointDeVie;
        this.degatMonstre = degatMonstre;
    }

    public String getNomEnnemi() {
        return nomEnnemi;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public int getDegatMonstre() {
        return degatMonstre;
    }

    public void setNomEnnemi(String nomEnnemi) {
        this.nomEnnemi = nomEnnemi;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public void setDegatMonstre(int degatMonstre) {
        this.degatMonstre = degatMonstre;
    }

    public int getPointDeVieMax() {
        return pointDeVieMax;
    }

    public void setPointDeVieMax(int pointDeVieMax) {
        this.pointDeVieMax = pointDeVieMax;
    }
}

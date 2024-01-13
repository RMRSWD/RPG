package modele.Objet;

public class Objet {
    String nom_Objet="";
    int indice_Objet ;

    public Objet() {
    }
    public Objet(String nom_Objet, int indice_Objet) {
        this.nom_Objet = nom_Objet;
        this.indice_Objet = indice_Objet;
    }

    public int getIndice_Objet() {
        return indice_Objet;
    }

    public void setIndice_Objet(int indice_Objet) {
        this.indice_Objet = indice_Objet;
    }

    public String getNomObjet() {
        return nom_Objet;
    }

    public void setNom_Objet(String nom_Objet) {
        this.nom_Objet = nom_Objet;
    }

    public Objet clone() {
       try{
           return (Objet) super.clone();
       }
       catch (CloneNotSupportedException e){
           return new Objet(this.nom_Objet, this.indice_Objet);
       }
    }

}

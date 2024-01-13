package modele.Theme;

import modele.Ennemi.Ennemi;
import modele.Objet.Objet;
import modele.Personnages.Personnage;

import java.util.ArrayList;
import java.util.List;

public interface GererTheme {
    List<Objet> objetsDisponibles = new ArrayList<>();
    List<Ennemi> ennemiDisponibles = new ArrayList<>();

    public void ajouterObjet(Objet objet);

    public void ajouterEnnemi(Ennemi ennemi);

    public List<Objet> getObjetsDisponibles();

    public List<Ennemi> getEnnemiDisponibles();

    public Personnage creerPersonnageBuilder(String classPersonnage);

}

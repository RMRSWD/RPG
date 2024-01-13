package modele.Theme;

import modele.Ennemi.Ennemi;
import modele.Objet.Objet;
import modele.Personnages.Director;
import modele.Personnages.PersonnageBuilder;
import modele.Personnages.Personnage;

import java.util.List;

public class Prehistoire implements GererTheme {

    @Override
    public void ajouterObjet(Objet objet) {
        objetsDisponibles.add(objet);

    }

    @Override
    public void ajouterEnnemi(Ennemi ennemi) {
        ennemiDisponibles.add(ennemi);

    }

    @Override
    public List<Objet> getObjetsDisponibles() {
        return objetsDisponibles;
    }

    @Override
    public List<Ennemi> getEnnemiDisponibles() {
        return ennemiDisponibles;
    }

    @Override
    public Personnage creerPersonnageBuilder(String classPersonnage) {
        Director director = new Director();
        PersonnageBuilder cavernesBuilder = new PersonnageBuilder();
        director.constructorCavernes(cavernesBuilder);
        return cavernesBuilder.getResultPersonnage();
    }
}

package modele.Theme;

import modele.Ennemi.Ennemi;
import modele.Objet.Objet;
import modele.Personnages.*;

import java.util.List;

public class MedievalFantastique implements GererTheme {

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
        switch (classPersonnage) {
            case "barbare":
                PersonnageBuilder barbareBuilder = new PersonnageBuilder();
                director.contructorBarbare(barbareBuilder);
                return barbareBuilder.getResultPersonnage();
            case "archer":
                PersonnageBuilder archerBuilder = new PersonnageBuilder();
                director.contructorArcher(archerBuilder);
                return archerBuilder.getResultPersonnage();
            case "sorcier":
                PersonnageBuilder sorcierPersonnage = new PersonnageBuilder();
                director.contructorSorcier(sorcierPersonnage);
                return sorcierPersonnage.getResultPersonnage();
        }
        return null;
    }
}

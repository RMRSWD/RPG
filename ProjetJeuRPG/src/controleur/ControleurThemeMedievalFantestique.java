package controleur;

import modele.Joueur.Inventaire;
import modele.Joueur.Joueur;
import modele.Objet.Objet;
import modele.Personnages.Personnage;
import modele.Theme.GererTheme;
import vue.Ihm;

public class ControleurThemeMedievalFantestique extends ControleurGeneral {
    public ControleurThemeMedievalFantestique(Ihm ihm, GererTheme themeChoisi, Joueur joueur, String typePersonnage, Personnage personnage, String nomTheme, Inventaire inventaire) {
        super(ihm, themeChoisi, joueur, typePersonnage, personnage, nomTheme, inventaire);
        ihm.setControleur(this);
    }

    public void setObjetAuDebutDansInventaire(String typePersonnage) {
        objets = themeChoisi.getObjetsDisponibles();
        if (this.typePersonnage.equals("barbare")) {
            for (Objet objet : objets) {
                if (objet.getNomObjet().equals(configUtility.getInfo("epee.nom"))) {
                    inventaire.ajouterObjet(objet);
                }
                if (objet.getNomObjet().equals(configUtility.getInfo("chaussure.nom"))) {
                    inventaire.ajouterObjet(objet);
                }
                if (objet.getNomObjet().equals(configUtility.getInfo("potion_de_vie"))) {
                    inventaire.ajouterObjet(objet);
                }
            }
        } else if (typePersonnage.equals("archer")) {
            for (Objet objet : objets) {
                if (objet.getNomObjet().equals(configUtility.getInfo("arc.nom"))) {
                    inventaire.ajouterObjet(objet);
                }
                if (objet.getNomObjet().equals(configUtility.getInfo("chaussure.nom"))) {
                    inventaire.ajouterObjet(objet);
                }
                if (objet.getNomObjet().equals(configUtility.getInfo("potion_de_vie"))) {
                    inventaire.ajouterObjet(objet);
                }
            }
        } else {
            for (Objet objet : objets) {
                if (objet.getNomObjet().equals(configUtility.getInfo("baguette_Magique.nom"))) {
                    inventaire.ajouterObjet(objet);
                }
                if (objet.getNomObjet().equals(configUtility.getInfo("chaussure.nom"))) {
                    inventaire.ajouterObjet(objet);
                }
                if (objet.getNomObjet().equals(configUtility.getInfo("potion_de_vie"))) {
                    inventaire.ajouterObjet(objet);
                }
            }
        }
    }

    public int attaquerEnnemi(int hpEnnemi, int manaJoueur, int coupJouer, String nomSkill1, int dameSkill1, int manaSkill1, String nomSkill2, int dameSkill2, int manaSkill2, int force) {
        int skillChoisir = ihm.choisirSkillJoueur(manaJoueur, nomSkill1, manaSkill1, nomSkill2, manaSkill2);
        int degatJoueur;
        if (skillChoisir == 1) {
            degatJoueur = (coupJouer + force + this.personnage.getIntelligence());
        } else if (skillChoisir == 2) {
            personnage.setManaMax(manaJoueur - personnage.getSkill1().getMana_skill());
            degatJoueur = dameSkill1;
        } else {
            personnage.setManaMax(manaJoueur - personnage.getSkill2().getMana_skill());
            degatJoueur = dameSkill2;
        }
        for (Objet o : this.joueur.getEquipement()) {
            if (o.getNomObjet().equals(configUtility.getInfo("epee.nom"))) {
                degatJoueur += o.getIndice_Objet();
            } else if (o.getNomObjet().equals(configUtility.getInfo("lance.nom"))) {
                degatJoueur += o.getIndice_Objet();
            } else if (o.getNomObjet().equals(configUtility.getInfo("baguette_Magique.nom"))) {
                degatJoueur += o.getIndice_Objet();
            } else if (o.getNomObjet().equals(configUtility.getInfo("arc.nom"))) {
                degatJoueur += o.getIndice_Objet();
            }
        }
        ihm.afficherDegatJoueur(degatJoueur);
        return hpEnnemi - degatJoueur;
    }

    public int attaquerJouer(int hpJoueur, int degatMonstre, String nomMonstre) {
        int reduitDegatsDeMonstre = 0;
        for (Objet objet1 : this.joueur.getEquipement()) {
            if (objet1.getNomObjet().equals(configUtility.getInfo("casque.nom"))) {
                reduitDegatsDeMonstre += objet1.getIndice_Objet();
            } else if (objet1.getNomObjet().equals(configUtility.getInfo("armure_de_feu.nom"))) {
                reduitDegatsDeMonstre += objet1.getIndice_Objet();
            } else if (objet1.getNomObjet().equals(configUtility.getInfo("chaussure.nom"))) {
                reduitDegatsDeMonstre += objet1.getIndice_Objet();
            }
        }
        reduitDegatsDeMonstre += this.personnage.getDexterite();
        ihm.afficherDegatMonstre((degatMonstre - reduitDegatsDeMonstre), nomMonstre);
        return hpJoueur - (degatMonstre - reduitDegatsDeMonstre);
    }
}

package controleur;

import controleur.utils.ConfigUtility;
import modele.Ennemi.Ennemi;
import modele.Joueur.Inventaire;
import modele.Joueur.Joueur;
import modele.Objet.Objet;
import modele.Personnages.Personnage;
import modele.Theme.GererTheme;
import vue.Ihm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class ControleurGeneral {
    Ihm ihm;
    Joueur joueur;
    int nombrePiece = 3;
    String nomTheme;
    String typePersonnage;
    int tourAttaque = 0;
    Personnage personnage;
    Personnage etatPersonnageAvantEntrerPiece1;
    Personnage etatPersonnageAvantEntrerPiece2;
    Personnage etatPersonnageAvantEntrerPiece3;
    Inventaire inventaire;
    Inventaire inventaireAvantEntrerPiece1;
    Inventaire inventaireAvantEntrerPiece2;
    Inventaire inventaireAvantEntrerPiece3;
    Objet objet;
    List<Objet> objets;
    GererTheme themeChoisi;
    ConfigUtility configUtility = ConfigUtility.getInstance();
    int nombrePieceCourant = 0;
    int nombreMort = 2;

    public ControleurGeneral(Ihm ihm, GererTheme themeChoisi, Joueur joueur, String typePersonnage, Personnage personnage, String nomTheme, Inventaire inventaire) {
        this.ihm = ihm;
        this.joueur = joueur;
        this.personnage = personnage;
        this.nomTheme = nomTheme;
        this.inventaire = inventaire;
        this.typePersonnage = typePersonnage;
        this.themeChoisi = themeChoisi;
        this.objet = new Objet();
    }

    public void startJeu() {
        this.nombreMort = 2;
        this.tourAttaque = 0;
        String choixMenuPrincipal = ihm.menuPrincipalDuJeu(this.nomTheme);
        this.setCapaciteInventaire();
        this.setObjetAuDebutDansInventaire(this.typePersonnage);
        if (choixMenuPrincipal.equals("1")) {
            this.afficherInventaire();
            this.afficherLesChoixSuivant();
        } else {
            this.ihm.afficherInformationDeDonjon();
            this.entrerDansDonjon();
        }
    }

    public void afficherInventaire() {
        this.ihm.afficherInventaire(this.inventaire.getListeObjets(), this.inventaire.getCapaciteMax());
    }

    public void afficherLesChoixSuivant() {
        this.ihm.afficherLesChoixSuivant(this.inventaire.getListeObjets(), this.nomTheme, this.joueur, this.personnage, this.inventaire);
    }

    public void afficherLesChoixSuivantDansPiece(int nombrePieceCourant, List<Ennemi> ennemiList) {
        this.ihm.afficherLesChoixSuivantDansPiece(this.inventaire.getListeObjets(), this.nomTheme, this.joueur, this.personnage, this.inventaire, nombrePieceCourant + 1, ennemiList);

    }

    public void entrerDansDonjon() {
        boolean leJoueurMortDeja = false;
        List<Ennemi> ennemiList = this.themeChoisi.getEnnemiDisponibles();
        this.ihm.afficherEntrerDonjon(ennemiList);
        this.ihm.afficherObjetRecuperer(this.themeChoisi.getObjetsDisponibles());
        this.entrerDansPiece(this.nombrePieceCourant, ennemiList, this.personnage, leJoueurMortDeja);
    }

    public void entrerDansPiece(int nombrePieceCourant, List<Ennemi> ennemiList, Personnage personnage, boolean leJoueurMortDeja) {
        this.ihm.afficherCrierDeGuerre(this.personnage.getCrierDeGuerre());
        int premierTour = 1;
        Ennemi ennemiChoisir;
        List<Ennemi> listeEnnemieDansPiece;
        for (int i = nombrePieceCourant; i < this.nombrePiece; i++) {
            nombrePieceCourant = i;
            if (!leJoueurMortDeja) {
                this.enregistrerEtatDuJoueurDansPiece(nombrePieceCourant);
                this.enregistrerEtatInventaireDuJoueur(nombrePieceCourant);
            }
            this.ihm.afficherNombrePieceDonjon(nombrePieceCourant);
            if (nombrePieceCourant > 0) {
                premierTour = 1;
                listeEnnemieDansPiece = this.ihm.afficherMonstresDansPiece(reinitialiserEnnemis(ennemiList));

            } else {
                listeEnnemieDansPiece = this.ihm.afficherMonstresDansPiece(ennemiList);
            }
            while (!listeEnnemieDansPiece.isEmpty() && personnage.getHpMax() > 0) {
                if (premierTour == 1) {
                    this.ihm.afficherActionJoueur();
                    ennemiChoisir = this.ihm.afficherChoisirEnnemi(listeEnnemieDansPiece);
                    this.gererActionJoueur(personnage, this.themeChoisi.getObjetsDisponibles(), ennemiChoisir, listeEnnemieDansPiece, nombrePieceCourant, ennemiList);
                    premierTour = 0;
                } else {
                    Random randomEnnemiResteDansPiece = new Random();
                    int indiceEnnemiAleatoire = randomEnnemiResteDansPiece.nextInt(listeEnnemieDansPiece.size());
                    ennemiChoisir = listeEnnemieDansPiece.get(indiceEnnemiAleatoire);
                    this.gererActionJoueur(personnage, this.themeChoisi.getObjetsDisponibles(), ennemiChoisir, listeEnnemieDansPiece, nombrePieceCourant, ennemiList);
                }
            }
        }
        this.ihm.afficherJoueurGargneFinal(this.joueur.getNomJoueur());
        this.afficherInventaire();
        this.inventaire.removeAllObjet();
        this.joueur.removeAllObjet();
        this.reinitialiserEnnemis(ennemiList);
        this.setEtatPersonnage();
        this.startJeu();
    }

    public void gererActionJoueur(Personnage personnage, List<Objet> objetsDisponibles, Ennemi ennemiChoisir, List<Ennemi> ennemiDansLaPiece, int nombrePieceCourant, List<Ennemi> ennemiList) {
        String nomPersonnage = personnage.getNomPersonnage();
        String nomMonstre = ennemiChoisir.getNomEnnemi();
        int coupMonstre = ennemiChoisir.getDegatMonstre();
        while (personnage.getHpMax() > 0 && ennemiChoisir.getPointDeVie() > 0) {
            if (this.tourAttaque == 0) {
                int nbrHPResteEnnemi = attaquerEnnemi(ennemiChoisir.getPointDeVie(), personnage.getManaMax(), personnage.getDegatPersonnage(), personnage.getSkill1().getNom_skill(), personnage.getSkill1().getDame_skill(), personnage.getSkill1().getMana_skill(), personnage.getSkill2().getNom_skill(), personnage.getSkill2().getDame_skill(), personnage.getSkill2().getMana_skill(), personnage.getForce());
                ennemiChoisir.setPointDeVie(nbrHPResteEnnemi);
                this.ihm.afficherInfoEnnemi(nomMonstre, ennemiChoisir.getPointDeVie());
                changerTour(this.tourAttaque);
            } else {
                int hpCourantJoueur = attaquerJouer(personnage.getHpMax(), coupMonstre, nomMonstre);
                personnage.setHpMax(hpCourantJoueur);
                this.ihm.afficherInfoJoueur(nomPersonnage, personnage.getHpMax(), personnage.getManaMax());
                changerTour(this.tourAttaque);
            }
        }
        boolean checkWin = checkWiner(personnage.getHpMax(), ennemiChoisir.getPointDeVie());
        if (checkWin) {
            this.ihm.afficherJoueurGargne();
            Objet objetLacheParMonstre = this.ihm.afficherObjetLacheParMonstre(objetsDisponibles, nomMonstre);
            int choixJoueur = this.ihm.demanderJoueurPrendreObjet(objetLacheParMonstre.getNomObjet());
            if (choixJoueur == 1) {
                if(this.inventaire.getListeObjets().size() <= this.inventaire.getCapaciteMax()) {
                    this.inventaire.ajouterObjet(objetLacheParMonstre);
                }
                else{
                    this.ihm.afficherErreurDepasserCapaciteInventaire();
                }
                this.ihm.confirmerPrendreObjet(objetLacheParMonstre.getNomObjet());
                ennemiDansLaPiece.remove(ennemiChoisir);
            } else {
                this.ihm.confirmerPasPrendreObjet(objetLacheParMonstre.getNomObjet());
            }
            if (ennemiDansLaPiece.isEmpty() && nombrePieceCourant < this.nombrePiece - 1) {
                this.tourAttaque = 0;
                int choixJoueurApresPasserPiece = this.ihm.afficherChoixJouerApresPasserPiece();
                if (choixJoueurApresPasserPiece == 2) {
                    afficherInventaire();
                    reinitialiserEnnemis(ennemiList);
                    afficherLesChoixSuivantDansPiece(nombrePieceCourant, ennemiList);
                }
                if (choixJoueurApresPasserPiece == 3) {
                    reinitialiserEnnemis(ennemiList);
                    startJeu();
                }
            }
        } else {
            this.ihm.afficherMonstreGargne();
            ihm.afficherNombreMortJoueur(this.nombreMort);

            if (this.nombreMort > 0) {
                this.nombreMort -= 1;
                int choixJoueurApreMort = this.ihm.afficherChoixJoueurApreMort();
                if (choixJoueurApreMort == 1) {
                    if(nombrePieceCourant == 0) {
                        revenirPiecePrecedente(nombrePieceCourant, ennemiList);
                    }
                    else{
                        revenirPiecePrecedente(nombrePieceCourant - 1, ennemiList);
                    }
                } else {
                    this.personnage.setHpMax(1);
                    List<Objet> supprimerObjetApresMort = new ArrayList<>();
                    for (Objet objet : this.inventaire.getListeObjets()) {
                        if (objet.getNomObjet().equals(this.configUtility.getInfo("potion_de_vie")) ||
                                objet.getNomObjet().equals(this.configUtility.getInfo("potion_de_mana")) ||
                                objet.getNomObjet().equals(this.configUtility.getInfo("fruit.nom")) ||
                                objet.getNomObjet().equals(this.configUtility.getInfo("viande.nom")))
                                {
                            supprimerObjetApresMort.add(objet);
                        }

                    }
                    for(Objet obj : supprimerObjetApresMort){
                        this.inventaire.removeObjet(obj.getNomObjet());
                    }
                    this.ihm.afficherInformationQuandJoueurRetournerMenu();
                    this.ihm.afficherInfoJoueur(this.personnage.getNomPersonnage(), this.personnage.getHpMax(), this.personnage.getManaMax());
                    this.ihm.afficherInventaire(this.inventaire.getListeObjets(), this.inventaire.getCapaciteMax());
                    this.reinitialiserEnnemis(ennemiList);
                    this.afficherLesChoixSuivant();
                }
            } else {
                this.ihm.afficherInformationQuandJoueurRetournerMenu();
                this.inventaire.removeAllObjet();
                this.joueur.removeAllObjet();
                this.reinitialiserEnnemis(ennemiList);
                this.setEtatPersonnage();
                this.startJeu();
            }
        }
    }

    public List<Ennemi> reinitialiserEnnemis(List<Ennemi> ennemiList) {
        for (Ennemi ennemi : ennemiList) {
            ennemi.setPointDeVie(ennemi.getPointDeVieMax());
        }
        return ennemiList;
    }

    public void enregistrerEtatInventaireDuJoueur(int nombrePieceCourant) {
        if (nombrePieceCourant == 0) {
            this.inventaireAvantEntrerPiece1 = this.inventaire.clone();
        } else if (nombrePieceCourant == 1) {
            this.inventaireAvantEntrerPiece2 = this.inventaire.clone();
        } else {
            this.inventaireAvantEntrerPiece3 = this.inventaire.clone();
        }

    }

    public void enregistrerEtatDuJoueurDansPiece(int nombrePieceCourant) {
        if (nombrePieceCourant == 0) {
            this.etatPersonnageAvantEntrerPiece1 = this.personnage.clone();
        } else if (nombrePieceCourant == 1) {
            this.etatPersonnageAvantEntrerPiece2 = this.personnage.clone();
        } else {
            this.etatPersonnageAvantEntrerPiece3 = this.personnage.clone();
        }
    }

    public void revenirPiecePrecedente(int nombrePieceCourant, List<Ennemi> ennemiList) {
        boolean leJoueurMortDeja = false;
        if (nombrePieceCourant == 0) {
            this.personnage.setHpMax(this.etatPersonnageAvantEntrerPiece1.getHpMax());
            this.personnage.setManaMax(this.etatPersonnageAvantEntrerPiece1.getManaMax());
            this.inventaire.setListeObjets(this.inventaireAvantEntrerPiece1.getListeObjets());
            this.ihm.afficherInfoJoueur(this.personnage.getNomPersonnage(), this.personnage.getHpMax(), this.personnage.getManaMax());
            this.ihm.afficherInventaire(this.inventaire.getListeObjets(), this.inventaire.getCapaciteMax());
            this.reinitialiserEnnemis(ennemiList);
            this.entrerDansPiece(nombrePieceCourant, ennemiList, this.personnage, leJoueurMortDeja);
        } else if (nombrePieceCourant == 1) {
            this.personnage.setHpMax(this.etatPersonnageAvantEntrerPiece2.getHpMax());
            this.personnage.setManaMax(this.etatPersonnageAvantEntrerPiece2.getManaMax());
            this.inventaire.setListeObjets(this.inventaireAvantEntrerPiece2.getListeObjets());
            this.ihm.afficherInfoJoueur(this.personnage.getNomPersonnage(), this.personnage.getHpMax(), this.personnage.getManaMax());
            this.ihm.afficherInventaire(this.inventaire.getListeObjets(), this.inventaire.getCapaciteMax());
            this.reinitialiserEnnemis(ennemiList);
            this.entrerDansPiece(nombrePieceCourant, ennemiList, this.personnage, leJoueurMortDeja);
        } else {
            this.personnage.setHpMax(this.etatPersonnageAvantEntrerPiece3.getHpMax());
            this.personnage.setManaMax(this.etatPersonnageAvantEntrerPiece3.getManaMax());
            this.inventaire.setListeObjets(this.inventaireAvantEntrerPiece3.getListeObjets());
            this.ihm.afficherInfoJoueur(this.personnage.getNomPersonnage(), this.personnage.getHpMax(), this.personnage.getManaMax());
            this.ihm.afficherInventaire(this.inventaire.getListeObjets(), this.inventaire.getCapaciteMax());
            this.reinitialiserEnnemis(ennemiList);
            this.entrerDansPiece(nombrePieceCourant, ennemiList, this.personnage, leJoueurMortDeja);
        }
    }

    abstract void setObjetAuDebutDansInventaire(String typePersonnage);

    abstract int attaquerEnnemi(int hpEnnemi, int manaJoueur, int coupJouer, String nomSkill1, int dameSkill1, int manaSkill1, String nomSkill2, int dameSkill2, int manaSkill2, int force);

    abstract int attaquerJouer(int hpJoueur, int degatMonstre, String nomMonstre);

    public boolean checkWiner(int hpMaxJoueur, int pointDeVieMonstre) {

        if (hpMaxJoueur > 0) {
            return true;
        } else if (pointDeVieMonstre > 0) {
            return false;
        } else {
            return false;
        }
    }

    public void setCapaciteInventaire() {
        this.inventaire.setCapaciteMax(this.personnage.getForce());
    }

    public void equiperObjet(Objet o) {
        if(estArme(o) && compteArmesEquipees(this.joueur) >=2){
            ihm.afficherErreurTropArmeEquipees();
        }
        else if (joueur.getEquipement().contains(o)) {
            ihm.afficherErreurExisteDansEquipementDuJoueur();
        } else {
            joueur.setEquipement(o);
            ihm.informerObjetBienEquiper(o);
            supprimerObjetDansInventaire(o.getNomObjet());
        }
    }

    public int compteArmesEquipees(Joueur joueur) {
        int nombreArmes = 0;
        for (Objet objet : joueur.getEquipement()){
            if(estArme(objet)){
                nombreArmes++;
            }
        }
        return nombreArmes;
    }

    public boolean estArme(Objet o) {
        boolean check = false;

        if(o.getNomObjet().equals(configUtility.getInfo("epee.nom"))){
            return true;
        }
        else if(o.getNomObjet().equals(configUtility.getInfo("lance.nom"))){
            return true;
        }
        else if(o.getNomObjet().equals(configUtility.getInfo("baguette_Magique.nom"))){
            return true;
        }
        else if(o.getNomObjet().equals(configUtility.getInfo("arc.nom"))){
            return true;
        }
        else if(o.getNomObjet().equals(configUtility.getInfo("baton.nom"))){
            return true;
        }
        else if(o.getNomObjet().equals(configUtility.getInfo("pierre.nom"))){
            return true;
        }
        else if(o.getNomObjet().equals(configUtility.getInfo("fronde.nom"))){
            return true;
        }
        else{
            return check;
        }
    }
    public boolean estPotion(Objet objet){
        boolean check = false;
        if(objet.getNomObjet().equals(configUtility.getInfo("potion_de_vie"))){
            return true;
        } else if (objet.getNomObjet().equals(configUtility.getInfo("potion_de_mana"))) {
            return true;
        } else if (objet.getNomObjet().equals(configUtility.getInfo("fruit.nom"))) {
            return true;
        } else if (objet.getNomObjet().equals(configUtility.getInfo("viande.nom"))) {
            return true;
        }
        else{
            return check;
        }
    }

    public void supprimerObjetDansInventaire(String nomObjet) {
        inventaire.removeObjet(nomObjet);
    }

    public void changerTour(int tourAttaque) {
        if (tourAttaque == 0) {
            this.tourAttaque = 1;
        } else if (tourAttaque == 1) {
            this.tourAttaque = 0;
        }
    }

    public void augmenterHPJoueur(int hpJoueurApresUtiliserPotion) {
        this.personnage.setHpMax(this.personnage.getHpMax() + (hpJoueurApresUtiliserPotion + this.personnage.getConstitution()));
    }

    public void augmenterManaJoueur(int manaJoueurApresUtiliserPotion) {
        this.personnage.setManaMax(this.personnage.getManaMax() + manaJoueurApresUtiliserPotion + this.personnage.getConstitution());
    }

    private void setEtatPersonnage() {
        if (this.personnage.getNomPersonnage().equals(this.configUtility.getInfo("barbare_Personnage.nom"))) {
            this.personnage.setHpMax(Integer.parseInt(this.configUtility.getInfo("hpMax.b")));
            this.personnage.setManaMax(Integer.parseInt(this.configUtility.getInfo("manaMax.b")));
        }
        if (this.personnage.getNomPersonnage().equals(this.configUtility.getInfo("archer_Personnage"))) {
            this.personnage.setHpMax(Integer.parseInt(this.configUtility.getInfo("hpMax.a")));
            this.personnage.setManaMax(Integer.parseInt(this.configUtility.getInfo("manaMax.a")));
        }
        if (this.personnage.getNomPersonnage().equals(this.configUtility.getInfo("sorcier_Personnage"))) {
            this.personnage.setHpMax(Integer.parseInt(this.configUtility.getInfo("hpMax.s")));
            this.personnage.setManaMax(Integer.parseInt(this.configUtility.getInfo("manaMax.s")));
        }
        if (this.personnage.getNomPersonnage().equals(this.configUtility.getInfo("cavernes_Personnage"))) {
            this.personnage.setHpMax(Integer.parseInt(this.configUtility.getInfo("hpMax.c")));
            this.personnage.setManaMax(Integer.parseInt(this.configUtility.getInfo("manaMax.c")));
        }
    }
}
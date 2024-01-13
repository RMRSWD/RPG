import controleur.ControleurThemeMedievalFantestique;
import controleur.ControleurThemePrehistoire;
import modele.Joueur.Inventaire;
import modele.Joueur.Joueur;
import modele.Personnages.Personnage;
import modele.Theme.GererTheme;
import modele.Theme.NomTheme;
import modele.Theme.ThemeFactory;
import vue.Ihm;

public class Main {

    public static void main(String[] args) {
        String nomJoueur;
        String typePersonnage;
        Personnage personnage;
        GererTheme themeChoisir;
        Joueur joueur;
        Ihm ihm = new Ihm();
        while (true) {
            try {
                String nomTheme = ihm.choisirTheme();
                ThemeFactory themeFactory = new ThemeFactory();
                Inventaire inventaire = new Inventaire();
                if (nomTheme.equals("MEDIEVAL_FANTASTIQUE")) {
                    ihm.annoncer(nomTheme);
                    themeChoisir = themeFactory.getTheme(NomTheme.MEDIEVAL_FANTASTIQUE);
                    nomJoueur = ihm.saisirNomJoueur();
                    typePersonnage = ihm.choisirPersonnage(nomTheme);
                    personnage = themeChoisir.creerPersonnageBuilder(typePersonnage);
                    joueur = new Joueur(nomJoueur);
                    ControleurThemeMedievalFantestique controleurThemeMedievalFantestique = new ControleurThemeMedievalFantestique(ihm, themeChoisir, joueur, typePersonnage, personnage, nomTheme, inventaire);
                    controleurThemeMedievalFantestique.startJeu();
                    break;
                } else if (nomTheme.equals("PREHISTOIRE")) {
                    ihm.annoncer(nomTheme);
                    themeChoisir = themeFactory.getTheme(NomTheme.PREHISTOIRE);
                    nomJoueur = ihm.saisirNomJoueur();
                    typePersonnage = ihm.choisirPersonnage(nomTheme);
                    personnage = themeChoisir.creerPersonnageBuilder(typePersonnage);
                    joueur = new Joueur(nomJoueur);
                    ControleurThemePrehistoire controleurThemePrehistoire = new ControleurThemePrehistoire(ihm, themeChoisir, joueur, typePersonnage, personnage, nomTheme, inventaire);
                    controleurThemePrehistoire.startJeu();
                    break;
                } else {
                    ihm.afficherErreurChoisirTheme();
                }
            }
            catch(NumberFormatException e){
                ihm.afficherErreur(e);
            }
        }

    }


}
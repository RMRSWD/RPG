package modele.Theme;

import controleur.utils.ConfigUtility;
import modele.Ennemi.*;
import modele.Objet.*;

public class ThemeFactory {
    public GererTheme getTheme(NomTheme nomTheme){
        GererTheme themeCreer = null;
        ConfigUtility configUtils = ConfigUtility.getInstance();
        switch (nomTheme){
            case MEDIEVAL_FANTASTIQUE -> {
                themeCreer = new MedievalFantastique();
                themeCreer.ajouterObjet(new Epee(configUtils.getInfo("epee.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Epee.level1"))));
                themeCreer.ajouterObjet(new Lance(configUtils.getInfo("lance.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Lance.level1"))));
                themeCreer.ajouterObjet(new BaguetteMagique(configUtils.getInfo("baguette_Magique.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_BaguetteMagique.level1"))));
                themeCreer.ajouterObjet(new Arc(configUtils.getInfo("arc.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Arc.level1"))));
                themeCreer.ajouterObjet(new Casque(configUtils.getInfo("casque.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Casque.level1"))));
                themeCreer.ajouterObjet(new Armure(configUtils.getInfo("armure_de_feu.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Armure_de_feu.level1"))));
                themeCreer.ajouterObjet(new Chaussure(configUtils.getInfo("chaussure.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Chaussure.level1"))));
                themeCreer.ajouterObjet(new PosionDeVie(configUtils.getInfo("potion_de_vie"),
                        Integer.parseInt(configUtils.getInfo("indice_Posion_de_vie.level1"))));
                themeCreer.ajouterObjet(new PosionDeMana(configUtils.getInfo("potion_de_mana"),
                        Integer.parseInt(configUtils.getInfo("indice_Posion_de_mana.level1"))));

                themeCreer.ajouterEnnemi(new Dragon(configUtils.getInfo("nom.dragon"),
                        Integer.parseInt(configUtils.getInfo("pointDeVieMax.dragon")),
                        Integer.parseInt(configUtils.getInfo("pointDeVie.dragon")),
                        Integer.parseInt(configUtils.getInfo("degat.dragon"))));

                themeCreer.ajouterEnnemi(new ChauveSouris(configUtils.getInfo("nom.chauveSouris"),
                        Integer.parseInt(configUtils.getInfo("pointDeVieMax.souris")),
                        Integer.parseInt(configUtils.getInfo("pointDeVie.chauveSouris")),
                        Integer.parseInt(configUtils.getInfo("degat.chauveSouris"))));

                themeCreer.ajouterEnnemi(new RatEngage(configUtils.getInfo("nom.ratEngage"),
                        Integer.parseInt(configUtils.getInfo("pointDeVieMax.rat")),
                        Integer.parseInt(configUtils.getInfo("pointDeVie.ratEngage")),
                        Integer.parseInt(configUtils.getInfo("degat.ratEngage"))));

                themeCreer.ajouterEnnemi(new ChevalierErrant(configUtils.getInfo("nom.chevalierErrant"),
                        Integer.parseInt(configUtils.getInfo("pointDeVieMax.errant")),
                        Integer.parseInt(configUtils.getInfo("pointDeVie.chevalierErrant")),
                        Integer.parseInt(configUtils.getInfo("degat.chevalierErrant"))));

            }
            case PREHISTOIRE -> {
                themeCreer = new Prehistoire();
                themeCreer.ajouterObjet(new Baton(configUtils.getInfo("baton.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Baton.level1"))));
                themeCreer.ajouterObjet(new Pierre(configUtils.getInfo("pierre.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Pierre.level1"))));
                themeCreer.ajouterObjet(new Fronde(configUtils.getInfo("fronde.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Fronde.level1"))));
                themeCreer.ajouterObjet(new Fronde(configUtils.getInfo("manteau.nom1"),
                        Integer.parseInt(configUtils.getInfo("indice_ManteauOur"))));
                themeCreer.ajouterObjet(new Fronde(configUtils.getInfo("manteau.nom2"),
                        Integer.parseInt(configUtils.getInfo("indice_ManteauLoup"))));
                themeCreer.ajouterObjet(new Fruit(configUtils.getInfo("fruit.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Fruit.level1"))));
                themeCreer.ajouterObjet(new Viande(configUtils.getInfo("viande.nom"),
                        Integer.parseInt(configUtils.getInfo("indice_Viande.level1"))));

                themeCreer.ajouterEnnemi(new Mammouth(configUtils.getInfo("nom.mamMouth"),
                        Integer.parseInt(configUtils.getInfo("pointDeVieMax.mammouth")),
                        Integer.parseInt(configUtils.getInfo("pointDeVie.mamMouth")),
                        Integer.parseInt(configUtils.getInfo("degat.mamMouth"))));

                themeCreer.ajouterEnnemi(new Tigre(configUtils.getInfo("nom.tiGre"),
                        Integer.parseInt(configUtils.getInfo("pointDeVieMax.tigre")),
                        Integer.parseInt(configUtils.getInfo("pointDeVie.tiGre")),
                        Integer.parseInt(configUtils.getInfo("degat.tiGre"))));
                themeCreer.ajouterEnnemi(new Dinosaure(configUtils.getInfo("nom.Dinosaure"),
                        Integer.parseInt(configUtils.getInfo("pointDeVieMax.dinosaure")),
                        Integer.parseInt(configUtils.getInfo("pointDeVie.Dinosaure")),
                        Integer.parseInt(configUtils.getInfo("degat.Dinosaure"))));
                themeCreer.ajouterEnnemi(new Our(configUtils.getInfo("nom.Our"),
                        Integer.parseInt(configUtils.getInfo("pointDeVieMax.our")),
                        Integer.parseInt(configUtils.getInfo("pointDeVie.Our")),
                        Integer.parseInt(configUtils.getInfo("degat.Our"))));
                themeCreer.ajouterEnnemi(new Loup(configUtils.getInfo("nom.Loup"),
                        Integer.parseInt(configUtils.getInfo("pointDeVieMax.loup")),
                        Integer.parseInt(configUtils.getInfo("pointDeVie.Loup")),
                        Integer.parseInt(configUtils.getInfo("degat.Loup"))));
            }
        }
        return themeCreer;
    }
}

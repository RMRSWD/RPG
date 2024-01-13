package vue;

import controleur.utils.ConfigUtility;
import controleur.ControleurGeneral;
import modele.Ennemi.Ennemi;
import modele.Joueur.Inventaire;
import modele.Joueur.Joueur;
import modele.Objet.Objet;
import modele.Personnages.Personnage;

import java.util.*;

public class Ihm {
    private ControleurGeneral controleur;
    ConfigUtility configUtility = ConfigUtility.getInstance();
    Scanner sc = new Scanner(System.in);

    public Ihm() {
        System.out.println("--Bienvenue à l'aventure--");
        System.out.println("""
                Pour commencer le jeu, vous devez choisir le theme d'abord, vous pouvez choisir
                1: Médieval fantastique
                2: Préhistoire""");
    }

    public String choisirTheme() {
        String numTheme;
        while (true) {
            numTheme = sc.nextLine();
            if (numTheme.equals("1")) {
                return "MEDIEVAL_FANTASTIQUE";

            } else if (numTheme.equals("2")) {
                return "PREHISTOIRE";
            } else {
                System.out.println("Le nombre que vous avez sélectionné n'est pas valide. Veuillez sasir à nouveau.");
            }

        }

    }

    public void setControleur(ControleurGeneral controleur) {
        this.controleur = controleur;
    }


    public String saisirNomJoueur() {
        String nomJoueur;

        while (true) {
            System.out.println("Saisir votre nom:");
            nomJoueur = sc.nextLine().trim();

            if (nomJoueur.length() >= 2 && nomJoueur.length() <= 10 && nomJoueur.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Nom invalide. Le nom doit être entre 2 et 10 caractères et ne doit contenir que des lettres!!!");
            }
        }

        return nomJoueur;
    }


    public String choisirPersonnage(String nom_theme) {
        String type_personnage;
        String num;
        System.out.println("Vous pouvez choisir un des type suivant le thème que vous avez choisi:");
        if (nom_theme.equals("MEDIEVAL_FANTASTIQUE")) {
            System.out.println("""
                    1: barbare
                    2: archer.e
                    3: socier.e""");
            while (true) {
                num = sc.nextLine();
                if (num.equals("1")) {
                    type_personnage = configUtility.getInfo("barbare_Personnage.nom");
                    break;
                } else if (num.equals("2")) {
                    type_personnage = configUtility.getInfo("archer_Personnage");
                    break;
                } else if (num.equals("3")) {
                    type_personnage = configUtility.getInfo("sorcier_Personnage");
                    break;
                } else {
                    System.out.println("Le nombre que vous avez sélectionné n'est pas valide. Veuillez sasir à nouveau.");
                }
            }
        } else {
            System.out.println("""
                    Dans cette thème, vous ne pouvez que choisir un type de personnage.
                    Tapez vous 1 pour choisir:
                    1: homme de caverne""");
            while (true) {
                num = sc.nextLine();
                if (num.equals("1")) {
                    type_personnage = configUtility.getInfo("cavernes_Personnage");
                    break;
                } else {
                    System.out.println("Le nombre que vous avez sélectionné n'est pas valide. Veuillez sasir à nouveau.");
                }
            }
        }
        return type_personnage;
    }

    public void annoncer(String nomTheme) {
        System.out.println("Vous avez choisir le theme " + nomTheme);
    }

    public String menuPrincipalDuJeu(String nom_theme) {
        String choix_menuPrincipal;
        System.out.println("Bienvenue au " + nom_theme);
        System.out.println("--Menu principal du jeu--");
        System.out.println("""
                Vous avez deux options:
                1: Afficher l'inventaire
                2: Entrer dans le donjon
                Remarque: Pour quiter le jeu vous tapez 1 -> tapez 5 -> tapez 3""");
        while (true) {
            choix_menuPrincipal = sc.nextLine();
            System.out.print("");
            if (choix_menuPrincipal.equals("1")) {
                return choix_menuPrincipal;
            } else if (choix_menuPrincipal.equals("2")) {
                return choix_menuPrincipal;
            } else {
                System.out.println("Le nombre que vous avez sélectionné n'est pas valide. Veuillez sasir à nouveau.");
            }
        }
    }

    public void afficherInventaire(List<Objet> objets, int max_place) {
        System.out.println("Vous avez utilisé " + objets.size() + "/" + max_place + " places disponibles");
        System.out.println("Voici tous les objets dont vous disposez dans l'inventaire");
        System.out.println("------------------------------");

        if (objets.isEmpty()) {
            System.out.println("Vous n'équipez aucun objet actuellement");
        } else {
            for (int i = 0; i < objets.size(); i++) {
                Objet objet = objets.get(i);
                // Affiche l'objet sans sauter de ligne
                if (controleur.estArme(objet)) {
                    System.out.print((i + 1) + ". |" + objet.getNomObjet() + " / Indice: +" + objet.getIndice_Objet() + " dégats | ");
                } else if (controleur.estPotion(objet)) {
                    System.out.print((i + 1) + ". |" + objet.getNomObjet() + " / Indice: +" + objet.getIndice_Objet() + " constitutions | ");

                } else {
                    System.out.print((i + 1) + ". |" + objet.getNomObjet() + " / Indice: +" + objet.getIndice_Objet() + " armures | ");
                }
                // Si on est à la fin d'une ligne de 5 objets ou à la fin de la liste, on passe à la ligne suivante
                if ((i + 1) % 5 == 0 || i == objets.size() - 1) {
                    System.out.println(); // Saut de ligne
                }
            }
        }
        System.out.println("------------------------------");
    }


    public void afficherInformationDeDonjon() {
        String couleurRed = configUtility.getInfo("ANSI_RED");
        String couleurReset = configUtility.getInfo("ANSI_RESET");
        System.out.println("Vous avez entrer dans le donjon\n" +
               couleurRed +"Attention!!!" + couleurReset);
    }

    public void afficherLesChoixSuivant(List<Objet> objets, String nomTheme, Joueur joueur, Personnage personnage, Inventaire inventaire) {
        String choix;

        System.out.println("""
                Vous avez cinqs options:
                1: Consommer un objet consommable
                2: Jeter un objet
                3: S'équiper un objet
                4: Afficher les objets que vous avez équipés
                5: Quitter""");
        while (true) {
            choix = sc.nextLine();
            System.out.print("");
            switch (choix) {
                case "1" -> {
                    if (nomTheme.equals("MEDIEVAL_FANTASTIQUE")) {
                        int nombrePotionsVie = 0;
                        int nombrePotionsMana = 0;
                        String nomPotionvie = configUtility.getInfo("potion_de_vie");
                        String nomPotionmana = configUtility.getInfo("potion_de_mana");
                        for (Objet objet : objets) {
                            if (objet.getNomObjet().equals("Potion de vie")) {
                                nombrePotionsVie++;
                            }
                            if (objet.getNomObjet().equals("Potion de mana")) {
                                nombrePotionsMana++;
                            }
                        }
                        System.out.println("Vous avez " + nombrePotionsVie + " potions de vie et " +
                                nombrePotionsMana + " potions de mana dans votre sac.");
                        System.out.println("""
                                Tapez 1 pour utiliser potion de vie
                                Tapez 2 pour utiliser potion de mana
                                Tapez 3 pour revenir au menu""");
                        utilisateurUtiliserPotion(nombrePotionsVie, nombrePotionsMana, nomPotionvie, nomPotionmana, personnage);
                    } else {
                        int nombrePotionsVie = 0;
                        int nombrePotionsMana = 0;
                        String nomPotionvie = configUtility.getInfo("viande.nom");
                        String nomPotionmana = configUtility.getInfo("fruit.nom");

                        for (Objet objet : objets) {
                            if (objet.getNomObjet().equals("Poulet")) {
                                nombrePotionsVie++;
                            }
                            if (objet.getNomObjet().equals("Pomme")) {
                                nombrePotionsMana++;
                            }
                        }
                        System.out.println("Vous avez " + nombrePotionsVie + " Poulet et " +
                                nombrePotionsMana + " Pomme dans votre sac.");
                        System.out.println("""
                                Tapez 1 pour utiliser la Poulet
                                Tapez 2 pour utiliser du Pomme\s
                                Tapez 3 pour revenir au menu""");
                        utilisateurUtiliserPotion(nombrePotionsVie, nombrePotionsMana, nomPotionvie, nomPotionmana, personnage);
                    }
                }
                case "2" -> jeterObjet(objets, inventaire);
                case "3" -> equiperObjet(objets, inventaire);
                case "4" -> afficherObjetsEquiper(joueur);
                case "5" -> {
                    System.out.println("Quitter le menu");
                    System.out.println("""
                            Voulez vous entrer dans le donjon?
                            Tapez 1 pour entrer dans le donjon
                            Tapez 2 pour rester
                            Tapez 3 pour quiter le jeu""");
                    while (true) {
                        choix = sc.nextLine();
                        if (choix.equals("1")) {
                            controleur.entrerDansDonjon();
                            break;
                        } else if (choix.equals("2")) {
                            controleur.afficherInventaire();
                            controleur.afficherLesChoixSuivant();
                            break;
                        } else if (choix.equals("3")) {
                            System.out.println("Vous avez choisi quiter le jeu. A bientot!!!");
                            System.exit(0);

                        } else {
                            System.out.println("Le nombre que vous avez sélectionné n'est pas valide. Veuillez sasir à nouveau");
                        }
                    }
                }
                default -> System.out.println("Choissisez vous entre de 1 -> 5");
            }

        }
    }

    public void afficherLesChoixSuivantDansPiece(List<Objet> listeObjets, String nomTheme, Joueur joueur, Personnage personnage, Inventaire inventaire, int nombrePieceCourant, List<Ennemi> ennemiList) {
        String choixJ;
        System.out.println("Reposez vous un peu avant d'avancer la pièce suivante....:))");
        System.out.println("""
                Vous avez cinqs options
                1: Consommer un objet consommable
                2: Jeter un objet
                3: S'équiper un objet
                4: Afficher les objets que vous avez équipés
                5: Revenie la piece""");
        while (true) {
            choixJ = sc.nextLine();
            System.out.print("");
            switch (choixJ) {
                case "1" -> {
                    if (nomTheme.equals("MEDIEVAL_FANTASTIQUE")) {
                        int nombrePotionsVie = 0;
                        int nombrePotionsMana = 0;
                        String nomPotionvie = configUtility.getInfo("potion_de_vie");
                        String nomPotionmana = configUtility.getInfo("potion_de_mana");
                        for (Objet objet : listeObjets) {
                            if (objet.getNomObjet().equals("Potion de vie")) {
                                nombrePotionsVie++;
                            }
                            if (objet.getNomObjet().equals("Potion de mana")) {
                                nombrePotionsMana++;
                            }
                        }
                        System.out.println("Vous avez " + nombrePotionsVie + " potions de vie et " +
                                nombrePotionsMana + " potions de mana dans votre sac.");
                        System.out.println("""
                                Tapez 1 pour utiliser potion de vie
                                Tapez 2 pour utiliser potion de mana
                                Tapez 3 pour revenir au menu""");
                        utilisateurUtiliserPotion(nombrePotionsVie, nombrePotionsMana, nomPotionvie, nomPotionmana, personnage);
                    } else {
                        int nombrePotionsVie = 0;
                        int nombrePotionsMana = 0;
                        String nomPotionvie = configUtility.getInfo("viande.nom");
                        String nomPotionmana = configUtility.getInfo("fruit.nom");

                        for (Objet objet : listeObjets) {
                            if (objet.getNomObjet().equals("Poulet")) {
                                nombrePotionsVie++;
                            }
                            if (objet.getNomObjet().equals("Pomme")) {
                                nombrePotionsMana++;
                            }
                        }
                        System.out.println("Vous avez " + nombrePotionsVie + " Poulet et " +
                                nombrePotionsMana + " Pomme dans votre sac.");
                        System.out.println("""
                                Tapez 1 pour utiliser la Poulet
                                Tapez 2 pour utiliser du Pomme\s
                                Tapez 3 pour revenir au menu""");
                        utilisateurUtiliserPotion(nombrePotionsVie, nombrePotionsMana, nomPotionvie, nomPotionmana, personnage);
                    }
                }
                case "2" -> jeterObjet(listeObjets, inventaire);
                case "3" -> equiperObjet(listeObjets, inventaire);
                case "4" -> afficherObjetsEquiper(joueur);
                case "5" -> this.controleur.entrerDansPiece(nombrePieceCourant, ennemiList, personnage, false);
                default -> System.out.println("Choissisez vous entre de 1 -> 5");
            }

        }
    }

    public void afficherObjetsEquiper(Joueur joueur) {
        if (joueur.getEquipement().isEmpty()) {
            System.out.println("Vous n'avez aucun objet dans votre sac actuellement");
        } else {
            System.out.println("----------------------------------------------");
            System.out.println("Voici tous les objets que vous avez équipés : ");
            List<Objet> equipement = joueur.getEquipement();
            for (int i = 0; i < equipement.size(); i++) {
                Objet objet = equipement.get(i);
                if (controleur.estArme(objet)) {
                    System.out.print((i + 1) + ". |" + objet.getNomObjet() + " / Indice: +" + objet.getIndice_Objet() + " dégats | ");
                } else if (controleur.estPotion(objet)) {
                    System.out.print((i + 1) + ". |" + objet.getNomObjet() + " / Indice: +" + objet.getIndice_Objet() + " constitutions | ");

                } else {
                    System.out.print((i + 1) + ". |" + objet.getNomObjet() + " / Indice: +" + objet.getIndice_Objet() + " armures | ");
                }
                // Si on est à la fin d'une ligne de 5 objets ou à la fin de la liste, on passe à la ligne suivante
                if ((i + 1) % 5 == 0 || i == equipement.size() - 1) {
                    System.out.println(); // Saut de ligne
                }
            }
            System.out.println("----------------------------------------------");
        }


        System.out.println("""
                Vous avez cinq options:
                1: Consommer un objet consommable
                2: Jeter un objet
                3: S'équiper un objet
                4: Afficher les objets que vous avez équipés
                5: Quitter""");
    }

    public void equiperObjet(List<Objet> objets, Inventaire inventaire) {
        System.out.println("Voici tous les objets que vous pouvez vous équiper");
        afficherInventaire(objets, inventaire.getCapaciteMax());
        String choix;
        System.out.println("Choisissez l'objet que vous souhaitez équiper dans votre inventaire\n" +
                "Tapez 0 pour quitter");
        while (true) {
            choix = sc.nextLine();
            try {
                int numeroObjet = Integer.parseInt(choix);
                if (numeroObjet > 0 && numeroObjet <= objets.size()) {
                    Objet o = objets.get(numeroObjet - 1);
                    controleur.equiperObjet(o);
                    controleur.afficherInventaire();
                    break;
                } else if (numeroObjet == 0) {
                    controleur.afficherInventaire();
                    break;
                } else {
                    System.out.println("Le nombre que vous avez sélectionné n'est pas valide. Veuillez saisir à nouveau");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro valide.");
            }
        }
        System.out.println("""
                Vous avez cinq options:
                1: Consommer un objet consommable
                2: Jeter un objet
                3: S'équiper un objet
                4: Afficher les objets que vous avez équipés
                5: Quitter""");
    }

    public void jeterObjet(List<Objet> objets, Inventaire inventaire) {
        String nb;
        System.out.println("Quel objet vous voulez jeter?\n" +
                "Saisissez le numéro correspondant à l'article dont vous souhaitez vous jeter!");
        this.afficherInventaire(objets, inventaire.getCapaciteMax());
        while (true) {
            nb = sc.nextLine();
            try {
                int numeroObjet = Integer.parseInt(nb);
                if (numeroObjet > 0 && numeroObjet <= objets.size()) {
                    Objet o = objets.get(numeroObjet - 1);
                    System.out.println("--------------------------------------------------");
                    System.out.println("Vous avez jeté " + o.getNomObjet() + " avec succès");
                    System.out.println("--------------------------------------------------");
                    controleur.supprimerObjetDansInventaire(o.getNomObjet());
                    controleur.afficherInventaire();
                    break;
                } else {
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Le numéro que vous avez choisi n'existe pas. Veuillez le saisir à nouveau !");
                    System.out.println("---------------------------------------------------------------------------");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro valide.");
            }
        }
        System.out.println("""
                Vous avez cinqs options:
                1: Consommer un objet consommable
                2: Jeter un objet
                3: S'équiper un objet
                4: Aficher les objets que vous avez équipés
                5: Quitter""");
    }


    public void utilisateurUtiliserPotion(int nombrePotionsVie, int nombrePotionsMana, String nomPotionvie, String nomPotionmana, Personnage personnage) {
        String choixUtiliserPotion;
        while (true) {
            choixUtiliserPotion = sc.nextLine();
            if (choixUtiliserPotion.equals("1")) {
                if (nombrePotionsVie > 0 && personnage.getHpMax() < 100) {
                    if (nomPotionvie.equals(configUtility.getInfo("potion_de_vie"))) {
                        System.out.println("Vous avez utilisé une potion de vie");
                        controleur.augmenterHPJoueur(Integer.parseInt(configUtility.getInfo("indice_Posion_de_vie.level1")));
                        controleur.supprimerObjetDansInventaire(configUtility.getInfo("potion_de_vie"));
                        System.out.println("Votre etat actuellement -->");
                        afficherInfoJoueur(personnage.getNomPersonnage(), personnage.getHpMax(), personnage.getManaMax());
                        System.out.println("""
                                Vous avez cinqs options:
                                1: Consommer un objet consommable
                                2: Jeter un objet
                                3: S'équiper un objet
                                4: Aficher les objets que vous avez équipés
                                5: Quitter""");
                        break;
                    } else {
                        System.out.println("Vous avez mangé un poulet");
                        controleur.augmenterHPJoueur(Integer.parseInt(configUtility.getInfo("indice_Viande.level1")));
                        controleur.supprimerObjetDansInventaire(configUtility.getInfo("viande.nom"));
                        System.out.println("Votre etat actuellement -->");
                        afficherInfoJoueur(personnage.getNomPersonnage(), personnage.getHpMax(), personnage.getManaMax());
                        System.out.println("""
                                Vous avez cinqs options:
                                1: Consommer un objet consommable
                                2: Jeter un objet
                                3: S'équiper un objet
                                4: Aficher les objets que vous avez équipés
                                5: Quitter""");
                        break;
                    }
                } else {
                    if (nombrePotionsVie == 0) {
                        System.out.println("---------------------------------");
                        System.out.println("Vous n'avez plus de potion de vie");
                        System.out.println("---------------------------------");
                    } else {
                        System.out.println("La santé de votre personnage est bonne. Vous n'avez pas besoin d'utiliser de potions de vie !");
                    }
                    System.out.println("""
                            Vous avez cinqs options:
                            1: Consommer un objet consommable
                            2: Jeter un objet
                            3: S'équiper un objet
                            4: Aficher les objets que vous avez équipés
                            5: Quitter""");
                    break;
                }
            } else if (choixUtiliserPotion.equals("2")) {
                if (nombrePotionsMana > 0 && personnage.getManaMax() < 100) {
                    if (nomPotionmana.equals(configUtility.getInfo("potion_de_mana"))) {
                        System.out.println("Vous avez utilisé une potion de mana");
                        controleur.augmenterManaJoueur(Integer.parseInt(configUtility.getInfo("indice_Posion_de_mana.level1")));
                        controleur.supprimerObjetDansInventaire(configUtility.getInfo("potion_de_mana"));
                        System.out.println("Votre etat actuellement -->");
                        afficherInfoJoueur(personnage.getNomPersonnage(), personnage.getHpMax(), personnage.getManaMax());
                        System.out.println("""
                                Vous avez cinqs options:
                                1: Consommer un objet consommable
                                2: Jeter un objet
                                3: S'équiper un objet
                                4: Aficher les objets que vous avez équipés
                                5: Quitter""");
                        break;
                    } else {
                        System.out.println("Vous avez mangé une pomme");
                        controleur.augmenterManaJoueur(Integer.parseInt(configUtility.getInfo("indice_Fruit.level1")));
                        controleur.supprimerObjetDansInventaire(configUtility.getInfo("fruit.nom"));
                        System.out.println("Votre etat actuellement -->");
                        afficherInfoJoueur(personnage.getNomPersonnage(), personnage.getHpMax(), personnage.getManaMax());
                        System.out.println("""
                                Vous avez cinqs options:
                                1: Consommer un objet consommable
                                2: Jeter un objet
                                3: S'équiper un objet
                                4: Aficher les objets que vous avez équipés
                                5: Quitter""");
                        break;
                    }
                } else {
                    if (nombrePotionsMana == 0) {
                        System.out.println("Vous n'avez plus de potion de mana");
                    } else {
                        System.out.println("Le mana de votre personnage est bonne. Vous n'avez pas besoin d'utiliser de potions de mana !");
                    }
                    System.out.println("""
                            Vous avez cinqs options:
                            1: Consommer un objet consommable
                            2: Jeter un objet
                            3: S'équiper un objet
                            4: Aficher les objets que vous avez équipés
                            5: Quitter""");
                    break;
                }
            } else if (choixUtiliserPotion.equals("3")) {
                System.out.println("""
                        Vous avez cinqs options:
                        1: Consommer un objet consommable
                        2: Jeter un objet
                        3: S'équiper un objet
                        4: Aficher les objets que vous avez équipés
                        5: Quitter""");
                break;
            } else {

                System.out.println("Nombre invalide. Veuillez saisir à nouveau!");
            }
        }
    }

    public void afficherErreurExisteDansEquipementDuJoueur() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("L'objet que vous souhaitez équiper, il existe déjà dans votre équipement\n" +
                "Veuillez choisir un autre objet!!!");
        System.out.println("--------------------------------------------------------------------------");
    }

    public void afficherEntrerDonjon(List<Ennemi> ennemiList) {
        System.out.println("Dans cette pièce, vous allez rencontrer les monstres suivants:");
        if (ennemiList.isEmpty()) {
            System.out.println("Aucun monstre ici.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ennemiList.size(); i++) {
            sb.append(ennemiList.get(i).getNomEnnemi());
            if (i < ennemiList.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(">>> " + sb);
    }

    public void afficherNombrePieceDonjon(int i) {
        System.out.println("Vous entrez dans la pièce " + (i + 1));
    }

    public List<Ennemi> afficherMonstresDansPiece(List<Ennemi> ennemiList) {
        int nombreMonstreDansChaquePiece = 3;
        List<Ennemi> listeEnnemiDansLaPiece = new ArrayList<>();
        Collections.shuffle(ennemiList);
        System.out.println("Les monstres dans cette pièce : ");
        for (int i = 0; i < nombreMonstreDansChaquePiece; i++) {
            listeEnnemiDansLaPiece.add(ennemiList.get(i));
            System.out.println((i + 1) + ". " + ennemiList.get(i).getNomEnnemi() + "/ HP: " + ennemiList.get(i).getPointDeVie() + "/ Degat: " + ennemiList.get(i).getDegatMonstre());
        }
        return listeEnnemiDansLaPiece;
    }

    public void afficherObjetRecuperer(List<Objet> objetsDisponibles) {
        Collections.shuffle(objetsDisponibles);
        System.out.println("Dans cette pièce vous pouvez récupérer les objets suivants:");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objetsDisponibles.size(); i++) {
            sb.append(objetsDisponibles.get(i).getNomObjet());
            if (i < objetsDisponibles.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(">>> " + sb);
        System.out.println("-----------------------------------------------------------");
    }

    public void afficherActionJoueur() {
        String choix;
        System.out.println("""
                Choisissez votre action :
                1. Attaquer un ennemi
                2: Récupérer objet""");
        while (true) {
            choix = sc.nextLine();
            System.out.print("");
            if (choix.equals("1")) {
                break;
            } else if (choix.equals("2")) {
                System.out.println("Vous n'avez pas encore tué d'ennemis. Attaquez les ennemis dans la pièce pour obtenir des objets !!!!\n" +
                        "Tapez 1 pour attaquer des ennemis");


            } else {
                System.out.println("Veuillez saisir à nouveau!!!");
            }
        }
    }

    public Ennemi afficherChoisirEnnemi(List<Ennemi> listeEnnemieDansPiece) {
        String choix;
        Ennemi ennemiChoisir;
        System.out.println("Vous pouvez choisir un des " + listeEnnemieDansPiece.size() + " monstres pour attaquer");
        while (true) {
            choix = sc.nextLine();
            try {
                int numeroEnnemi = Integer.parseInt(choix);
                if (numeroEnnemi > 0 && numeroEnnemi <= listeEnnemieDansPiece.size()) {
                    ennemiChoisir = listeEnnemieDansPiece.get(numeroEnnemi - 1);
                    System.out.println("Vous avez choisi " + ennemiChoisir.getNomEnnemi());
                    break;
                } else {
                    System.out.println("Le numéro choisi est invalide. Veuillez saisir à nouveau");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro valide.");
            }
        }
        return ennemiChoisir;
    }


    public void afficherInfoJoueur(String nomPersonnage, int hpJoueur, int manaJoueur) {
        String couleurHp = configUtility.getInfo("ANSI_GREEN");
        String couleurMana = configUtility.getInfo("ANSI_BLUE");
        String couleurPersonnage = configUtility.getInfo("ANSI_CYAN");
        String couleurReset = configUtility.getInfo("ANSI_RESET");
        System.out.println("--------------------------------");
        System.out.println("Informations -> " + couleurPersonnage + nomPersonnage + couleurReset);
        if (hpJoueur < 0) {
            System.out.println(couleurHp+ "HP / 0" + couleurReset);
        } else {
            System.out.println(couleurHp + "HP / " + hpJoueur + couleurReset);
        }

        if (manaJoueur < 0) {
            System.out.println(couleurMana + "Mana / 0" + couleurReset);
        } else {
            System.out.println(couleurMana +"Mana / " + manaJoueur + couleurReset);
        }
        System.out.println("--------------------------------");
    }


    public int choisirSkillJoueur(int manaCourantJoeur, String skill1, int manaSkill1, String skill2, int manaSkill2) {
        String numChoix;
        System.out.println("Choissisez votre compétance pour effecture un coup\n" +
                "1: Attaque normal\n" +
                "2: Utilisé skill 1 > " + skill1 + "\n" +
                "3: Utilisé skill 2 >> " + skill2);
        while (true) {
            numChoix = sc.nextLine();
            System.out.print("");
            if (numChoix.equals("1")) {
                System.out.println("Vous avez effectué un coup normal!");
                return Integer.parseInt(numChoix);

            } else if (numChoix.equals("2")) {
                if (manaCourantJoeur >= manaSkill1) {
                    System.out.println("Vous avez effectué un coupe en utilisant skill de " + skill1);
                    return Integer.parseInt(numChoix);
                } else {
                    System.out.println("Vous n'avez pas assez de mana pour utiliser cete compétance!");
                    System.out.println("Re-choisir votre skill pour attaquer");
                }
            } else if (numChoix.equals("3")) {
                if (manaCourantJoeur >= manaSkill2) {
                    System.out.println("Vous avez effectué un coupe en utilisant skill de " + skill2);
                    return Integer.parseInt(numChoix);
                } else {
                    System.out.println("Vous n'avez pas assez de mana pour utiliser cete compétance!");
                    System.out.println("Re-choisir votre skill pour attaquer");
                }
            } else {
                System.out.println("nombre invalide. Veuillez saisir à nouveau!");
            }
        }
    }

    public void afficherInfoEnnemi(String nomMonstre, int hpMonstre) {
        String couleurRouge = configUtility.getInfo("ANSI_RED");
        String couleurReset = configUtility.getInfo("ANSI_RESET");
        System.out.println("--------------------------------");
        if (hpMonstre > 0) {
            System.out.println(nomMonstre + "\n" +
                    couleurRouge +"HP/ " + hpMonstre + couleurReset);
        } else {
            System.out.println(nomMonstre + "\n" +
                    couleurRouge +"HP/ 0" + couleurReset);
        }
    }

    public void afficherJoueurGargne() {
        System.out.println("-------------------------");
        System.out.println("Vous avez tué un monstre!");
    }

    public void afficherMonstreGargne() {
        System.out.println("Vous avez été vaincu par un monstre");
    }

    public Objet afficherObjetLacheParMonstre(List<Objet> objetsDisponibles, String nomMonstre) {
        String couleurObjet = configUtility.getInfo("ANSI_YELLOW_BACKGROUND");
        String couleurReset = configUtility.getInfo("ANSI_RESET");
        Random random = new Random();
        int retourneIndice = random.nextInt(objetsDisponibles.size());
        System.out.println(couleurObjet + "$" + couleurReset + " L'objet après avoir vaincu " + nomMonstre + " est: " + objetsDisponibles.get(retourneIndice).getNomObjet());
        return objetsDisponibles.get(retourneIndice);
    }

    public int demanderJoueurPrendreObjet(String nomObjet) {
        String choix;
        System.out.println("Est-ce que vous voulez prende " + nomObjet + "\n" +
                "1: Oui\n" +
                "2: Non");
        while (true) {
            choix = sc.nextLine();
            System.out.print("");
            if (choix.equals("1")) {
                return Integer.parseInt(choix);
            } else if (choix.equals("2")) {
                return Integer.parseInt(choix);
            } else {
                System.out.println("Nombre invalide. Veuillez saisir à nouveau!!!");
            }
        }
    }

    public void confirmerPrendreObjet(String nomObjet) {
        System.out.println("------------------------------------------");
        System.out.println(nomObjet + " a été placé dans l'inventaire!");
        System.out.println("------------------------------------------");
    }

    public void confirmerPasPrendreObjet(String nomObjet) {
        System.out.println("Je n'aime pas " + nomObjet);
    }

    public void afficherDegatJoueur(int degatJoueur) {
        System.out.println("Les dégats infligés au monstre -> |" + degatJoueur + "| dégats");
    }

    public void afficherDegatMonstre(int degatMonstre, String nomMonstre) {
        String couleurMonstre = configUtility.getInfo("ANSI_RED_BACKGROUND");
        String couleurReset = configUtility.getInfo("ANSI_RESET");
        System.out.println(couleurMonstre + nomMonstre + couleurReset + " a effectué un coup -> |" + degatMonstre + "| dégats");
    }

    public void afficherErreurChoisirTheme() {
        System.out.println("Nombre invalide. Veuillez saisir à nouveau!!!");
    }

    public int afficherChoixJoueurApreMort() {
        String choix;
        System.out.println("""
                Vous avez deux options:
                1: Retourner la pièce précédente
                2: Quiter la partie""");
        while (true) {
            choix = sc.nextLine();
            System.out.print("");
            if (choix.equals("1")) {
                return Integer.parseInt(choix);
            } else if (choix.equals("2")) {
                return Integer.parseInt(choix);
            } else {
                System.out.println("Numéro invalide. Veuillez saisir à nouveau!");
            }

        }
    }

    public void afficherInformationQuandJoueurRetournerMenu() {
        System.out.println("----------------------------");
        System.out.println("Vous êtes au menu principal!");
        System.out.println("----------------------------");
    }

    public int afficherChoixJouerApresPasserPiece() {
        String choix;
        System.out.println("""
                Vous avez tué tous les monstres dans la pièce...Bravo!!!
                Vous pouvez choisir l'une des options suivantes pour poursuivre votre jeu
                1: Passer la pièce suivant
                2: Accéder à l'inventaire
                3: Quiter le donjon""");
        while (true) {
            choix = sc.nextLine();
            System.out.print("");
            if (choix.equals("1")) {
                System.out.println("Vous avez choisi de passer à la pièce suivante... Bonne chance !");
                return Integer.parseInt(choix);
            } else if (choix.equals("2")) {
                System.out.println("Vous avez choisi d'accéder à votre inventaire");
                return Integer.parseInt(choix);
            } else if (choix.equals("3")) {
                System.out.println("Vous avez choisi de quiter le donjon!");
                return Integer.parseInt(choix);
            } else {
                System.out.println("Nombre invalide. Veuillez saisir à nouveau!");
            }
        }

    }

    public void afficherNombreMortJoueur(int nombreMort) {
        System.out.println("Vous restez " + nombreMort + " fois pour revenir la pièce précédente!");
    }

    public void informerObjetBienEquiper(Objet o) {
        System.out.println("-------------------------------------");
        System.out.println(o.getNomObjet() + " est bien équipé!!!");
        System.out.println("-------------------------------------");
    }

    public void afficherJoueurGargneFinal(String nomJoueur) {
        System.out.println("Bravo " + nomJoueur + "!!!\n" +
                "Vous avez passé tous les pièces dans le donjon!");
    }

    public void afficherCrierDeGuerre(String crierDeGuerre) {
        System.out.println("Cris de guerre <<<" + crierDeGuerre + ">>>");
    }

    public void afficherErreur(NumberFormatException e) {
        System.out.println("Erreur >>> " + e + "<<<");
    }

    public void afficherErreurTropArmeEquipees() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Vous avez équipé deux armes. Vous ne pouvez pas équiper plus!!!");
        System.out.println("---------------------------------------------------------------");
    }

    public void afficherErreurDepasserCapaciteInventaire() {
        System.out.println("Vous ne pouvez pas ajouter plus des objets dans l'inventaire! Il est complete\n" +
                "Veuillez supprimer les objets pour l'ajouter!");
    }
    //DV
}
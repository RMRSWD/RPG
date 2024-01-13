package modele.Personnages;

import modele.Skill.Skill1;
import modele.Skill.Skill2;

public class PersonnageBuilder implements PBuilder {
    private String nomPersonnage;
    private int hp_max;
    private int hp_courant;
    private int manaMax;
    private int manaCourant;
    private int expMax;
    private int expCourant;
    private int level;
    private int levelMax;
    private int degat_joueur;
    private Skill1 skill1;
    private Skill2 skill2;

    private int dameSkill1;
    private int dameSkill2;
    private int manaSkill1;
    private int manaSkill2;
    private String crier_de_guerre;
    private int force = 0;
    private String competance;
    private int dexterite = 0;
    private int constitution = 0;
    private int intelligence = 0;

    @Override
    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    @Override
    public void setHp_max(int hp_max) {
        this.hp_max = hp_max;
    }

    @Override
    public void setHp_courant(int hp_courant) {
        this.hp_courant = hp_courant;
    }

    @Override
    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;

    }

    @Override
    public void setManaCourant(int manaCourant) {
        this.manaCourant = manaCourant;

    }

    @Override
    public void setExpMax(int expMax) {
        this.expMax = expMax;
    }

    @Override
    public void setExpCourant(int expCourant) {
        this.expCourant = expCourant;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    public void setLevelMax(int levelMax) {
        this.levelMax = levelMax;
    }

    @Override
    public void setDegatPersonnage(int degat_joueur) {
        this.degat_joueur = degat_joueur;
    }

    @Override
    public void setCrier_de_guerre(String crier_de_guerre) {
        this.crier_de_guerre = crier_de_guerre;
    }

    @Override
    public void setForce(int force) {
        this.force = force;
    }

    @Override
    public void setCompetance(String competance) {
        this.competance = competance;
    }

    @Override
    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }

    @Override
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void setSkill1(String nomSkill1) {
        this.skill1 = new Skill1(nomSkill1, this.dameSkill1, this.manaSkill1);

    }

    @Override
    public void setSkill2(String nomSkill2) {
        this.skill2 = new Skill2(nomSkill2, this.dameSkill2, this.manaSkill2);
    }

    @Override
    public void setDameSkill1(int dameSkill1) {
        this.dameSkill1 = dameSkill1;

    }

    @Override
    public void setDameSkill2(int dameSkill2) {
        this.dameSkill2 = dameSkill2;

    }

    @Override
    public void setManaSkill1(int manaSkill1) {
        this.manaSkill1 = manaSkill1;
    }

    @Override
    public void setManaSkill2(int manaSkill2) {
        this.manaSkill2 = manaSkill2;
    }

    public Personnage getResultPersonnage() {
        return new Personnage(nomPersonnage, hp_max, hp_courant, manaMax, manaCourant, expMax, expCourant, level, levelMax, degat_joueur, skill1, skill2, dameSkill1, dameSkill2, manaSkill1, manaSkill2, crier_de_guerre, force, competance, dexterite, constitution, intelligence);
    }
}

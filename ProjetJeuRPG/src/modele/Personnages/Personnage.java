package modele.Personnages;

import modele.Skill.Skill1;
import modele.Skill.Skill2;

public class Personnage {
    private String nomPersonnage;
    private int hpMax;
    private int hpCourant;
    private int manaMax;

    private int manaCourant;
    private int expMax;
    private int expCourant;
    private int level;
    private int levelMax;
    private int degatPersonnage;
    private Skill1 skill1;
    private Skill2 skill2;
    private int dameSkill1;
    private int dameSkill2;
    private int manaSkill1;
    private int manaSkill2;
    private String crierDeGuerre;
    private int force = 0;
    private String competance;
    private int dexterite = 0;
    private int constitution = 0;
    private int intelligence = 0;

    public Personnage() {

    }

    public Personnage(String nomPersonnage, int hpMax, int hpCourant, int manaMax, int manaCourant, int expMax, int expCourant, int level, int levelMax, int degatPersonnage, Skill1 skill1, Skill2 skill2, int dameSkill1, int dameSkill2, int manaSkill1, int manaSkill2, String crierDeGuerre, int force, String competance, int dexterite, int constitution, int intelligence) {
        this.nomPersonnage = nomPersonnage;
        this.hpMax = hpMax;
        this.hpCourant = hpCourant;
        this.manaMax = manaMax;
        this.manaCourant = manaCourant;
        this.expMax = expMax;
        this.expCourant = expCourant;
        this.level = level;
        this.levelMax = levelMax;
        this.degatPersonnage = degatPersonnage;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.dameSkill1 = dameSkill1;
        this.dameSkill2 = dameSkill2;
        this.manaSkill1 = manaSkill1;
        this.manaSkill2 = manaSkill2;
        this.crierDeGuerre = crierDeGuerre;
        this.force = force;
        this.competance = competance;
        this.dexterite = dexterite;
        this.constitution = constitution;
        this.intelligence = intelligence;
    }


    public Personnage(String nomPersonnage, int hpMax, int hpCourant, int manaMax, int manaCourant, int expMax, int expCourant, int level, int levelMax, int degatPersonnage, int dameSkill1, int dameSkill2, int manaSkill1, int manaSkill2, String crierDeGuerre, int force, String competance, int dexterite, int constitution, int intelligence) {
        this.nomPersonnage = nomPersonnage;
        this.hpMax = hpMax;
        this.hpCourant = hpCourant;
        this.manaMax = manaMax;
        this.manaCourant = manaCourant;
        this.expMax = expMax;
        this.expCourant = expCourant;
        this.level = level;
        this.levelMax = levelMax;
        this.degatPersonnage = degatPersonnage;
        this.dameSkill1 = dameSkill1;
        this.dameSkill2 = dameSkill2;
        this.manaSkill1 = manaSkill1;
        this.manaSkill2 = manaSkill2;
        this.crierDeGuerre = crierDeGuerre;
        this.force = force;
        this.competance = competance;
        this.dexterite = dexterite;
        this.constitution = constitution;
        this.intelligence = intelligence;
    }

    public String getNomPersonnage() {
        return nomPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getHpCourant() {
        return hpCourant;
    }

    public void setHpCourant(int hpCourant) {
        this.hpCourant = hpCourant;
    }

    public int getManaMax() {
        return manaMax;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public int getManaCourant() {
        return manaCourant;
    }

    public void setManaCourant(int manaCourant) {
        this.manaCourant = manaCourant;
    }

    public int getExpMax() {
        return expMax;
    }

    public void setExpMax(int expMax) {
        this.expMax = expMax;
    }

    public int getExpCourant() {
        return expCourant;
    }

    public void setExpCourant(int expCourant) {
        this.expCourant = expCourant;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(int levelMax) {
        this.levelMax = levelMax;
    }

    public int getDegatPersonnage() {
        return degatPersonnage;
    }

    public void setDegatPersonnage(int degatPersonnage) {
        this.degatPersonnage = degatPersonnage;
    }

    public Skill1 getSkill1() {
        return skill1;
    }

    public void setSkill1(Skill1 skill1) {
        this.skill1 = skill1;
    }

    public Skill2 getSkill2() {
        return skill2;
    }

    public void setSkill2(Skill2 skill2) {
        this.skill2 = skill2;
    }

    public int getDameSkill1() {
        return dameSkill1;
    }

    public void setDameSkill1(int dameSkill1) {
        this.dameSkill1 = dameSkill1;
    }

    public int getDameSkill2() {
        return dameSkill2;
    }

    public void setDameSkill2(int dameSkill2) {
        this.dameSkill2 = dameSkill2;
    }

    public int getManaSkill1() {
        return manaSkill1;
    }

    public void setManaSkill1(int manaSkill1) {
        this.manaSkill1 = manaSkill1;
    }

    public int getManaSkill2() {
        return manaSkill2;
    }

    public void setManaSkill2(int manaSkill2) {
        this.manaSkill2 = manaSkill2;
    }

    public String getCrierDeGuerre() {
        return crierDeGuerre;
    }

    public void setCrierDeGuerre(String crierDeGuerre) {
        this.crierDeGuerre = crierDeGuerre;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public String getCompetance() {
        return competance;
    }

    public void setCompetance(String competance) {
        this.competance = competance;
    }

    public int getDexterite() {
        return dexterite;
    }

    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public Personnage clone() {
        try {
            return (Personnage) super.clone();
        } catch (CloneNotSupportedException e) {
            Personnage personnage = new Personnage(this.nomPersonnage, this.hpMax, this.hpCourant, this.manaMax,
                    this.manaCourant, this.expMax, this.expCourant,
                    this.level, this.levelMax, this.degatPersonnage,
                    this.dameSkill1,
                    this.dameSkill2, this.manaSkill1, this.manaSkill2,
                    this.crierDeGuerre, this.force, this.competance,
                    this.dexterite, this.constitution, this.intelligence);
            personnage.skill1 = this.skill1.clone();
            personnage.skill2 = this.skill2.clone();
            return personnage;
        }
    }
}

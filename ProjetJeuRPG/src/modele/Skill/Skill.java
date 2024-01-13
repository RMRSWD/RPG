package modele.Skill;

public abstract class Skill {
    private String nom_skill;
    private int dame_skill;
    private int mana_skill;

    public Skill(){

    }

    public String getNom_skill() {
        return nom_skill;
    }

    public void setNom_skill(String nom_skill) {
        this.nom_skill = nom_skill;
    }

    public int getDame_skill() {
        return dame_skill;
    }

    public void setDame_skill(int dame_skill) {
        this.dame_skill = dame_skill;
    }

    public int getMana_skill() {
        return mana_skill;
    }

    public void setMana_skill(int mana_skill) {
        this.mana_skill = mana_skill;
    }
}

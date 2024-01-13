package modele.Skill;

public class Skill1 extends Skill {
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_RESET = "\u001B[0m";
    //    String nom_skill = ANSI_RED+"boules de feu"+ANSI_RESET;
    String nom_skill;
    int dame_skill;
    int mana_skill;

    public Skill1() {
    }

    public Skill1(String nom_skill, int dame_skill, int mana_skill) {
        this.nom_skill = nom_skill;
        this.dame_skill = dame_skill;
        this.mana_skill = mana_skill;
    }

    @Override
    public String getNom_skill() {
        return nom_skill;
    }

    @Override
    public int getDame_skill() {
        return dame_skill;
    }

    @Override
    public int getMana_skill() {
        return mana_skill;
    }

    @Override
    public Skill1 clone() {
        try {
            return (Skill1) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Skill1(this.nom_skill, this.dame_skill, this.mana_skill);
        }
    }
}

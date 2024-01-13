package modele.Skill;

public class Skill2 extends Skill {
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_RESET = "\u001B[0m";
    private String nom_skill;
    private int dame_skill;
    private int mana_skill;

    public Skill2() {
    }

    public Skill2(String nom_skill, int dame_skill, int mana_skill) {
        this.nom_skill = nom_skill;
        this.dame_skill = dame_skill;
        this.mana_skill = mana_skill;
    }

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
    public Skill2 clone() {
        try {
            return (Skill2) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Skill2(this.nom_skill, this.dame_skill, this.mana_skill);
        }
    }
}

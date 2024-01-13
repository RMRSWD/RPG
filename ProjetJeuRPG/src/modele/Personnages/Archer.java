package modele.Personnages;

import modele.Skill.Skill1;
import modele.Skill.Skill2;

public class Archer extends Personnage{
    public Archer() {
    }

    public Archer(String nomPersonnage, int hpMax, int hpCourant, int manaMax, int manaCourant, int expMax, int expCourant, int level, int levelMax, int degatPersonnage, Skill1 skill1, Skill2 skill2, int dameSkill1, int dameSkill2, int manaSkill1, int manaSkill2, String crierDeGuerre, int force, String competance, int dexterite, int constitution, int intelligence) {
        super(nomPersonnage, hpMax, hpCourant, manaMax, manaCourant, expMax, expCourant, level, levelMax, degatPersonnage, skill1, skill2, dameSkill1, dameSkill2, manaSkill1, manaSkill2, crierDeGuerre, force, competance, dexterite, constitution, intelligence);
    }
}

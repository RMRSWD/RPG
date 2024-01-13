package modele.Personnages;

import controleur.utils.ConfigUtility;

public class Director {
    ConfigUtility configUtility = ConfigUtility.getInstance();
    public void contructorBarbare(PBuilder builder){
        builder.setNomPersonnage(configUtility.getInfo("barbare_Personnage.nom"));
        builder.setLevel(Integer.parseInt( configUtility.getInfo("levelDebut.b")));
        builder.setLevelMax(Integer.parseInt( configUtility.getInfo("levelMax.b")));
        builder.setHp_max(Integer.parseInt( configUtility.getInfo("hpMax.b")));
        builder.setHp_courant(Integer.parseInt(configUtility.getInfo("hpCourant.b")));
        builder.setManaMax(Integer.parseInt(configUtility.getInfo("manaMax.b")));
        builder.setManaCourant(Integer.parseInt(configUtility.getInfo("manaCourant.b")));
        builder.setDegatPersonnage(Integer.parseInt(configUtility.getInfo("degat.b")));
        builder.setExpMax(Integer.parseInt(configUtility.getInfo("expMax.b")));
        builder.setExpCourant(Integer.parseInt(configUtility.getInfo("expCourant.b")));
        builder.setCrier_de_guerre(configUtility.getInfo("crierDeGuerre.b"));
        builder.setForce(Integer.parseInt(configUtility.getInfo("force.b")));
        builder.setDexterite(Integer.parseInt(configUtility.getInfo("dexterite.b")));
        builder.setConstitution(Integer.parseInt(configUtility.getInfo("constitution.b")));
        builder.setIntelligence(Integer.parseInt(configUtility.getInfo("intelligence.b")));
        builder.setDameSkill1(Integer.parseInt(configUtility.getInfo("dameSkill.b")));
        builder.setManaSkill1(Integer.parseInt(configUtility.getInfo("manaSkill1.b")));
        builder.setSkill1(configUtility.getInfo("skill1.b"));
        builder.setDameSkill2(Integer.parseInt(configUtility.getInfo("dameSkill2.b")));
        builder.setManaSkill2(Integer.parseInt(configUtility.getInfo("manaSkill2.b")));
        builder.setSkill2(configUtility.getInfo("skill2.b"));
    }

    public void contructorArcher(PBuilder builder){
        builder.setNomPersonnage(configUtility.getInfo("archer_Personnage"));
        builder.setLevel(Integer.parseInt( configUtility.getInfo("levelDebut.a")));
        builder.setLevelMax(Integer.parseInt( configUtility.getInfo("levelMax.a")));
        builder.setHp_max(Integer.parseInt( configUtility.getInfo("hpMax.a")));
        builder.setHp_courant(Integer.parseInt(configUtility.getInfo("hpCourant.a")));
        builder.setManaMax(Integer.parseInt(configUtility.getInfo("manaMax.a")));
        builder.setManaCourant(Integer.parseInt(configUtility.getInfo("manaCourant.a")));
        builder.setDegatPersonnage(Integer.parseInt(configUtility.getInfo("degat.a")));
        builder.setExpMax(Integer.parseInt(configUtility.getInfo("expMax.a")));
        builder.setExpCourant(Integer.parseInt(configUtility.getInfo("expCourant.a")));
        builder.setCrier_de_guerre(configUtility.getInfo("crierDeGuerre.a"));
        builder.setForce(Integer.parseInt(configUtility.getInfo("force.a")));
        builder.setDexterite(Integer.parseInt(configUtility.getInfo("dexterite.a")));
        builder.setConstitution(Integer.parseInt(configUtility.getInfo("constitution.a")));
        builder.setIntelligence(Integer.parseInt(configUtility.getInfo("intelligence.a")));
        builder.setDameSkill1(Integer.parseInt(configUtility.getInfo("dameSkill.a")));
        builder.setManaSkill1(Integer.parseInt(configUtility.getInfo("manaSkill1.a")));
        builder.setSkill1(configUtility.getInfo("skill1.a"));
        builder.setDameSkill2(Integer.parseInt(configUtility.getInfo("dameSkill2.a")));
        builder.setManaSkill2(Integer.parseInt(configUtility.getInfo("manaSkill2.a")));
        builder.setSkill2(configUtility.getInfo("skill2.a"));
    }

    public void contructorSorcier(PBuilder builder){
        builder.setNomPersonnage(configUtility.getInfo("sorcier_Personnage"));
        builder.setLevel(Integer.parseInt( configUtility.getInfo("levelDebut.s")));
        builder.setLevelMax(Integer.parseInt( configUtility.getInfo("levelMax.s")));
        builder.setHp_max(Integer.parseInt( configUtility.getInfo("hpMax.s")));
        builder.setHp_courant(Integer.parseInt(configUtility.getInfo("hpCourant.s")));
        builder.setManaMax(Integer.parseInt(configUtility.getInfo("manaMax.s")));
        builder.setManaCourant(Integer.parseInt(configUtility.getInfo("manaCourant.s")));
        builder.setDegatPersonnage(Integer.parseInt(configUtility.getInfo("degat.s")));
        builder.setExpMax(Integer.parseInt(configUtility.getInfo("expMax.s")));
        builder.setExpCourant(Integer.parseInt(configUtility.getInfo("expCourant.s")));
        builder.setCrier_de_guerre(configUtility.getInfo("crierDeGuerre.s"));
        builder.setForce(Integer.parseInt(configUtility.getInfo("force.s")));
        builder.setDexterite(Integer.parseInt(configUtility.getInfo("dexterite.s")));
        builder.setConstitution(Integer.parseInt(configUtility.getInfo("constitution.s")));
        builder.setIntelligence(Integer.parseInt(configUtility.getInfo("intelligence.s")));
        builder.setDameSkill1(Integer.parseInt(configUtility.getInfo("dameSkill.s")));
        builder.setManaSkill1(Integer.parseInt(configUtility.getInfo("manaSkill1.s")));
        builder.setSkill1(configUtility.getInfo("skill1.s"));
        builder.setDameSkill2(Integer.parseInt(configUtility.getInfo("dameSkill2.s")));
        builder.setManaSkill2(Integer.parseInt(configUtility.getInfo("manaSkill2.s")));
        builder.setSkill2(configUtility.getInfo("skill2.s"));
    }

    public void constructorCavernes(PBuilder builder){
        builder.setNomPersonnage(configUtility.getInfo("cavernes_Personnage"));
        builder.setLevel(Integer.parseInt( configUtility.getInfo("levelDebut.c")));
        builder.setLevelMax(Integer.parseInt( configUtility.getInfo("levelMax.c")));
        builder.setHp_max(Integer.parseInt( configUtility.getInfo("hpMax.c")));
        builder.setHp_courant(Integer.parseInt(configUtility.getInfo("hpCourant.c")));
        builder.setManaMax(Integer.parseInt(configUtility.getInfo("manaMax.c")));
        builder.setManaCourant(Integer.parseInt(configUtility.getInfo("manaCourant.c")));
        builder.setDegatPersonnage(Integer.parseInt(configUtility.getInfo("degat.c")));
        builder.setExpMax(Integer.parseInt(configUtility.getInfo("expMax.c")));
        builder.setExpCourant(Integer.parseInt(configUtility.getInfo("expCourant.c")));
        builder.setCrier_de_guerre(configUtility.getInfo("crierDeGuerre.c"));
        builder.setForce(Integer.parseInt(configUtility.getInfo("force.c")));
        builder.setDexterite(Integer.parseInt(configUtility.getInfo("dexterite.c")));
        builder.setConstitution(Integer.parseInt(configUtility.getInfo("constitution.c")));
        builder.setIntelligence(Integer.parseInt(configUtility.getInfo("intelligence.c")));
        builder.setDameSkill1(Integer.parseInt(configUtility.getInfo("dameSkill.c")));
        builder.setManaSkill1(Integer.parseInt(configUtility.getInfo("manaSkill1.c")));
        builder.setSkill1(configUtility.getInfo("skill1.c"));
        builder.setDameSkill2(Integer.parseInt(configUtility.getInfo("dameSkill2.c")));
        builder.setManaSkill2(Integer.parseInt(configUtility.getInfo("manaSkill2.c")));
        builder.setSkill2(configUtility.getInfo("skill2.c"));
    }
}

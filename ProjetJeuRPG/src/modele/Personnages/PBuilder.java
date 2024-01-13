package modele.Personnages;

public interface PBuilder {

    public void setNomPersonnage(String nomPersonnage);

    public void setHp_max(int hp_max);

    public void setHp_courant(int hp_courant);

    public void setManaMax(int manaMax);

    public void setManaCourant(int manaCourant);

    public void setExpMax(int expMax);

    public void setExpCourant(int expCourant);

    public void setLevel(int level);

    public void setLevelMax(int levelMax);

    public void setDegatPersonnage(int degat_joueur);

    public void setCrier_de_guerre(String crier_de_guerre);

    public void setForce(int force);

    public void setCompetance(String competance);

    public void setDexterite(int dexterite);

    public void setConstitution(int constitution);

    public void setIntelligence(int intelligence);

    public void setSkill1(String nomSkill);

    public void setSkill2(String nomSkill2);

    public void setDameSkill1(int dameSkill1);

    public void setDameSkill2(int dameSkill2);

    public void setManaSkill1(int manaSkill1);

    public void setManaSkill2(int manaSkill2);


}

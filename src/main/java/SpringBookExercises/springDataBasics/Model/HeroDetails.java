package SpringBookExercises.springDataBasics.Model;

import java.util.List;

public class HeroDetails {

    private int id;
    private String name;
    private String localizedName;
    private String primaryAttr;
    private String attackType;
    private List<String> roles;

    private int baseHealth;
    private int baseMana;
    private double baseArmor;
    private int baseAttackMin;
    private int baseAttackMax;
    private int baseStr;
    private int baseAgi;
    private int baseInt;
    private int moveSpeed;
    private int attackRange;
    private int proPick;
    private int proWin;
    private int turboPicks;
    private int turboWins;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocalizedName() { return localizedName; }
    public void setLocalizedName(String localizedName) { this.localizedName = localizedName; }

    public String getPrimaryAttr() { return primaryAttr; }
    public void setPrimaryAttr(String primaryAttr) { this.primaryAttr = primaryAttr; }

    public String getAttackType() { return attackType; }
    public void setAttackType(String attackType) { this.attackType = attackType; }

    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }

    public int getBaseHealth() { return baseHealth; }
    public void setBaseHealth(int baseHealth) { this.baseHealth = baseHealth; }

    public int getBaseMana() { return baseMana; }
    public void setBaseMana(int baseMana) { this.baseMana = baseMana; }

    public double getBaseArmor() { return baseArmor; }
    public void setBaseArmor(double baseArmor) { this.baseArmor = baseArmor; }

    public int getBaseAttackMin() { return baseAttackMin; }
    public void setBaseAttackMin(int baseAttackMin) { this.baseAttackMin = baseAttackMin; }

    public int getBaseAttackMax() { return baseAttackMax; }
    public void setBaseAttackMax(int baseAttackMax) { this.baseAttackMax = baseAttackMax; }

    public int getBaseStr() { return baseStr; }
    public void setBaseStr(int baseStr) { this.baseStr = baseStr; }

    public int getBaseAgi() { return baseAgi; }
    public void setBaseAgi(int baseAgi) { this.baseAgi = baseAgi; }

    public int getBaseInt() { return baseInt; }
    public void setBaseInt(int baseInt) { this.baseInt = baseInt; }

    public int getMoveSpeed() { return moveSpeed; }
    public void setMoveSpeed(int moveSpeed) { this.moveSpeed = moveSpeed; }

    public int getAttackRange() { return attackRange; }
    public void setAttackRange(int attackRange) { this.attackRange = attackRange; }

    public int getProPick() { return proPick; }
    public void setProPick(int proPick) { this.proPick = proPick; }

    public int getProWin() { return proWin; }
    public void setProWin(int proWin) { this.proWin = proWin; }

    public int getTurboPicks() { return turboPicks; }
    public void setTurboPicks(int turboPicks) { this.turboPicks = turboPicks; }

    public int getTurboWins() { return turboWins; }
    public void setTurboWins(int turboWins) { this.turboWins = turboWins; }
}

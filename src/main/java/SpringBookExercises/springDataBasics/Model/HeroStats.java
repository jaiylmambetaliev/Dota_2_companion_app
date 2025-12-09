package SpringBookExercises.springDataBasics.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroStats {

    private int id;
    private String name;

    @JsonProperty("localized_name")
    private String localizedName;

    @JsonProperty("primary_attr")
    private String primaryAttr;

    @JsonProperty("attack_type")
    private String attackType;

    private String img;
    private String icon;

    @JsonProperty("base_health")
    private int baseHealth;

    @JsonProperty("base_mana")
    private int baseMana;

    @JsonProperty("base_armor")
    private double baseArmor;

    @JsonProperty("base_attack_min")
    private int baseAttackMin;

    @JsonProperty("base_attack_max")
    private int baseAttackMax;

    @JsonProperty("base_str")
    private int baseStr;

    @JsonProperty("base_agi")
    private int baseAgi;

    @JsonProperty("base_int")
    private int baseInt;

    @JsonProperty("move_speed")
    private int moveSpeed;

    @JsonProperty("attack_range")
    private int attackRange;

    @JsonProperty("pro_pick")
    private int proPick;

    @JsonProperty("pro_win")
    private int proWin;

    @JsonProperty("turbo_picks")
    private int turboPicks;

    @JsonProperty("turbo_wins")
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

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

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

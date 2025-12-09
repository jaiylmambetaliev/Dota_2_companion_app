package SpringBookExercises.springDataBasics.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("HERO_STATS")
public class HeroStatsEntity implements Persistable<Integer> {

    @Id
    private Integer id;          // same as HERO.ID

    private String name;
    private String localizedName;
    private String primaryAttr;
    private String attackType;

    private Integer baseHealth;
    private Integer baseMana;
    private Double baseArmor;
    private Integer baseAttackMin;
    private Integer baseAttackMax;
    private Integer baseStr;
    private Integer baseAgi;
    private Integer baseInt;

    private Integer moveSpeed;
    private Integer attackRange;

    private Integer proPick;
    private Integer proWin;
    private Integer turboPicks;
    private Integer turboWins;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return true;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocalizedName() { return localizedName; }
    public void setLocalizedName(String localizedName) { this.localizedName = localizedName; }

    public String getPrimaryAttr() { return primaryAttr; }
    public void setPrimaryAttr(String primaryAttr) { this.primaryAttr = primaryAttr; }

    public String getAttackType() { return attackType; }
    public void setAttackType(String attackType) { this.attackType = attackType; }

    public Integer getBaseHealth() { return baseHealth; }
    public void setBaseHealth(Integer baseHealth) { this.baseHealth = baseHealth; }

    public Integer getBaseMana() { return baseMana; }
    public void setBaseMana(Integer baseMana) { this.baseMana = baseMana; }

    public Double getBaseArmor() { return baseArmor; }
    public void setBaseArmor(Double baseArmor) { this.baseArmor = baseArmor; }

    public Integer getBaseAttackMin() { return baseAttackMin; }
    public void setBaseAttackMin(Integer baseAttackMin) { this.baseAttackMin = baseAttackMin; }

    public Integer getBaseAttackMax() { return baseAttackMax; }
    public void setBaseAttackMax(Integer baseAttackMax) { this.baseAttackMax = baseAttackMax; }

    public Integer getBaseStr() { return baseStr; }
    public void setBaseStr(Integer baseStr) { this.baseStr = baseStr; }

    public Integer getBaseAgi() { return baseAgi; }
    public void setBaseAgi(Integer baseAgi) { this.baseAgi = baseAgi; }

    public Integer getBaseInt() { return baseInt; }
    public void setBaseInt(Integer baseInt) { this.baseInt = baseInt; }

    public Integer getMoveSpeed() { return moveSpeed; }
    public void setMoveSpeed(Integer moveSpeed) { this.moveSpeed = moveSpeed; }

    public Integer getAttackRange() { return attackRange; }
    public void setAttackRange(Integer attackRange) { this.attackRange = attackRange; }

    public Integer getProPick() { return proPick; }
    public void setProPick(Integer proPick) { this.proPick = proPick; }

    public Integer getProWin() { return proWin; }
    public void setProWin(Integer proWin) { this.proWin = proWin; }

    public Integer getTurboPicks() { return turboPicks; }
    public void setTurboPicks(Integer turboPicks) { this.turboPicks = turboPicks; }

    public Integer getTurboWins() { return turboWins; }
    public void setTurboWins(Integer turboWins) { this.turboWins = turboWins; }
}

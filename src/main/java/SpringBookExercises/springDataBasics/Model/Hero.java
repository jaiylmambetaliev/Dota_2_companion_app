package SpringBookExercises.springDataBasics.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Hero {
    private int id;
    private String name;

    @JsonProperty("localized_name")
    private String localizedName;

    @JsonProperty("primary_attr")
    private String primaryAttr;

    @JsonProperty("attack_type")
    private String attackType;

    private List<String> roles;

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
}


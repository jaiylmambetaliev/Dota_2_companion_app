package SpringBookExercises.springDataBasics.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("HERO")
public class HeroEntity implements Persistable<Integer> {

    @Id
    private Integer id;

    private String name;

    private String localizedName;

    private String primaryAttr;

    private String attackType;

    private String roles;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getPrimaryAttr() {
        return primaryAttr;
    }

    public void setPrimaryAttr(String primaryAttr) {
        this.primaryAttr = primaryAttr;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}

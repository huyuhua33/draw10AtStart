package draw10AtStart;

public class skill {
    private String skillName;
    private String skillType;
    private int skillPow;

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public int getSkillPow() {
        return skillPow;
    }

    public void setSkillPow(int skillPow) {
        this.skillPow = skillPow;
    }

    @Override
    public String toString() {
        return "skill [skillName=" + skillName + ", skillPow=" + skillPow + ", skillType=" + skillType + "]";
    }

    public skill(String skillName, String skillType, int skillPow) {
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillPow = skillPow;
    }

}

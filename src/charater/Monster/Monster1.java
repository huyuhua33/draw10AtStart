package charater.Monster;

import charater.skill;
import charater.Player.pet;

public class Monster1 extends pet {
    skill[] skillInfo = { new skill("A", "A", 10), new skill("AB", "A", 50), new skill("C", "H", 10),
            new skill("D", "R", 10) };

    public Monster1(String name) {
        super(name, 100, 20, 30, 40, 50);
        super.sourceFIle = new String("\\monster\\Monster1.jpg");
        askill();
    }

    @Override
    public void askill() {
        for (skill i : skillInfo) {
            super.skillList.add(i);
        }
    }

    public skill[] getSkillInfo() {
        return skillInfo;
    }

    public void setSkillInfo(skill[] skillInfo) {
        this.skillInfo = skillInfo;
    }

}

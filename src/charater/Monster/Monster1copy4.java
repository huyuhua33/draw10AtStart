package charater.Monster;

import charater.skill;
import charater.Player.pet;

public class Monster1copy4 extends pet {

    skill[] skillInfo = { new skill("AAAAAA", "A", 10), new skill("ABBBBB", "A", 70), new skill("CCCC", "H", 10),
            new skill("DDDD", "R", 10) };

    public Monster1copy4(String name) {
        super(name, 100, 50, 50, 50, 50);
        super.sourceFIle = new String("\\monster\\Monster1copy4.jpg");
        askill();
    }

    @Override
    public void askill() {
        for (skill i : skillInfo) {
            super.skillList.add(i);
        }
    }

}

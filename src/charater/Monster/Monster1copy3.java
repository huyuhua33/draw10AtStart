package charater.Monster;

import charater.skill;
import charater.Player.pet;

public class Monster1copy3 extends pet {

    skill[] skillInfo = { new skill("AAAA", "A", 10), new skill("ABBBB", "A", 50), new skill("CCCCC", "H", 25),
            new skill("DDDDD", "R", 10) };

    public Monster1copy3(String name) {
        super(name, 100, 50, 50, 50, 50);
        askill();
        super.sourceFIle = new String("\\monster\\Monster1copy3.jpg");
    }

    @Override
    public void askill() {
        for (skill i : skillInfo) {
            super.skillList.add(i);
        }
    }

}

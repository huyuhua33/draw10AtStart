package charater.Monster;

import charater.skill;
import charater.Player.pet;

public class Monster1copy2 extends pet {

    skill[] skillInfo = { new skill("AAA", "A", 10), new skill("ABBB", "A", 50), new skill("CCC", "H", 19),
            new skill("DDDD", "R", 20) };

    public Monster1copy2(String name) {
        super(name, 100, 50, 50, 50, 50);
        super.sourceFIle = new String("\\monster\\Monster1copy2.jpg");

        askill();
    }

    @Override
    public void askill() {
        for (skill i : skillInfo) {
            super.skillList.add(i);
        }
    }

}

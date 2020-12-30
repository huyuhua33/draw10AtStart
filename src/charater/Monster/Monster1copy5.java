package charater.Monster;

import charater.skill;
import charater.Player.pet;

public class Monster1copy5 extends pet {

    skill[] skillInfo = { new skill("AAAA", "A", 10), new skill("AB", "A", 50), new skill("CCCCC", "H", 25),
            new skill("DDDDDD", "R", 7) };

    public Monster1copy5(String name) {
        super(name, 50, 50, 50, 50, 50);
        super.sourceFIle = new String("\\monster\\Monster1copy5.jpg");
        askill();
    }

    @Override
    public void askill() {
        for (skill i : skillInfo) {
            super.skillList.add(i);
        }
    }

}

package charater.Monster;

import charater.skill;
import charater.Player.pet;

public class Monster1copycat extends pet {

    skill[] skillInfo = { new skill("AAAAAAAAA", "A", 1), new skill("UDLRBA", "A", 999), new skill("CCCC", "H", 999),
            new skill("DDDD", "R", 999) };

    public Monster1copycat(String name) {
        super(name, 100, 50, 50, 50, 50);
        super.sourceFIle = new String("\\monster\\Monster1copycat.jpg");
        askill();
    }

    @Override
    public void askill() {
        for (skill i : skillInfo) {
            super.skillList.add(i);
        }
    }

}

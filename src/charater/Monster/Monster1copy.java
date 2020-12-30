package charater.Monster;

import charater.skill;
import charater.Player.pet;

public class Monster1copy extends pet {

    skill[] skillInfo = { new skill("AA", "A", 20), new skill("ABB", "A", 40), new skill("CC", "H", 20),
            new skill("DDDD", "R", 15) };

    public Monster1copy(String name) {
        super(name, 100, 50, 50, 50, 50);
        super.sourceFIle = new String("\\monster\\Monster1copy.jpg");
        askill();
    }

    @Override
    public void askill() {
        for (skill i : skillInfo) {
            super.skillList.add(i);
        }
    }

}

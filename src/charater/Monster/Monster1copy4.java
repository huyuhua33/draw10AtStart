package charater.Monster;

import charater.Player.pet;
import charater.Player.skill;

public class Monster1copy4 extends pet {

    skill[] skillInfo = { new skill("AAAAAA", "A", 10), new skill("ABBBBB", "A", 70), new skill("CCCC", "H", 10),
            new skill("DDDD", "R", 10) };

    public Monster1copy4(String name, int life_MAX, int attack, int defend, int speed, double miss) {
        super(name, life_MAX, attack, defend, speed, miss);
        askill();
    }

    @Override
    public void askill() {
        for (skill i : skillInfo) {
            super.skillList.add(i);
        }
    }

}

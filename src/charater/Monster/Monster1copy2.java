package charater.Monster;

import charater.Player.pet;
import charater.Player.skill;

public class Monster1copy2 extends pet {

    skill[] skillInfo = { new skill("AAA", "A", 10), new skill("ABBB", "A", 50), new skill("CCC", "H", 19),
            new skill("DDDD", "R", 20) };

    public Monster1copy2(String name, int life_MAX, int attack, int defend, int speed, double miss) {
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

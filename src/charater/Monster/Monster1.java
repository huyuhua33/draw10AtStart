package charater.Monster;

import charater.skill;
import charater.Player.pet;

public class Monster1 extends pet {

    skill[] skillInfo = { new skill("A", "A", 10), new skill("AB", "A", 50), new skill("C", "H", 10),
            new skill("D", "R", 10) };

    public Monster1(String name, int life_MAX, int attack, int defend, int speed, double miss) {
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

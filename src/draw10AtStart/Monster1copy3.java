//package draw10AtStart;

public class Monster1copy3 extends pet {

    skill[] skillInfo = { new skill("AAAA", "A", 10), new skill("ABBBB", "A", 50), new skill("CCCCC", "H", 25),
            new skill("DDDDD", "R", 10) };

    public Monster1copy3(String name, int life_MAX, int attack, int defend, int speed, double miss) {
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

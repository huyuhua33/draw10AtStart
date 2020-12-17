//package draw10AtStart;

public class Monster1copycat extends pet {

    skill[] skillInfo = { new skill("AAAAAAAAA", "A", 1), new skill("UDLRBA", "A", 999), new skill("CCCC", "H", 999),
            new skill("DDDD", "R", 999) };

    public Monster1copycat(String name, int life_MAX, int attack, int defend, int speed, double miss) {
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

//package draw10AtStart;

public class Monster1copy extends pet {

    skill[] skillInfo = { new skill("AA", "A", 20), new skill("ABB", "A", 40), new skill("CC", "H", 20),
            new skill("DDDD", "R", 15) };

    public Monster1copy(String name, int life_MAX, int attack, int defend, int speed, double miss) {
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

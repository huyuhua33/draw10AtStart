package ClientServer;

public class Data_frame {
    private int hp;
    private int speed;
    private String name;
    private char act_type;
    private int act_num;
    private String act_name;
    private int armor;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getAct_type() {
        return act_type;
    }

    public void setAct_type(char act_type) {
        this.act_type = act_type;
    }

    public int getAct_num() {
        return act_num;
    }

    public void setAct_num(int act_num) {
        this.act_num = act_num;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public Data_frame(int hp, int speed, String name, char act_type, int act_num, String act_name, int r) {
        this.hp = hp;
        this.speed = speed;
        this.name = name;
        this.act_type = act_type;
        this.act_num = act_num;
        this.act_name = act_name;
        this.armor = r;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Data_frame [act_name=" + act_name + ", act_num=" + act_num + ", act_type=" + act_type + ", armor="
                + armor + ", hp=" + hp + ", name=" + name + ", speed=" + speed + "]";
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

}
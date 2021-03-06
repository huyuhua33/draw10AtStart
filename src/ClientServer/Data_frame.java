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
        System.out.println(this);
    }

    public Data_frame(String data) {
        String[] sc1Data = data.split("/");
        this.hp = Integer.parseInt(sc1Data[0]);
        this.speed = Integer.parseInt(sc1Data[1]);
        this.name = sc1Data[2];
        this.act_type = sc1Data[3].charAt(0);
        this.act_num = Integer.parseInt(sc1Data[4]);
        this.act_name = sc1Data[5];
        this.armor = Integer.parseInt(sc1Data[6].trim());
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Data_frame [act_name=" + act_name + ", act_num=" + String.valueOf(act_num) + ", act_type=" + act_type
                + ", armor=" + String.valueOf(armor) + ", hp=" + String.valueOf(hp) + ", name=" + name + ", speed="
                + String.valueOf(speed) + "]";
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Data_frame() {
    }

}
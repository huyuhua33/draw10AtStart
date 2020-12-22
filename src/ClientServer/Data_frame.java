package ClientServer;

public class Data_frame
{
    private int    hp;
    private int    speed;
    private String  name;
    private String   act_type;
    private int    act_num;

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

    public String getAct_type() {
        return act_type;
    }

    public void setAct_type(String act_type) {
        this.act_type = act_type;
    }

    public int getAct_num() {
        return act_num;
    }

    public void setAct_num(int act_num) {
        this.act_num = act_num;
    }

    public Data_frame(int hp, int speed, String name, String act_type, int act_num) {
        this.hp = hp;
        this.speed = speed;
        this.name = name;
        this.act_type = act_type;
        this.act_num = act_num;
    }

}
//package draw10AtStart;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private String name;
    private String password;
    private ArrayList<pet> pets;

    // private ArrayList<Pet> pets;
    public Player(String name, String passwd) {
        this.name = name;
        this.password = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        String n = new String(password);
        return n;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", password=" + password + "]";
    }

}

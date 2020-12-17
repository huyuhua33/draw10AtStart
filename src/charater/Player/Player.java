package charater.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class Player {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    private ArrayList<pet> pets;

    // private ArrayList<Pet> pets;
    public Player(String name, String passwd) {
        this.name = name;
        this.password = passwd;
        pets = new ArrayList<pet>();
        getRdPets();
    }

    public void getRdPets() {
        pets.add(new Monster1("AA", 50, 10, 10, 10, 10));
        pets.add(new Monster1copy("BB", 52, 10, 10, 10, 10));
        pets.add(new Monster1copy3("CC", 53, 3, 10, 10, 10));
        pets.add(new Monster1copy2("DD", 55, 20, 10, 10, 10));
        pets.add(new Monster1copy4("EE", 59, 40, 10, 10, 10));
        pets.add(new Monster1copy5("FF", 60, 51, 10, 10, 10));
        pets.add(new Monster1copy("GG", 30, 30, 10, 10, 10));
        pets.add(new Monster1("HH", 90, 82, 10, 10, 10));
        pets.add(new Monster1copycat("II", 10, 65, 10, 10, 10));
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ArrayList<pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<pet> pets) {
        this.pets = pets;
    }

}

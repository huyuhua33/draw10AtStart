package charater.Player;

import java.util.ArrayList;
import java.util.Random;

import charater.Monster.Monster1;
import charater.Monster.Monster1copy;
import charater.Monster.Monster1copy2;
import charater.Monster.Monster1copy3;
import charater.Monster.Monster1copy4;
import charater.Monster.Monster1copy5;
import charater.Monster.Monster1copycat;

public class Player {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    private ArrayList<pet> randPets = new ArrayList<pet>();
    private ArrayList<pet> pets;

    // private ArrayList<Pet> pets;
    public Player(String name, String passwd) {
        this.name = name;
        this.password = passwd;
        pets = new ArrayList<pet>();
        RdPets();
    }

    private void RdPets() {
        randPets.add(new Monster1("AA"));
        randPets.add(new Monster1copy("BB"));
        randPets.add(new Monster1copy3("CC"));
        randPets.add(new Monster1copy2("DD"));
        randPets.add(new Monster1copy4("EE"));
        randPets.add(new Monster1copy5("FF"));
        randPets.add(new Monster1copy("GG"));
        randPets.add(new Monster1("HH"));
        randPets.add(new Monster1copycat("II"));
    }

    public void get10RdPets() {

        for (int i = 0; i < pets.size() - 1; i++) {
            pets.remove(pets.get(0));
        }
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int result = r.nextInt(randPets.size() - 1);
            pets.add(randPets.get(result));
        }
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

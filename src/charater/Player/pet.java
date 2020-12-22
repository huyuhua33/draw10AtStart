package charater.Player;

import java.io.Serializable;
import java.util.ArrayList;

import charater.skill;

public class pet implements Serializable {
	String name = "pet"; // name
	int life_MAX = 0; // max hp
	int life = 0; // hp
	int attack = 0; // atk
	int defend = 0; // shild
	int speed = 0; // speed
	double miss = 0; // hit or miss
	boolean alive = true;
	public ArrayList<skill> skillList;

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefend() {
		return defend;
	}

	public void setDefend(int defend) {
		this.defend = defend;
	}

	public double getMiss() {
		return miss;
	}

	public void setMiss(double miss) {
		this.miss = miss;
	}

	public void fight(int attack) // when got attack
	{
		int hurt = 0; // got dmg
		int residue_life; // life left
		if (die()) // get die() function
		{
			if (defend != 0) // if enemy atk > shild : get hert
			{
				hurt = attack - defend;
				if (hurt < 0)
					hurt = 0;
				defend = defend - attack;
			}
			residue_life = life - hurt; // count hp left
			System.out.println(this.name + "got " + hurt + " damage");// print atk got
			if (residue_life < 0)
				residue_life = 0;
			System.out.println("still have " + residue_life + " hp left"); // print hp left
			life = residue_life; // life left
		}
	}

	public void heal(int h) // Healing
	{
		life += h;
		if (life > life_MAX)
			life = life_MAX;
		System.out.println("Heal: " + h);
		System.out.println(name + " " + life + " hp left");

	}

	public void armerUp(int r) // Healing
	{
		defend += r;
		System.out.println("armerUp: " + r);
		System.out.println(name + " " + defend + " arm left");
	}

	// checking it is die or not, bolean
	public boolean die() {
		boolean flag = true; // init to true: alive
		if (life <= 0) { // if hp < 0 : dead
			System.out.println(this.name + " die");
			flag = false;
		}
		alive = false;
		return flag; // got boolean
	}

	public void dodge()// miss counting
	{
		System.out.println("not hit," + this.name + " dodged");
	}

	public pet(String name, int life_MAX, int attack, int defend, int speed, double miss) {
		this.name = name;
		this.life_MAX = life_MAX;
		this.life = life_MAX;
		this.attack = attack;
		this.defend = defend;
		this.speed = speed;
		this.miss = miss;
		this.skillList = new ArrayList<skill>();
	}

	public void askill() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLife_MAX() {
		return life_MAX;
	}

	public void setLife_MAX(int life_MAX) {
		this.life_MAX = life_MAX;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public ArrayList<skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(ArrayList<skill> skillList) {
		this.skillList = skillList;
	};
}
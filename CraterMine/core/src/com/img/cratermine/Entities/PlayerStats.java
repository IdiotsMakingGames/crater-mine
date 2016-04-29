package com.img.cratermine.Entities;
import java.util.Random;

public class PlayerStats {
	private static int attack = 1;
	private static int gold;
	private static int minerals;
	
	void setAtributes(int attack, int gold, int minerals){
		this.attack = attack;
		this.gold = gold;
		this.minerals = minerals;
	}
	
	
	static int getAttack(){
		return attack;
	}
	
	public static int getMinerals(){
		return minerals;
	}
	
	static void addGold(int addGold){
		gold += addGold;
	}
	
	static void addMinerals(int addMinerals){
		minerals += addMinerals;
	}
	
	
	public static int getGold(){
		return gold;
	}
	
	static void chanceToGetMinerals(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if(randomInt <= 20){
			minerals++;
		}
	}

}


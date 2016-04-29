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
	
	static void addGold(int addedGold){
		gold += addedGold;
	}
	
	public static int getGold(){
		return gold;
	}
	
	static void chanceToGetMinerals(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if(randomInt <= 1){
			minerals++;
		}
	}

}


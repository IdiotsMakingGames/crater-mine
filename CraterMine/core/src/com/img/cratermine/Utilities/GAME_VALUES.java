package com.img.cratermine.Utilities;
import java.util.Random;

public class GAME_VALUES {

	private static int attack   = 0;
	private static int gold     = 0;
	private static int minerals = 0;
	
	public static void setAtributes(int attack, int gold, int minerals){
		GAME_VALUES.attack = attack;
		GAME_VALUES.gold = gold;
		GAME_VALUES.minerals = minerals;
	}

	public static int getAttack(){
		return attack;
	}
	
	public static int getMinerals(){
		return minerals;
	}

	public static int getGold(){
		return gold;
	}
	
	public static void addGold(int addGold){
		gold += addGold;
	}
	
	public static void addMinerals(int addMinerals){
		minerals += addMinerals;
	}

}
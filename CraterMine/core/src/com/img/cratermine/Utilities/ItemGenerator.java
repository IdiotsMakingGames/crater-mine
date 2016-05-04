package com.img.cratermine.Utilities;

import java.util.Random;

/**
 * Created by Valen on 03/05/2016.
 */
public class ItemGenerator {
//	 private static final Random random = new Random();
	
	public enum battleMod{
		flatAttDmg(100,150), // Daño fisico (en numero)
		porAttDmg(20,40); // Daño fisico porcentual
		
		private int minValue;
		private int maxValue;
		
		private battleMod (int minValue, int maxValue){
			this.minValue = minValue;
			this.maxValue = maxValue;
		}
		
		public int getMinValue() {
			return minValue;
		}	
		public int getMaxValue() {
			return maxValue;
		}
	}
	
	public enum farmMod{
		goldGen(100,170),    // Generacion de oro porcentual
		minGen(120,180),     // Generacion de minerales porcentual
		jewGen(60,100),     // Generacion de joyas porcentual
		allGen(30,50);      // Generacion de todos los recursos porcentual
		private int minValue;
		private int maxValue;
		
		private farmMod (int minValue, int maxValue){
			this.minValue = minValue;
			this.maxValue = maxValue;
		}
		
		public int getMinValue() {
			return minValue;
		}	
		public int getMaxValue() {
			return maxValue;
		}
	}
	
	
	public enum rarity{
		common,
		rare,
		epic,
		legendary,
		ultimate;
	}

	
	public static Item generateItem(){
		battleMod bMod = randomBMod();
		farmMod fMod = randomFMod();
		int bValue =  new Random().nextInt(bMod.maxValue - bMod.minValue);
		bValue += bMod.minValue;
		int fValue =  new Random().nextInt(fMod.maxValue - fMod.minValue);
		fValue += fMod.minValue;
		Item item = new Item(bMod,bValue,fMod,fValue);
		return item;
		
		
	}
	 
	private static battleMod randomBMod() {
		    int random =  new Random().nextInt(battleMod.values().length);
		    return battleMod.values()[random];
	}
	 
	 
	private static farmMod randomFMod() {
		int random =  new Random().nextInt(farmMod.values().length);
		return farmMod.values()[random];
	}
	 
	public static rarity randomRarity() {
		int random =  new Random().nextInt(battleMod.values().length);
		return rarity.values()[random];
	}
}

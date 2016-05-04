package com.img.cratermine.Utilities;

import com.img.cratermine.Utilities.ItemGenerator.*;

public class Item {
	 public int bValue;
	 public int fValue;
	 public battleMod bMod;
	 public farmMod fMod; 
	 
	 public Item ( battleMod bMod ,int bValue,  farmMod fMod, int fValue) {
		 this.bMod = bMod;
		 this.bValue = bValue;
		 this.fMod = fMod;
		 this.fValue = fValue;
	    } 
}

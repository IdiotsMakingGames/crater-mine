package com.img.cratermine.Utilities;

import java.util.Random;

import com.img.cratermine.Utilities.ItemGenerator.battleMod;

public class PlanetGenerator {
	
	public enum prefix{
		om("Om"),
		el("El"),
		ir("Ir"),
		un("Un"),
		es("Es"),
		ig("Igg"),
		en("En"),
		al("Al"),
		ar("Ar");
		private String prefix;
		private prefix (String prefix){
			this.prefix = prefix;
		}
		public String getPrefix() {
			return prefix;
		}
	}
	public enum sufix{
		on("on"),
		ex("ex"),
		io("io"),
		ax("ax"),
		ae("ae"),
		us("us"),
		onia("onia"),
		aan("aan"),
		ant("ant"),
		is("is"),
		oe("oe");
		private String sufix;
		private sufix (String sufix){
			this.sufix = sufix;
		}
		public String getSufix() {
			return sufix;
		}	
	}
	public enum core{
		icr("icr"),
		acl("acl"),
		osan("osan"),
		quil("quil"),
		ber("ber"),
		ekk("ekk"),
		nas("nas"),
		rak("rak"),
		der("der");
		
		private String core;
		private core (String core){
			this.core = core;
		}
		public String getcore() {
			return core;
		}	
	}
	
	public static String generatePlanetName(){
		sufix sufix = randomSuffix();
		prefix prefix = randomPrefix();
		core core = randomCore();
		String planetName;
		planetName = prefix.getPrefix() + core.getcore() + sufix.getSufix();
		return planetName;
	}
	
	
	private static sufix randomSuffix() {
	    int random =  new Random().nextInt(sufix.values().length);
	    return sufix.values()[random];
}
	private static prefix randomPrefix() {
	    int random =  new Random().nextInt(prefix.values().length);
	    return prefix.values()[random];
}
	private static core randomCore() {
	    int random =  new Random().nextInt(core.values().length);
	    return core.values()[random];
}

}

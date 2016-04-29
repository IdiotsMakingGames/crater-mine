package com.img.cratermine.Entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.img.cratermine.CraterMine;

/**
 * Created by Gonza on 27/04/2016.
 */
public class Crater extends Actor {
	
	// Definir como va a funcionar el InputHandler
	private class CraterInputHandler extends InputListener {
		// como funciona: http://stackoverflow.com/questions/18154938/how-to-access-other-elements-in-click-listeners-in-libgdx
		private Crater crater;
		public CraterInputHandler(Crater crater) {
			this.crater = crater;
		}
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	        crater.health--;
	        if(crater.health == 0){
	        	PlayerStats.addGold(crater.goldToGive * 10);
	        	crater.health = 20;
	        }
	        PlayerStats.addGold(crater.goldToGive);
	        PlayerStats.chanceToGetMinerals();
	        return true;
	    }

	    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	        
	    }
	}
	
    private TextureRegion craterTexture;
    private static int health;
    private int damage;
    private int armor;
    private int goldToGive;
    
    public Crater(int health, int damage, int armor, int goldToGive) {
    	// Load variables
        craterTexture = new TextureRegion(new Texture("crater.png"));
        setX(  (CraterMine.V_WIDTH)/2 - craterTexture.getRegionWidth()/2 );
        setY(  (CraterMine.V_HEIGHT)/2 - craterTexture.getRegionHeight()/2 );
        setWidth(craterTexture.getRegionWidth());
        setHeight(craterTexture.getRegionHeight());
        this.health = health;
    	this.damage = damage;
    	this.armor = armor;
    	this.goldToGive = goldToGive;
    	// Load listeners
    	this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        this.addListener(new CraterInputHandler(this));
    }
    
    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(craterTexture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
    
    void craterExplode(){
    	PlayerStats.addGold(goldToGive * 10);
    	health = 10;
    	
    }
    public static int getHealth(){
    	return health;
    }
    
    
    
    
    
}
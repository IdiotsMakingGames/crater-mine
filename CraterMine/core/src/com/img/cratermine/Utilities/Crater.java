package com.img.cratermine.Utilities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.img.cratermine.CraterMine;

import java.util.Random;

/**
 * Created by Gonza on 27/04/2016.
 */
public class Crater extends Actor {
	
    private TextureRegion craterTexture;
    private int health;
    private int goldToGive;
    
    public Crater(int health, int goldToGive) {
    	// Load variables
        craterTexture = new TextureRegion(new Texture("crater.png"));
        setX(CraterMine.V_WIDTH / 2 - craterTexture.getRegionWidth() / 2);
        setY(CraterMine.V_HEIGHT / 2 - craterTexture.getRegionHeight() / 2);
        setWidth(craterTexture.getRegionWidth());
        setHeight(craterTexture.getRegionHeight());
        this.health = health;
    	this.goldToGive = goldToGive;
    	// Bounds & Listener
    	this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        this.addListener(new CraterInputHandler());
    }
    
    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(craterTexture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

	private boolean returnMinerals(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if(randomInt <= 20){
			return true;
		}
		return false;
	}

	// Definir como va a funcionar el InputHandler
	private class CraterInputHandler extends InputListener {
		// como funciona: http://stackoverflow.com/questions/18154938/how-to-access-other-elements-in-click-listeners-in-libgdx
		// ANOTACION: se pueden acceder a las variables de las outer classes desde una inner class, ya que como su nombre lo indica, esta clase esta dentro de la otra.
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
			health--;
			if(health == 0){
				GAME_VALUES.addGold(goldToGive * 10);
				health = 20;
			}
			GAME_VALUES.addGold(goldToGive);
			if (returnMinerals()) {
				GAME_VALUES.addMinerals(1);
			}
			return true;
		}

		public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

		}
	}
}
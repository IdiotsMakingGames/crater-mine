package com.img.cratermine.Screens.PlayScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.img.cratermine.CraterMine;
import com.img.cratermine.Utilities.GAME_VALUES;

import java.util.Random;

/**
 * Created by Gonza on 04/05/2016.
 */
public class Crater extends Group {

    private Image craterImage;
    private Label nameLabel;
    private Label healthLabel;
    private Image healthImage;
    private int currentHealth;
    private int maxHealth;
    private int goldToGive;

    public Crater(int health, int goldToGive) {
        // Instantiate & Load variables
        this.maxHealth = health;
        this.goldToGive = goldToGive;
        currentHealth = maxHealth;
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        craterImage = new Image(new Texture("crater.png"));
        nameLabel = new Label("PIRULIN", skin);
        healthLabel = new Label("Health: " + currentHealth, skin);
        healthImage = new Image(new Texture("healthColor.png"));
        // Configure Class  ############ Se puede utilizar la funcion "setBounds()" para poner los valores de X, Y, HEIGHT, WIDTH en una linea, pero es mas visible usando las 4 funciones siguientes.
        setX(CraterMine.V_WIDTH / 2 - craterImage.getWidth() / 2);
        setY(530 - craterImage.getHeight() / 2);
        setWidth(craterImage.getWidth());
        setHeight(craterImage.getHeight());
        this.addListener(new CraterInputHandler());
        // Set Position
        healthImage.setWidth(200);
        nameLabel.setPosition(this.getWidth() / 2 - nameLabel.getWidth() / 2, 25);
        healthLabel.setPosition(this.getWidth() / 2 - healthLabel.getWidth() / 2, 7);
        healthImage.setPosition(this.getWidth() / 2 - healthImage.getWidth() / 2, 0);
        // Load Group Actors
        addActor(craterImage);
        addActor(nameLabel);
        addActor(healthImage);
        addActor(healthLabel);
    }

    @Override
    public void act (float delta) {
        super.act(delta);
        healthImage.setWidth(currentHealth * 200 / maxHealth); // se puede usar tambien: (int)( (float) currentHealth / maxHealth * 200)
        healthLabel.setText("Health: " + currentHealth);
    }

    private boolean rollChanceMinerals(){
        int randomInt = new Random().nextInt(100);
        if(randomInt <= 20){
            return true;
        }
        return false;
    }

    private class CraterInputHandler extends InputListener {
        // como funciona: http://stackoverflow.com/questions/18154938/how-to-access-other-elements-in-click-listeners-in-libgdx
        // ANOTACION: se pueden acceder a las variables de las outer classes desde una inner class, ya que como su nombre lo indica, esta clase esta dentro de la otra.
        @Override
        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            // Change Scale
            float scale = 0.98f;
            craterImage.setScale(scale);
            craterImage.setPosition(getWidth() / 2 - craterImage.getWidth() / 2 * scale, getHeight() / 2 - craterImage.getHeight() / 2 * scale);
            // Change GAME_VALUES
            currentHealth -= GAME_VALUES.getAttack();
            if(currentHealth == 0){
                GAME_VALUES.addGold(goldToGive * 10);
                currentHealth = 20;
            }
            GAME_VALUES.addGold(goldToGive);
            if (rollChanceMinerals()) {
                GAME_VALUES.addMinerals(1);
            }
            return true;
        }
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            craterImage.setScale(1);
            craterImage.setPosition(0, 0);
        }
    }
}

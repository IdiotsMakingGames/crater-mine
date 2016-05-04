package com.img.cratermine.Utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by Gonza on 29/04/2016.
 */
public class Hud extends Table {

    Label goldLabel;
    Label mineralsLabel;

    public Hud() {
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        setFillParent(true); //size the root table to the stage
        goldLabel = new Label("Gold: ", skin);
        mineralsLabel = new Label("Minerals: ", skin);

        add(goldLabel);
        row();
        add(mineralsLabel);
    }

    @Override
    public void act (float delta) {
        super.act(delta);
        goldLabel.setText("Gold: " + GAME_VALUES.getGold());
        mineralsLabel.setText("Minerals: " + GAME_VALUES.getMinerals());
    }
}

package com.img.cratermine.Utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by Gonza on 29/04/2016.
 */
public class Hud {

    Table table;
    Label goldLabel;
    Label mineralsLabel;

    public Hud() {
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        table = new Table();
        table.setFillParent(true); //size the root table to the stage
        goldLabel = new Label("Gold: ", skin);
        mineralsLabel = new Label("Minerals: ", skin);

        table.add(goldLabel);
        table.row();
        table.add(mineralsLabel);
    }

    public void update() {
        goldLabel.setText("Gold: " + GAME_VALUES.getGold());
        mineralsLabel.setText("Minerals: " + GAME_VALUES.getMinerals());
    }

    public Actor getActor() {
        return table;
    }
}

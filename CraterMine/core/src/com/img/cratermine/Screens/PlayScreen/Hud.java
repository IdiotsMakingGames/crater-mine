package com.img.cratermine.Screens.PlayScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.img.cratermine.CraterMine;
import com.img.cratermine.Utilities.GAME_VALUES;

/**
 * Created by Gonza on 29/04/2016.
 */
public class Hud extends Group {

    private Table bottomHud;
    private Table topHud;

    private Label goldLabel;
    private Label mineralsLabel;

    public Hud() {
        Drawable background = new TextureRegionDrawable(new TextureRegion(new Texture("PlayScreen-HUD.png")));
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        goldLabel = new Label("Gold: ", skin);
        mineralsLabel = new Label("Minerals: ", skin);
        // Configure Top HUD
        topHud = new Table();
        topHud.setWidth(CraterMine.V_WIDTH);
        topHud.setHeight(50);
        topHud.setY(CraterMine.V_HEIGHT - topHud.getHeight());

        topHud.setBackground(background);
        // Configure Bottom HUD
        bottomHud = new Table();
        bottomHud.setWidth(CraterMine.V_WIDTH);
        bottomHud.setHeight(320);
        bottomHud.setY(0);

        bottomHud.setBackground(background);
        bottomHud.add(goldLabel);
        bottomHud.row();
        bottomHud.add(mineralsLabel);
        // Load Tables
        addActor(bottomHud);
        addActor(topHud);
    }

    @Override
    public void act (float delta) {
        super.act(delta);
        goldLabel.setText("Gold: " + GAME_VALUES.getGold());
        mineralsLabel.setText("Minerals: " + GAME_VALUES.getMinerals());
    }
}

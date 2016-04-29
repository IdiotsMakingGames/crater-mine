package com.img.cratermine.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.img.cratermine.CraterMine;
import com.img.cratermine.Entities.Crater;
import com.img.cratermine.Entities.PlayerStats;

/**
 * Created by Gonza on 27/04/2016.
 */
public class PlayScreen implements Screen {

    // ScreenManager
    private CraterMine craterMine;
    // Stage & Actors
    private Stage stage;
    private Crater crater;
    private Image background;
    private SpriteBatch batch;
    private BitmapFont  font;


    public PlayScreen(CraterMine craterMine) {
        this.craterMine = craterMine;
        // Instantiate Stage & Actors
        stage = new Stage(new StretchViewport(CraterMine.V_WIDTH, CraterMine.V_HEIGHT));
        Gdx.input.setInputProcessor(stage); //configura el inputprocessor que se va a utilizar o que va a manejar las entradas (mouse, teclado, touch)
        crater = new Crater(10, 10, 0, 1);
        background = new Image(new Texture("background.jpg"));
        // Load actors
        stage.addActor(background);
        stage.addActor(crater);
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        batch.begin();
        font.setColor(Color.YELLOW);
        font.draw(batch,"Gold:", 25, 160);
        font.draw(batch,  Integer.toString(PlayerStats.getGold()), 65, 160);
        font.setColor(Color.RED);
        font.draw(batch,"Health:", 25, 100);
        font.draw(batch,Integer.toString(Crater.getHealth()), 75, 100);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
        font.dispose();
    }
}

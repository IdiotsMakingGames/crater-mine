package com.img.cratermine.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.img.cratermine.CraterMine;
import com.img.cratermine.Utilities.Crater;
import com.img.cratermine.Utilities.Hud;

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
    private Hud hud;

    public PlayScreen(CraterMine craterMine) {
        this.craterMine = craterMine;
        // Instantiate Stage & Actors
        stage = new Stage(new StretchViewport(CraterMine.V_WIDTH, CraterMine.V_HEIGHT));
        Gdx.input.setInputProcessor(stage); //configura el inputprocessor que se va a utilizar o que va a manejar las entradas (mouse, teclado, touch)
        crater = new Crater(20, 10, 0, 1);
        background = new Image(new Texture("background.jpg"));
        hud = new Hud();
        // Load actors
        stage.addActor(background);
        stage.addActor(crater);
        stage.addActor(hud.getActor());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update();

        stage.act(delta);
        stage.draw();
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
    }
}

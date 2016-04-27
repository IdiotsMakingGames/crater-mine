package com.img.cratermine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.img.cratermine.Screens.PlayScreen;

public class CraterMine extends Game {

	public static final int V_WIDTH = 480;
	public static final int V_HEIGHT = 800;

	public SpriteBatch batch; // se recomienda usar un solo SpriteBatch por la cantidad de memoria que usa.

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this)); // setea la screen actual
	}

	@Override
	public void render () {
		super.render(); // renderiza la screen actual
	}
}

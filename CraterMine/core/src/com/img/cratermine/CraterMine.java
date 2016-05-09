package com.img.cratermine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.img.cratermine.Screens.PlayScreen.PlayScreen;
import com.img.cratermine.Utilities.GAME_VALUES;

public class CraterMine extends Game {

	public static final int V_WIDTH = 480;
	public static final int V_HEIGHT = 800;

	public SpriteBatch batch; // se recomienda usar un solo SpriteBatch por la cantidad de memoria que usa.

	@Override
	public void create () {
		GAME_VALUES.setAtributes(1, 0, 0); // Load saved stats
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this)); // setea la screen actual
	}

	@Override
	public void render () {
		super.render(); // renderiza la screen actual
	}
}

package com.img.cratermine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.img.cratermine.CraterMine;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Crater Mine v0.0 Alpha";
		config.width = CraterMine.V_WIDTH;
		config.height = CraterMine.V_HEIGHT;
		new LwjglApplication(new CraterMine(), config);
	}
}

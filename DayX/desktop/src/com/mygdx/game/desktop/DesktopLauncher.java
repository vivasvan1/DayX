package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.dayx;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = dayx.WIDTH;
		config.height = dayx.HEIGHT;
		config.title = dayx.TITLE;
		new LwjglApplication(new dayx(), config);
	}
}

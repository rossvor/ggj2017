package com.mysquid.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mysquid.game.MySquidGame;

public class DesktopLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

   		config.width = (80 + 30) * 11;
    	config.height = (24 + 8) * 22;
    	
    	config.addIcon("Tentacle-16.png", Files.FileType.Internal);
    	config.addIcon("Tentacle-32.png", Files.FileType.Internal);
    	config.addIcon("Tentacle-128.png", Files.FileType.Internal);
		config.title = "WaveGuide Global Game Jam Jan 2017";
    	new LwjglApplication(new MySquidGame(), config);
    }
}

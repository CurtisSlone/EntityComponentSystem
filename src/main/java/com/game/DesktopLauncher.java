package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.game.engine.SpaceRocks;

public class DesktopLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Bit Looter");
		config.setWindowedMode(800,800);

        Lwjgl3Application app = new Lwjgl3Application(new SpaceRocks(), config);

        Gdx.app = app;
    }
}
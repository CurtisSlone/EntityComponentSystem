package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.engine.systems.LocationSystem;
import com.game.engine.systems.RenderingSystem;

public class SpaceRocks extends Game {

    Batch batch;
    Texture space;
    Manager manager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        space = new Texture(Gdx.files.internal("assets/space.png"));
        manager = Manager.getInstance();
        manager.init(new RenderingSystem(), new LocationSystem());
    } 

    public void render(){

        // clear screen 
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(space,0,0);
        batch.end();
    }

}

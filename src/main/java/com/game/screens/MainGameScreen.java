package com.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.game.engine.Manager;
import com.game.engine.entities.Entity;
import com.game.engine.entities.EntityFactory;
import com.game.engine.entities.EntityFactory.EntityType;
import com.game.engine.systems.LocationSystem;
import com.game.engine.systems.RenderingSystem;

public class MainGameScreen implements Screen{

    private Batch batch;
    private Texture space;
    private Manager manager;
    private Entity _player;
    private ArrayList<Entity> rocks;


    public MainGameScreen(){
        batch = new SpriteBatch();
        space = new Texture(Gdx.files.internal("assets/space.png"));
        manager = Manager.getInstance();
        manager.init(new RenderingSystem(), new LocationSystem());
    }
    @Override
    public void show() {
        _player = EntityFactory.createEntity(EntityType.PLAYER);
        manager.setPlayer(_player);
       
    }

    @Override
    public void render(float delta) {
         // clear screen 
         Gdx.gl.glClearColor(0,0,0, 1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
         batch.begin();

         // Call update methods
         batch.draw(space,0,0);
         batch.end();
       
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resize'");
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pause'");
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resume'");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }


}

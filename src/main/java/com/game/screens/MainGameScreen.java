package com.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.Manager;
import com.game.engine.entities.Entity;
import com.game.engine.entities.EntityFactory;
import com.game.engine.entities.EntityFactory.EntityType;

public class MainGameScreen implements Screen {


    private Batch _batch;
    private Texture _space;
    private static Manager _manager;
    private static Entity _player;
    private static ArrayList<Entity> _rocks;
    private static final Vector2 _worldBounds = new Vector2(800,600);
    
    
    public MainGameScreen(){
        
        _manager = Manager.getInstance();
        _manager.init();
        _rocks = new ArrayList<>();

    }
    
    @Override
    public void show() {
        _manager.setWorldBounds(_worldBounds);
        _player = EntityFactory.createEntity(EntityType.PLAYER);
        
        for(int i = 0; i < 6; i++)
            _rocks.add(EntityFactory.createEntity(EntityType.ROCK));
        
        _manager.setPlayer(_player);
        _manager.setRocks(_rocks);

        _batch = new SpriteBatch();
        _space = new Texture(Gdx.files.internal("assets/space.png"));

    }

    @Override
    public void render(float delta) {
         // clear screen 
         Gdx.gl.glClearColor(0,0,0, 1);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
        _batch.begin();

         // Call update methods
        _batch.draw(_space,0,0);
        _manager.updateCurrentEntities(_batch, delta);
        _batch.end();
       
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }



}

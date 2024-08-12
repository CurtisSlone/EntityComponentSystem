package com.game.engine;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.game.engine.entities.Entity;
import com.game.engine.systems.LocationSystem;
import com.game.engine.systems.RenderingSystem;

public class Manager {

    public static Manager manager;

    private static RenderingSystem renderingSystem;
    private static LocationSystem locationSystem;
    private Entity _player;
    private ArrayList<Entity> rocks;

    public static Manager getInstance() {
        return new Manager();
    }

    public void init(){
        Manager.locationSystem = new LocationSystem();
        Manager.renderingSystem = new RenderingSystem();
    }

    public void setPlayer(Entity player){
        this._player = player;
    }

    public Entity getPlayer(){
        return this._player;
    }

    // Move To renderer system
    public void updateCurrentEntities( Batch batch, float delta){
        rocks.stream().forEach(ent -> ent.update(batch, delta));
    }
}

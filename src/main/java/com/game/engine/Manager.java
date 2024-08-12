package com.game.engine;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.game.engine.components.ControlComponent;
import com.game.engine.components.player.PlayerControlComponent;
import com.game.engine.entities.Entity;
import com.game.engine.systems.LocationSystem;
import com.game.engine.systems.RenderingSystem;

public class Manager {

    public static Manager manager;

    private static RenderingSystem renderingSystem;
    private static LocationSystem locationSystem;
    private Entity _player;
    private ArrayList<Entity> _rocks;

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
 
    public void setRocks(ArrayList<Entity> rocks){
        this._rocks = rocks;
    }

    // Move To renderer system
    public void updateCurrentEntities( Batch batch, float delta){
        _rocks.stream().forEach(ent -> ent.update(batch, delta));
    }

    public void printEntityIds(){
        _rocks.forEach(ent -> System.out.println(ent.getEntityId()));
        System.out.println(_player.getEntityId());
    }
}

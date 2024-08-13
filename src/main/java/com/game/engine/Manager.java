package com.game.engine;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.entities.Entity;
import com.game.engine.systems.LocationSystem;
import com.game.engine.systems.RenderingSystem;

public class Manager {

    public static Manager manager;

    private static RenderingSystem renderingSystem;
    private static LocationSystem locationSystem;
    private Entity _player;
    private ArrayList<Entity> _rocks;
    private Vector2 _worldBounds;


    public static Manager getInstance() {
        return new Manager();
    }

    public void init(){
        Manager.locationSystem = new LocationSystem();
        Manager.renderingSystem = new RenderingSystem();
    }

   

    // Move To renderer system
    public void updateCurrentEntities( Batch batch, float delta){
        _player.update(batch, delta);
        _rocks.stream().forEach(ent -> ent.update(batch, delta));
    }

    public void printEntityIds(){
        _rocks.forEach(ent -> System.out.println(ent.getEntityId()));
        System.out.println(_player.getEntityId());
    }

    /*
     * GETTERS
     */
    
     public Entity getPlayer(){
        return this._player;
    }
   

     /*
      * SETTERS
      */

      public void setPlayer(Entity player){
        this._player = player;
    }
 
    public void setRocks(ArrayList<Entity> rocks){
        this._rocks = rocks;
    }

    public void setWorldBounds(Vector2 worldBounds){
        this._worldBounds = worldBounds;
    }
}

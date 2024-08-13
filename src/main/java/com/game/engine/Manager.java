package com.game.engine;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.entities.Entity;
import com.game.engine.systems.CollisionSystem;

public class Manager {

    public static Manager manager;

    private static CollisionSystem _collisionSystem;
    private Entity _player;
    private ArrayList<Entity> _rocks;
    private Vector2 _worldBounds;


    public static Manager getInstance() {
        return new Manager();
    }

    public void init(){
        Manager._collisionSystem = CollisionSystem.getInstance();
    }

   

    // Move To renderer system
    public void updateCurrentEntities( Batch batch, float delta){
        _player.update(batch, delta);
        _rocks.forEach(ent -> ent.update(batch, delta));
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

     public int getRandom(int min, int max){
        Random random = new Random();
        return random.ints(min,max)
                .findFirst()
                .getAsInt();
    }
   
     /*
    * SETTERS
    */
    public void setRocksPositions(){
    _rocks.forEach(ent -> ent.getPhysicsComponent().setCurrentPosition(new Vector2(getRandom(50, 750), getRandom(50, 550))));
    }

    public void setEntityBounds(){
        _player.getPhysicsComponent().setWorldBounds(this._worldBounds);
        _rocks.forEach(ent->ent.getPhysicsComponent().setWorldBounds(_worldBounds));
    }

    public void setEntityDimensions(){

        _player.getGraphicsComponent().initDimensions();
        _player.getGraphicsComponent().shareDimension(_player.getPhysicsComponent());
        _player.getPhysicsComponent().setBoundaryPolygon(8);

        _rocks.forEach(ent-> ent.getGraphicsComponent().initDimensions());
        _rocks.forEach(ent -> ent.getGraphicsComponent().shareDimension(ent.getPhysicsComponent()));
        _rocks.forEach(ent -> ent.getPhysicsComponent().setBoundaryPolygon(8));
    }

    public void setPlayerPosition(Vector2 position){
        _player.getPhysicsComponent().setCurrentPosition(position);
    }

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

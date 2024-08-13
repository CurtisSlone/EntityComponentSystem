package com.game.engine.entities;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.game.engine.components.Component;
import com.game.engine.components.ControlComponent;
import com.game.engine.components.GraphicsComponent;
import com.game.engine.components.PhysicsComponent;
import com.game.engine.util.IdGenerator;
public class Entity {

    public static enum State {
        ALIVE,
        DESTROYED
    }



    private String entityId;
    private List<Component> _components;
    private ControlComponent _controlComponent;
    private PhysicsComponent _physicsComponent;
    private GraphicsComponent _graphicsComponent;



    public Entity(ControlComponent control, PhysicsComponent physics, GraphicsComponent graphicsComponent){
        _controlComponent = control;
        _physicsComponent = physics;
        _graphicsComponent = graphicsComponent;
        _components = new ArrayList<Component>();
        _components = List.of(control, physics, graphicsComponent);
        this.entityId = IdGenerator.generateIdString(8);  
    }

    public void update(Batch batch, float delta){
        _graphicsComponent.update(this, batch, delta);
        _controlComponent.update(this, delta);
        _physicsComponent.update(this, delta);
        
    }

    public void dispose(){
        _components.stream().forEach(Component::dispose);
    }


    public String getEntityId(){
        return this.entityId;
    }

    /*
     * Exposing component control
     */
    
     // Movement
     public void notifyLocationChange(){

     }

     /*
      * GETTERS
      */



      /*
       * SETTERS
       */

    
}

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
        this._graphicsComponent.shareDimension(this._physicsComponent);
    }

    public void update(Batch batch, float delta){
        _controlComponent.update(this, delta);
        _physicsComponent.update(this, delta);
        _graphicsComponent.update(this, batch, delta);
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


    /*
    * GETTERS
    */

    public PhysicsComponent getPhysicsComponent(){
        return this._physicsComponent;
    }

    public GraphicsComponent getGraphicsComponent(){
        return this._graphicsComponent;
    }

    /*
    * SETTERS
    */

    
}

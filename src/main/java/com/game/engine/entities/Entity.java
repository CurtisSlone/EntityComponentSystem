package com.game.engine.entities;

import java.util.ArrayList;
import java.util.List;

import com.game.engine.components.Component;
import com.game.engine.components.ControlComponent;
import com.game.engine.components.GraphicsComponent;
import com.game.engine.components.PhysicsComponent;
public class Entity {

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

    }

    public void update(float delta){

    }
}

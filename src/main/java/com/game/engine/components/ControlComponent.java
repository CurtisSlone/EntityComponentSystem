package com.game.engine.components;

import com.game.engine.entities.Entity;

public abstract class ControlComponent implements Component{

    
    public abstract void update(Entity entity, float delta);
}
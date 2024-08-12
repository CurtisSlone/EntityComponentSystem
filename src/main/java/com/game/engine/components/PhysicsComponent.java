package com.game.engine.components;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.entities.Entity;

public abstract class PhysicsComponent implements Component {

    private Entity.State _state;
    
    private Polygon _boundaryPolygon;

    private static Rectangle _worldBounds;

    protected PhysicsComponent(){
        
        _boundaryPolygon = null;
    }

    public abstract void update(Entity entity, float delta);
}

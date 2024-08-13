package com.game.engine.components.player;

import com.game.engine.components.PhysicsComponent;
import com.game.engine.entities.Entity;

public class PlayerPhysicsComponent extends PhysicsComponent{


    public PlayerPhysicsComponent(){
        super();
        setAcceleration(200);
        setMaxSpeed(100);
        setDeceleration(10);
    }

    @Override
    public void dispose() {
                
    }
 
    @Override
    public void update(Entity entity, float delta) {
        applyPhysics(delta);
        wrapAroundWorld();
        shareCurrentPosition(entity.getGraphicsComponent());
        _boundaryPolygon.setPosition(_currentPosition.x, _currentPosition.y );


    }

}


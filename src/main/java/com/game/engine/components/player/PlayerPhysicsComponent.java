package com.game.engine.components.player;

import com.badlogic.gdx.math.Vector2;
import com.game.engine.components.PhysicsComponent;
import com.game.engine.entities.Entity;

public class PlayerPhysicsComponent extends PhysicsComponent{


    public PlayerPhysicsComponent(){
        this._currentPosition = new Vector2(400,300);
        changeMovement(0, 0, 200, 100, 10);
    }

    @Override
    public void dispose() {
                
    }

    @Override
    public void update(Entity entity, float delta) {
        shareMovement(entity.getGraphicsComponent());
    }

}


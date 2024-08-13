package com.game.engine.components.player;

import com.game.engine.components.PhysicsComponent;
import com.game.engine.entities.Entity;

public class PlayerPhysicsComponent extends PhysicsComponent{


    public PlayerPhysicsComponent(){
        initStartingPhysics(0, 0, 200, 100, 10);
    }
    @Override
    public void dispose() {
                
    }

    @Override
    public void update(Entity entity, float delta) {
        // TODO Auto-generated method stub
    }

    

}


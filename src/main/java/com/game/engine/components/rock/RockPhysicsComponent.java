package com.game.engine.components.rock;

import com.badlogic.gdx.math.MathUtils;
import com.game.engine.components.PhysicsComponent;
import com.game.engine.entities.Entity;

public class RockPhysicsComponent extends PhysicsComponent{

    public RockPhysicsComponent(){
        changeMovement(
            (50 + MathUtils.random(30)),
            MathUtils.random(360),
            0,
            (50 + MathUtils.random(30)),
            0);
    }
    
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }


    @Override
    public void update(Entity entity, float delta) {
        shareMovement(entity.getGraphicsComponent());
    }

}
 
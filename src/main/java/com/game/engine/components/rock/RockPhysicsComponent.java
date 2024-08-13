package com.game.engine.components.rock;

import com.badlogic.gdx.math.MathUtils;
import com.game.engine.components.PhysicsComponent;
import com.game.engine.entities.Entity;

public class RockPhysicsComponent extends PhysicsComponent{

    public RockPhysicsComponent(){
        super();
        float random = MathUtils.random(30);
        setSpeed(50 + random);
        setMaxSpeed(50 + random);
        setDeceleration(0);
        setMotionAngle( MathUtils.random(360));
    }
    
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }


    @Override
    public void update(Entity entity, float delta) {
        applyPhysics(delta);
        wrapAroundWorld();
        shareCurrentPosition(entity.getGraphicsComponent());

    }

}
 
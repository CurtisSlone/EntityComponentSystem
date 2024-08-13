package com.game.engine.components;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.entities.Entity;

public abstract class PhysicsComponent extends MovementComponent {

    protected Entity.State _state;
    
    protected Polygon _boundaryPolygon;
    protected static Rectangle _worldBounds;

    public static void setWorldBounds(Vector2 worldBounds){
        _worldBounds = new Rectangle(0,0, worldBounds.x, worldBounds.y);
    }

    public void applyPhysics(float delta){
        _velocityVec.add(_accelerationVec.x * delta, _accelerationVec.y * delta);
        float speed = _velocityVec.len();
        // decrease speed (decelerate) when not accelerating
        if (_accelerationVec.len() == 0) speed -= _deceleration * delta;

        speed = MathUtils.clamp(speed, 0, _maxSpeed);
    }

    public abstract void update(Entity entity, float delta);
}

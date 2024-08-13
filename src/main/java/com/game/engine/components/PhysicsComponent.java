package com.game.engine.components;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.entities.Entity;

public abstract class PhysicsComponent implements Component {

    protected Entity.State _state;
    protected Vector2 _velocityVec;
    protected Vector2 _accelerationVec;
    protected float _acceleration;
    protected float _maxSpeed;
    protected float _deceleration;
    protected Polygon _boundaryPolygon;
    protected Vector2 _currentPosition;
    protected static Rectangle _worldBounds;

    public void initStartingPhysics(float velocity, float accelerationAngle, float acceleration, float maxSpeed, float _deceleration){
        _accelerationVec = new Vector2().setAngleDeg(accelerationAngle);
        _velocityVec = (this._accelerationVec.len() == 0) ? new Vector2(velocity, 0) : this._accelerationVec.setLength(velocity);
        _acceleration = acceleration;
        _maxSpeed = maxSpeed;
        _deceleration = _deceleration;
    }

    public static void setWorldBounds(Vector2 worldBounds){
        _worldBounds = new Rectangle(0,0, worldBounds.x, worldBounds.y);
    }

    public abstract void update(Entity entity, float delta);
}

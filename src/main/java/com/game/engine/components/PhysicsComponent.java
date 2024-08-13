package com.game.engine.components;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.entities.Entity;

public abstract class PhysicsComponent extends MovementComponent {

    protected Vector2 _velocityVec;
    protected Vector2 _accelerationVec;
    protected float _acceleration;
    protected float _maxSpeed;
    protected float _deceleration;
    public Polygon _boundaryPolygon;
    protected static Vector2 _worldBounds;

    protected PhysicsComponent(){
        _velocityVec = new Vector2(0,0);
        _accelerationVec = new Vector2(0,0);
        _acceleration = 0;
        _maxSpeed = 1000;
        _deceleration = 0;
        _boundaryPolygon = null;
    }

    /*
     * RENDERING ACTIONS
     */
    public void applyPhysics(float delta){
        _velocityVec.add(_accelerationVec.x * delta, _accelerationVec.y * delta);
        float speed = _velocityVec.len();
        // decrease speed (decelerate) when not accelerating
        if (_accelerationVec.len() == 0) speed -= _deceleration * delta;

        speed = MathUtils.clamp(speed, 0, _maxSpeed);
        setSpeed(speed);
        
        _currentPosition.add(_velocityVec.x * delta, _velocityVec.y * delta);
        _accelerationVec.set(0,0);
    }

    public abstract void update(Entity entity, float delta);

    public void wrapAroundWorld(){
        if(_currentPosition.x + _dimensions.x < 0) _currentPosition.x = _worldBounds.x;
        if( _currentPosition.x > _worldBounds.x ) _currentPosition.x = 0;
        if( _currentPosition.y + _dimensions.y < 0) _currentPosition.y = _worldBounds.y;
        if( _currentPosition.y > _worldBounds.y) _currentPosition.y = 0;
        
    }

    /*
     * MOVEMENT ACTIONS
     */

     public void accelerateAtAngle(float angle){
        _accelerationVec.add( 
            new Vector2(_acceleration, 0).setAngleDeg(angle));
    }

    public void accelerateForward(){
        this.accelerateAtAngle(this._boundaryPolygon.getRotation());
    }

    public void rotateBy(float d){
        this._boundaryPolygon.rotate(d);
    }

    /*
     * GETTERS
     */

    public float getMotionAngle(){
        return _velocityVec.angleDeg();
    }


    /*
     * SETTERS
     */

     public static void setWorldBounds(Vector2 worldBounds){
        _worldBounds = new Vector2(worldBounds.x, worldBounds.y);
    }

    public void setSpeed(float speed){
        if (_velocityVec.len() == 0)
            _velocityVec.set(speed, 0);
        else
            _velocityVec.setLength(speed);
    }

    public void setMaxSpeed(float maxSpeed){
        this._maxSpeed = maxSpeed;
    }

    public void setDeceleration(float d){
        this._deceleration = d;
    }

    public void setAcceleration(float a){
        _acceleration = a;
    }

    public void setMotionAngle(float angle){
        _velocityVec.setAngleDeg(angle);
    }

    public void setBoundaryPolygon(int sides){
        float w = _dimensions.x;
        float h = _dimensions.y;

        float[] vertices = new float[2*sides];
        for (int i = 0; i < sides; i++)
        {
            float angle = i * 6.28f / sides;
            // x-coordinate
            vertices[2*i] = w/2 * MathUtils.cos(angle) + w/2;
            // y-coordinate
            vertices[2*i+1] = h/2 * MathUtils.sin(angle) + h/2;
        }
        _boundaryPolygon = new Polygon(vertices);
    }
}

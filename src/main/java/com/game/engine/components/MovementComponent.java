package com.game.engine.components;

import com.badlogic.gdx.math.Vector2;

public abstract class MovementComponent implements Component {

    protected Vector2 _velocityVec;
    protected Vector2 _accelerationVec;
    protected float _acceleration;
    protected float _maxSpeed;
    protected float _deceleration;
    protected Vector2 _currentPosition;
    protected Vector2 _dimensions;
    
    public void changeMovement(float velocity, float accelerationAngle, float acceleration, float maxSpeed, float _deceleration){
        _accelerationVec = new Vector2().setAngleDeg(accelerationAngle);
        _velocityVec = (this._accelerationVec.len() == 0) ? new Vector2(velocity, 0) : this._accelerationVec.setLength(velocity);
        _acceleration = acceleration;
        _maxSpeed = maxSpeed;
        _deceleration = _deceleration;
    }

    protected <T extends MovementComponent> void shareMovement(T mc){
        mc.changeMovement( _velocityVec.len(), _accelerationVec.angleDeg(), _acceleration, _maxSpeed, _deceleration);
    }

    protected <T extends MovementComponent> void shareDimension(T mc){
        mc.setDimension(getDimensions());
    }

    /*
     * SETTERS
     */

     public void setDimension(Vector2 dimension){
        this._dimensions = dimension;
     }

     /*
      * GETTERS
      */

      public Vector2 getDimensions(){
        return this._dimensions;
      }

}

package com.game.engine.components;

import com.badlogic.gdx.math.Vector2;

public abstract class MovementComponent implements Component {

   
    protected Vector2 _currentPosition;
    protected Vector2 _dimensions;
    
    public <T extends MovementComponent> void shareDimension(T mc){
        mc.setDimension(_dimensions);
    }

    public <T extends MovementComponent> void shareCurrentPosition(T mc){
        mc.setCurrentPosition(_currentPosition);
    }


    /*
     * SETTERS
     */

    public void setDimension(Vector2 dimension){
    this._dimensions = dimension;
    }


    public void setCurrentPosition(Vector2 position){
        this._currentPosition = position;
    }

    /*
    * GETTERS
    */

    public Vector2 getDimensions(){
    return this._dimensions;
    }

    public Vector2 getCurrentPosition(){
        return this._currentPosition;
    }

  

}

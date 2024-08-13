package com.game.engine.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.entities.Entity;

public abstract class GraphicsComponent extends MovementComponent {

    protected Texture _texture;
    protected Sprite _sprite;
    
    public abstract void update(Entity entity, Batch batch, float delta);

    public void initDimensions(){
        this._dimensions = new Vector2(this._sprite.getWidth(), this._sprite.getHeight());
    }

    public void rotateBy(float d){
        this._sprite.rotate(d);
    }

}
 
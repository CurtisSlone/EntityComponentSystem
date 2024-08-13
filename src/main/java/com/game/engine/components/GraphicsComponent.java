package com.game.engine.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.engine.entities.Entity;

public abstract class GraphicsComponent extends MovementComponent {

    protected Texture _texture;
    protected Sprite _sprite;
    
    public abstract void update(Entity entity, Batch batch, float delta);
}
 
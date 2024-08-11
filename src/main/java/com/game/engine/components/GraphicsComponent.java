package com.game.engine.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.entities.Entity;

public abstract class GraphicsComponent implements Component{

    protected Texture _texture;
    protected Vector2 _currentPosition;
    public abstract void update(Entity entity, Batch batch, float delta);
}

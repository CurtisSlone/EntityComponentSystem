package com.game.engine.components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.engine.entities.Entity;

public abstract class GraphicsComponent implements Component{

    TextureRegion _currentFrame;
    public abstract void update(Entity entity, float delta);
}

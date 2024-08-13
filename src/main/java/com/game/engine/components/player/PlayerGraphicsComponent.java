package com.game.engine.components.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.components.GraphicsComponent;
import com.game.engine.entities.Entity;

public class PlayerGraphicsComponent extends GraphicsComponent {

    Sprite sprite;
    
    public PlayerGraphicsComponent(){
        this._texture = new Texture(Gdx.files.internal("assets/spaceship.png"));
        this._sprite = new Sprite(this._texture);
        this._dimensions = new Vector2(this._sprite.getWidth(), this._sprite.getHeight());
    }

    @Override
    public void dispose() {
        
    }

    @Override
    public void update(Entity entity, Batch batch, float delta) {
        // TODO Auto-generated method stub
        _sprite.setPosition(this._currentPosition.x, this._currentPosition.y);
        _sprite.draw(batch);
    }

}

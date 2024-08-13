package com.game.engine.components.rock;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.components.GraphicsComponent;
import com.game.engine.entities.Entity;

public class RockGraphicsComponent extends GraphicsComponent {

    public RockGraphicsComponent(){
        this._texture = new Texture(Gdx.files.internal("assets/rock.png"));
        this._sprite = new Sprite(this._texture);
        this._sprite.setOrigin(0, 0);
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update( Entity entity, Batch batch, float delta) {
        // System.out.println(String.format("""
        //         Entity ID: %s,
        //         GraphicsPosition: (%.2f, %.2f)
        //         """, entity.getEntityId(), _currentPosition.x, _currentPosition.y));
        _sprite.setPosition(this._currentPosition.x, this._currentPosition.y);
        _sprite.draw(batch);
    }

}

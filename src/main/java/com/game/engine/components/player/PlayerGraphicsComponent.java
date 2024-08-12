package com.game.engine.components.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.components.GraphicsComponent;

public class PlayerGraphicsComponent extends GraphicsComponent {

    Sprite sprite;
    public PlayerGraphicsComponent(){
        this._texture = new Texture(Gdx.files.internal("assets/spaceship.png"));
        this._currentPosition = new Vector2(400,300);
    }

    @Override
    public void dispose() {
        
    }

    @Override
    public void receiveMessage(String message) {
        // TODO Auto-generated method stub
        String[] string = message.split(MESSAGE_TOKEN);
    }

    @Override
    public void update(Batch batch, float delta) {
        // TODO Auto-generated method stub
        batch.draw(this._texture, this._currentPosition.x, this._currentPosition.y);
       
    }

}

package com.game.engine.components.rock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.game.engine.components.GraphicsComponent;

public class RockGraphicsComponent extends GraphicsComponent {

    public RockGraphicsComponent(){
        this._texture = new Texture(Gdx.files.internal("assets/rock.png"));
    }
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }

    @Override
    public void receiveMessage(String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receiveMessage'");
    }

    @Override
    public void update( Batch batch, float delta) {
        // TODO Auto-generated method stub
        batch.draw(this._texture, this._currentPosition.x, this._currentPosition.y);
    }

}

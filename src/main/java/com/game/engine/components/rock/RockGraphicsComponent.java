package com.game.engine.components.rock;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.game.engine.components.GraphicsComponent;

public class RockGraphicsComponent extends GraphicsComponent {

    public RockGraphicsComponent(){
        this._texture = new Texture(Gdx.files.internal("assets/rock.png"));
        this._currentPosition = new Vector2(getRandom(0, 800), getRandom(0, 600));
    }
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void receiveMessage(String message) {
        // TODO Auto-generated method stub
    }

    @Override
    public void update( Batch batch, float delta) {
        // TODO Auto-generated method stub
        batch.draw(this._texture, this._currentPosition.x, this._currentPosition.y);
    }

    public int getRandom(int min, int max){
        Random random = new Random();
        return random.ints(min,max)
                .findFirst()
                .getAsInt();
    }

}

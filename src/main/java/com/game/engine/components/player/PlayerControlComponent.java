package com.game.engine.components.player;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.game.engine.components.ControlComponent;
import com.game.engine.entities.Entity;

public class PlayerControlComponent extends ControlComponent implements InputProcessor {

    enum Keys {
		LEFT, RIGHT, UP, DOWN, QUIT
	}

	private static Map<Keys, Boolean> keys = new HashMap<PlayerControlComponent.Keys, Boolean>();

    static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
		keys.put(Keys.QUIT, false);
	};

    private final float degreesPerSecond = 120;


    public PlayerControlComponent(){
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void update(Entity entity, float delta) {
        if( keys.get(Keys.LEFT)){
            
		}else if( keys.get(Keys.RIGHT)){
            
		}else if( keys.get(Keys.UP)){
            
		}else if(keys.get(Keys.DOWN)){
            
		}else if(keys.get(Keys.QUIT)){
			Gdx.app.exit();
		}else{
			
		}
    }

    /*
     * Input Processing
     */

    @Override
    public boolean keyDown(int keycode) {
        if( keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
			this.leftPressed();
		}
		if( keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
			this.rightPressed();
		}
		if( keycode == Input.Keys.UP || keycode == Input.Keys.W){
			this.upPressed();
		}
		if( keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
			this.downPressed();
		}
		if( keycode == Input.Keys.Q){
			this.quitPressed();
		}

		return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if( keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
			this.leftReleased();
		}
		if( keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
			this.rightReleased();
		}
		if( keycode == Input.Keys.UP || keycode == Input.Keys.W ){
			this.upReleased();
		}
		if( keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
			this.downReleased();
		}
		if( keycode == Input.Keys.Q){
			this.quitReleased();
		}
		return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
    }

    /*
     * Private key presses
     */
    private void leftPressed(){
        keys.put(Keys.LEFT, true);
    }

    private void rightPressed(){
        keys.put(Keys.RIGHT, true);
    }

    private void upPressed(){
        keys.put(Keys.UP, true);
    }

    private void downPressed(){
        keys.put(Keys.DOWN, true);
    }

    private void quitPressed(){
        keys.put(Keys.QUIT, true);
    }

    private void leftReleased(){
        keys.put(Keys.LEFT, false);
    }

    private void rightReleased(){
        keys.put(Keys.RIGHT, false);
    }

    private void upReleased(){
        keys.put(Keys.UP, false);
    }

    private void downReleased(){
        keys.put(Keys.DOWN, false);
    }

    private void quitReleased(){
        keys.put(Keys.QUIT, false);
    }
    

    

}

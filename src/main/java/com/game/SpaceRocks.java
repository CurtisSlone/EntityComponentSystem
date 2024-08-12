package com.game;

import com.badlogic.gdx.Game;
import com.game.screens.MainGameScreen;

public class SpaceRocks extends Game {

    public static final MainGameScreen _mainGameScreen = new MainGameScreen();

    @Override
    public void create() {
        setScreen(_mainGameScreen);
    } 

   @Override
   public void dispose(){
    _mainGameScreen.dispose();
   }

}

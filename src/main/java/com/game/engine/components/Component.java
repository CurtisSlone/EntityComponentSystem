package com.game.engine.components;

public interface Component {

    public static final String MESSAGE_TOKEN = ":::::";

    public static enum MESSAGE{
        CURRENT_POSITION,
        GRAPHIC_STATE,
        COLLISON_WITH_ENTITY
        
    }
    void dispose();
    void receiveMessage(String message);
}

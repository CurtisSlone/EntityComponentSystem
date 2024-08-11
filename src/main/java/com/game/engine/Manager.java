package com.game.engine;

import com.game.engine.entities.Entity;
import com.game.engine.systems.LocationSystem;
import com.game.engine.systems.RenderingSystem;

public class Manager {

    public static Manager manager;

    private static RenderingSystem renderingSystem;
    private static LocationSystem locationSystem;
    private static Entity _player;

    public static Manager getInstance() {
        return new Manager();
    }

    public void init(RenderingSystem renderingSystem, LocationSystem locationSystem){
        Manager.locationSystem = locationSystem;
        Manager.renderingSystem = renderingSystem;
    }

    public void setPlayer(Entity player){
        Manager._player = player;
    }

    public Entity getPlayer(){
        return this._player;
    }
}

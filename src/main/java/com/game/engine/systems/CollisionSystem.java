package com.game.engine.systems;

import com.game.engine.components.Component;

public class CollisionSystem implements System{

    public static CollisionSystem collisionSystem;

    public static CollisionSystem getInstance(){
        return new CollisionSystem();
    }
    @Override
    public void registerComponent(Component component) {
        // TODO Auto-generated method stub
    }

    @Override
    public void removeComponent(Component component) {
        // TODO Auto-generated method stub
    }

    @Override
    public void notifyComponents(String message) {
        // TODO Auto-generated method stub
    }

}

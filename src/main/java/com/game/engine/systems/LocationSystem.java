package com.game.engine.systems;

import java.util.ArrayList;
import java.util.Hashtable;

import com.badlogic.gdx.math.Vector2;
import com.game.engine.components.Component;

public class LocationSystem implements System {

    ArrayList<Component> components;
    Hashtable<String,Vector2> locations;
    @Override
    public void registerComponent(Component component) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerComponent'");
    }

    @Override
    public void removeComponent(Component component) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeComponent'");
    }

    @Override
    public void notifyComponents(String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyComponents'");
    }

}

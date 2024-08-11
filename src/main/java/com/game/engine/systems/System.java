package com.game.engine.systems;

import java.util.ArrayList;

import com.game.engine.components.Component;

public interface System {
    void registerComponent(Component component);
    void removeComponent(Component component);
    void notifyComponents(String message);
}

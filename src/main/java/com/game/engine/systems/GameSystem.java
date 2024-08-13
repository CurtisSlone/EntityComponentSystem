package com.game.engine.systems;

import java.util.ArrayList;

import com.game.engine.components.Component;

public interface GameSystem {
    void registerComponent(Component component);
    void removeComponent(Component component);
}

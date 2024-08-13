package com.game.engine.systems;

import java.util.ArrayList;
import java.util.List;

import com.game.engine.components.Component;
import com.game.engine.components.player.PlayerPhysicsComponent;
import com.game.engine.components.rock.RockPhysicsComponent;

public class CollisionSystem implements GameSystem{

    public static CollisionSystem collisionSystem;

    private static List<RockPhysicsComponent> _components = new ArrayList<>();
    private static PlayerPhysicsComponent _player;
    public static CollisionSystem getInstance(){
        return new CollisionSystem();
    }
    @Override
    public void registerComponent(Component component) {
        if(component instanceof PlayerPhysicsComponent)
            _player = (PlayerPhysicsComponent)component;
        else
            _components.add((RockPhysicsComponent)component);
    }

    @Override
    public void removeComponent(Component component) {
        if(component instanceof PlayerPhysicsComponent)
            _player = null;
        else
            _components.remove(component);
    }

    public void checkCollisions(){
        for(RockPhysicsComponent rock : _components){
            if(_player._boundaryPolygon.getBoundingRectangle().overlaps(rock._boundaryPolygon.getBoundingRectangle())){
                _player.setMotionAngle(rock.getMotionAngle());
            }
                
        }
    }

}

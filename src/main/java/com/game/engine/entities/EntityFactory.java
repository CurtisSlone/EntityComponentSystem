package com.game.engine.entities;

import com.game.engine.components.player.PlayerControlComponent;
import com.game.engine.components.player.PlayerGraphicsComponent;
import com.game.engine.components.player.PlayerPhysicsComponent;
import com.game.engine.components.rock.RockControlComponent;
import com.game.engine.components.rock.RockGraphicsComponent;
import com.game.engine.components.rock.RockPhysicsComponent;

public class EntityFactory {

    public static enum EntityType{
        PLAYER,
        ROCK,
        LASER
    }

    public static Entity createEntity(EntityType type){
    
        Entity e = null;
        switch(type){
            case PLAYER:
                e = new Entity(new PlayerControlComponent(), new PlayerPhysicsComponent(), new PlayerGraphicsComponent());
                return e;
            case ROCK:
                e = new Entity(new RockControlComponent(), new RockPhysicsComponent(), new RockGraphicsComponent());
                return e;
            default:
                return null;
        }
    }

}

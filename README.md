# Entity Component System - Space Rocks

A Space Rocks (Asteroids-style) game built with [LibGDX](https://libgdx.com/) demonstrating the **Entity Component System (ECS)** architectural pattern. Developed as part of my MS in Software Engineering coursework.

## 🎥 Presentation

[Watch the project presentation on YouTube](https://youtu.be/Hm6E-o_kVno)

## Overview

This project implements a classic arcade-style space game where the player controls a spaceship navigating through an asteroid field. The primary focus is on demonstrating the ECS design pattern, which promotes composition over inheritance and separates data from behavior for improved modularity and flexibility.

## Architecture

### Entity Component System Pattern

The ECS pattern divides game objects into three core concepts:

- **Entities**: Unique identifiers that represent game objects (Player, Rocks)
- **Components**: Pure data containers attached to entities (Physics, Graphics, Control)
- **Systems**: Logic processors that operate on entities with specific component combinations (CollisionSystem)

```
┌─────────────────────────────────────────────────────────────┐
│                         Manager                              │
│  ┌─────────────────────────────────────────────────────┐    │
│  │                    Entities                          │    │
│  │  ┌─────────┐  ┌─────────┐  ┌─────────┐             │    │
│  │  │ Player  │  │  Rock   │  │  Rock   │  ...        │    │
│  │  └────┬────┘  └────┬────┘  └────┬────┘             │    │
│  └───────┼────────────┼───────────┼────────────────────┘    │
│          │            │           │                          │
│  ┌───────▼────────────▼───────────▼────────────────────┐    │
│  │                   Components                         │    │
│  │  ┌─────────┐  ┌─────────┐  ┌─────────┐             │    │
│  │  │ Control │  │ Physics │  │Graphics │             │    │
│  │  └─────────┘  └─────────┘  └─────────┘             │    │
│  └─────────────────────────────────────────────────────┘    │
│                              │                               │
│  ┌───────────────────────────▼─────────────────────────┐    │
│  │                    Systems                           │    │
│  │              ┌─────────────────┐                    │    │
│  │              │ CollisionSystem │                    │    │
│  │              └─────────────────┘                    │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
```

### Project Structure

```
src/main/java/com/game/
├── DesktopLauncher.java          # Application entry point
├── SpaceRocks.java               # Main game class
├── engine/
│   ├── Manager.java              # Central game manager
│   ├── components/
│   │   ├── Component.java        # Base component interface
│   │   ├── ControlComponent.java # Input handling abstraction
│   │   ├── MovementComponent.java# Position/dimension data
│   │   ├── GraphicsComponent.java# Rendering component
│   │   ├── PhysicsComponent.java # Physics/collision component
│   │   ├── player/               # Player-specific implementations
│   │   │   ├── PlayerControlComponent.java
│   │   │   ├── PlayerGraphicsComponent.java
│   │   │   └── PlayerPhysicsComponent.java
│   │   └── rock/                 # Rock-specific implementations
│   │       ├── RockControlComponent.java
│   │       ├── RockGraphicsComponent.java
│   │       └── RockPhysicsComponent.java
│   ├── entities/
│   │   ├── Entity.java           # Entity container class
│   │   └── EntityFactory.java    # Factory for creating entities
│   ├── systems/
│   │   ├── GameSystem.java       # System interface
│   │   └── CollisionSystem.java  # Collision detection system
│   └── util/
│       └── IdGenerator.java      # Unique ID generation
└── screens/
    └── MainGameScreen.java       # Main game screen
```

## Components

### MovementComponent
Base component providing position and dimension data with methods for sharing state between components.

### PhysicsComponent
Handles physics simulation including:
- Velocity and acceleration vectors
- Speed limits and deceleration
- Boundary polygon collision shapes
- World wrapping behavior

### GraphicsComponent
Manages visual representation:
- Texture and sprite handling
- Position-based rendering
- Rotation synchronization

### ControlComponent
Abstract input handler allowing different control schemes per entity type.

## Gameplay

- **Movement**: Arrow keys or WASD to rotate and thrust
- **Objective**: Navigate through the asteroid field
- **World Wrapping**: Objects wrap around screen edges
- **Collision**: Colliding with rocks affects player momentum

## Controls

| Key | Action |
|-----|--------|
| ↑ / W | Thrust forward |
| ← / A | Rotate left |
| → / D | Rotate right |
| Q | Quit game |

## Requirements

- Java 17+
- Maven 3.6+

## Building & Running

```bash
# Clone the repository
git clone <repository-url>
cd spacerocks

# Build with Maven
mvn clean compile

# Run the game
mvn exec:java -Dexec.mainClass="com.game.DesktopLauncher"
```

### IDE Setup

**VS Code**: Use the provided launch configurations in `.vscode/launch.json`
- Windows: Use the "Windows" configuration
- macOS: Use the "Mac" configuration (includes `-XstartOnFirstThread` JVM arg)

## Dependencies

- **LibGDX 1.12.1**: Cross-platform game development framework
- **LWJGL3**: Desktop backend for LibGDX

## Key Design Decisions

1. **Composition over Inheritance**: Entities are composed of components rather than inheriting behavior, allowing flexible combinations.

2. **Data-Behavior Separation**: Components hold data while systems contain logic, making the codebase easier to maintain and extend.

3. **Factory Pattern**: `EntityFactory` centralizes entity creation, ensuring consistent component assembly.

4. **Singleton Manager**: Central `Manager` class coordinates entity updates and system interactions.

## Future Enhancements

- [ ] Laser shooting mechanics
- [ ] Rock destruction and splitting
- [ ] Score system
- [ ] Multiple lives
- [ ] Sound effects and music
- [ ] Particle effects

## License

This project was developed for educational purposes as part of an MS in Software Engineering program.

## Author

Developed as a graduate coursework project demonstrating software architecture patterns in game development.

# A Dog's Dream 🐶

A 2D side-scrolling obstacle-dodging game built in **Java** with **Swing/AWT**. Control a flying dog through the night sky, dodge birds, flying squirrels, and tennis balls, and survive as long as possible.

## Features

- Three automatic difficulty stages: **Easy**, **Medium**, and **Hard**
- Increasing obstacle speed and spawn frequency
- Player movement using the up and down arrow keys
- Collision detection and a game-over screen with final score
- Restart using the **R** key
- Animated, scrolling obstacles and clouds

## Controls

| Key | Action |
| --- | --- |
| ↑ | Move up |
| ↓ | Move down |
| R | Restart after game over |

## How to run

### In BlueJ

1. Download this repository and extract its files into one folder.
2. Open the folder as a project in **BlueJ**.
3. Compile the Java classes.
4. Right-click `Project8_driver` and invoke `main()`.

Keep the four `.png` files in the same folder as the `.java` files; the game loads them at runtime.

**Note:** The original entry point is `main()` (without parameters), which works when invoked through BlueJ but is not the standard `main(String[] args)` entry point for `java Project8_driver`. To run it from a terminal, that method would need a small update.

## Project structure

| File/class | Role |
| --- | --- |
| `Project8_driver.java` | Launches the game window |
| `CanvasFrame_P8.java` | Creates the window |
| `CanvasPanel_P8.java` | Game updates, drawing, controls, scoring, and difficulty |
| `GameObject_P8.java` | Abstract base for game objects and collision behavior |
| `Dog.java` | Player-controlled character |
| `Obstacle.java` | Abstract base for moving obstacles |
| `Bird.java`, `FlyingSquirrel.java`, `TennisBall.java` | Obstacle types |
| `Cloud.java` | Moving background clouds |
| `*.png` | Game artwork |
| `A_Dogs_Dream_UML_Diagram.pdf` | UML class diagram |

## Technical highlights

- Object-oriented design with abstract classes and inheritance
- Event-driven keyboard input and rendering using Java Swing/AWT
- Timed game updates, collision handling, and increasing difficulty
- Separate classes for the player, obstacles, and environment

## Project background

Created as an individual Java programming project in Spring 2026.

## Possible future improvements

- Persistent personal-best tracking
- Sound effects and music
- Start/pause menu
- More obstacle types

## Author

Swetha Antony — Computer Science, Rowan University

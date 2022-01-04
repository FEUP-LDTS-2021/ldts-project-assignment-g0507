# LDTS_T05_G07
# ASCII Breaker

## Game Description

**ASCII Breaker** is a brick breaker based game where the player must smash a wall of bricks by deflecting a bouncing ball with a paddle which may only be moved horizontally. The player starts with 3 lives and loses one each time the ball hits the bottom of the screen.
The variety of levels will have increased difficulty by adding different kinds of bricks, changing ball speed and adding special power ups and handicaps for the player.

This project was developed for LDTS 2021-22 by:

- **_Ana Reis_** (*up201905529*@fe.up.pt) </LI>
- **_Andre Cruz_** (*up201705768*@fc.up.pt) </LI>
- **_Angy da Cruz_** (*up202007253*@fc.up.pt) </LI>

## Workflow

This project is being developed following the **_Feature Branches Workflow_**

<p align="center" justify="center">
  <img src="images/featurebranches.png"/>
</p>
<p align="center">
  <b><i>Fig 1. Feature branches workflow</i></b>
</p>

This is done as the previous image illustrates, by doing all feature development under feature branches which then merge into the **developing** branch. This is in order to facilitate collaboration between the various contributors and to not disturb the main codebase by encapsulating the **main** branch only for **releases**. 

All release will also be named following the semantic version spec. See [https://semver.org]()
## Planned Features

- **Connected Menus** - The player can browse through several menus. (Play, Options, Quit).
- **Level generation** - The player can play through the prebuilt levels or a randomly generated level.
- **Collision detection** - Collisions between all game elements are verified (Paddle, Ball, Bricks, Game border).
- **Life system** - Players have a finite mount of lives and when they reach 0 its Game Over.
- **Object customization** - The player can select different character types for several of the game's elements (Paddle, Ball, Bricks)

## Design

### Brick Generation

#### Problem in Context:

#### Pattern:
We have applied the **_Factory Method_** pattern. This pattern lets us define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible for the creation of the instance of the class. This is useful in our brick generation since we will be generating several types of bricks with minor differences between them, and we also want to have several ways or handling this generation.

<p align="center" justify="center">
  <img src="images/UML/brickgeneration.png"/>
</p>
<p align="center">
  <b><i>Fig 2. Brick Generation UML</i></b>
</p>

#### Implementation:


#### Consequences:

## Known Code Smells and Refactoring Suggestion

## Testing

### Test coverage report

### Mutation testing report

## Self-evaluation
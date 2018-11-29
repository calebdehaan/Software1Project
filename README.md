
# Frisbee Fun Software 1 
#### A project for Software 1 by Caleb DeHaan, Matt Giles, Jameson Axton, and Hunter Michalk

This project is meant to be a stat-tracker for an ultimate frisbee team. It will track individual players and both their personal info and their ultimate frisbee season stats.

## How to Run
Simply run the Diskiples.jar file and the program will open itself. If the Diskiples.jar file is not present, you can package the maven project to create the jar file.

#### Login Info
Username: admin  
Password: password

#### Things You Can Do
- Add players to your team
- View stats of players in your team
- Edit stats of players in your team
- Track a live ultimate frisbee game

## Design Patterns:
   - Factory: GameHandlerFactory
   - Visitor: ActionVisitor
   - Builder: StringBuilder
   - Singleton: User
   - Iterator: ArrayList
   - Command: Runnable
   - Decorator: InputStream subclasses
   - Composite: java.awt.Container
   - Flyweight: java.lang.Inteter\#valueOf(int)
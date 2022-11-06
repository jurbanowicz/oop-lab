package agh.ics.oop;

import static java.lang.System.out;

import static agh.ics.oop.Direction.PossibleDirections;

public class World {
    public static void GetDirection(PossibleDirections direction){
        // prints out a message about the current direction
        String message = switch (direction) {
            case FORWARD -> "Zwierzak idzie do przodu";
            case BACKWARD -> "Zwierzak idzie do tyłu";
            case RIGHT -> "Zwierzak skręca w prawo";
            case LEFT -> "Zwirzak skręca w lewo";
        };
        out.println(message);
    }

    public static PossibleDirections[] ChangeToDirection(String[] directions) {
        // change string array into array of enum type

        PossibleDirections[] Moves = new PossibleDirections[directions.length];

        for (int i=0; i < directions.length; i++) {
            switch (directions[i]) {
                case "f" -> Moves[i] = PossibleDirections.FORWARD;
                case "b" -> Moves[i] = PossibleDirections.BACKWARD;
                case "r" -> Moves[i] = PossibleDirections.RIGHT;
                case "l" -> Moves[i] = PossibleDirections.LEFT;
            }
        }
        return Moves;
    }
    public static void run(PossibleDirections[] directions) {
        for(PossibleDirections direction: directions) {
            GetDirection(direction);
        }
    }

    public static void main(String[] args) {
        out.println("System wystartował");


//        PossibleDirections[] Moves = ChangeToDirection(args);
//
////        run(Moves);
//
////        Animal animal = new Animal();
////
////        out.println(animal);
////
////        MoveDirection[] animalDirections = OptionsParser.parse(args);
////
////        for(MoveDirection direction: animalDirections) {
////            animal.move(direction);
////        }
////
////        out.println(animal);

        args = new String[]{"f" ,"b", "b", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        out.println(map);
        out.println("System zakończył działanie");
    }

}



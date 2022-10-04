package agh.ics.oop;

import static java.lang.System.out;

import static agh.ics.oop.Direction.PossibleDirections;


public class World {
    public static void GetDirection(PossibleDirections direction){
        String message = switch (direction) {
            case FORWARD -> "Zwierzak idzie do przodu";
            case BACKWARD -> "Zwierzak idzie do tyłu";
            case RIGHT -> "Zwierzak skręca w prawo";
            case LEFT -> "Zwirzak skręca w lewo";
        };
        out.println(message);
    }

    public static PossibleDirections[] ChangeToDirection(String[] directions) {

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

//        String[] directions = new String[] {"f", "b", "f", "l", "r", "f"};

        PossibleDirections[] Moves = ChangeToDirection(args);

        run(Moves);

        out.println("System zakończył działanie");
    }

}
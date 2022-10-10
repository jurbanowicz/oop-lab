package agh.ics.oop;

import static java.lang.System.out;

import static agh.ics.oop.Direction.PossibleDirections;

class Vector2d {
    public final int x;
    public final int y;
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
    boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }
    boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }
    Vector2d upperRight(Vector2d other) {
        int newX;
        int newY;
        if (this.x >= other.x) {
            newX = this.x;
        } else {
            newX = other.x;
        }
        if (this.y >= other.y) {
            newY = this.y;
        } else {
            newY = other.y;
        }
        return new Vector2d(newX, newY);
    }
    Vector2d lowerLeft(Vector2d other) {
        int newX;
        int newY;
        if (this.x <= other.x) {
            newX = this.x;
        } else {
            newX = other.x;
        }
        if (this.y <= other.y) {
            newY = this.y;
        } else {
            newY = other.y;
        }
        return new Vector2d(newX, newY);
    }
    Vector2d add(Vector2d other) {
        int newX;
        int newY;
        newX = this.x + other.x;
        newY = this.y + other.y;
        return new Vector2d(newX, newY);
    }
    Vector2d subtract(Vector2d other) {
        int newX;
        int newY;
        newX = this.x - other.x;
        newY = this.y - other.y;
        return new Vector2d(newX, newY);
    }
    public boolean equals(Object other) {
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if (this.x == that.x && this.y == that.y) {
            return true;
        }
        return false;
    }
    Vector2d opposite() {
        int newX;
        int newY;
        newX = this.x * (-1);
        newY = this.y * (-1);
        return new Vector2d(newX, newY);
    }
}

enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT
}

enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case EAST -> "Wschód";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
        };
    }
    public MapDirection next() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }
    public MapDirection previous() {
        return switch (this) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }
    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }
}


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


        PossibleDirections[] Moves = ChangeToDirection(args);

        run(Moves);


//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));


        out.println("System zakończył działanie");
    }

}



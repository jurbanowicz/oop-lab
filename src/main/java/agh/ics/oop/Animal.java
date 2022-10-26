package agh.ics.oop;

public class Animal {
    private MapDirection currDirection = MapDirection.NORTH;
    private Vector2d currPosition;

    public Animal() {
        currPosition = new Vector2d(2, 2);
    }
    public Animal(IWorldMap map) {
        currPosition = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        currPosition = initialPosition;
    }

    public String toString() {
        return switch (currDirection) {
            case SOUTH -> "S";
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
        };
    }
    boolean isAt(Vector2d position) {
        return currPosition.equals(position);
    }
    void move(MoveDirection direction, IWorldMap map) {
        Vector2d newPosition = currPosition;
        switch (direction) {
            case LEFT -> currDirection = currDirection.previous();
            case RIGHT -> currDirection = currDirection.next();
            case FORWARD -> newPosition = currPosition.add(currDirection.toUnitVector());
            case BACKWARD -> newPosition = currPosition.subtract(currDirection.toUnitVector());
        }
        if (map.canMoveTo(newPosition)) {
            currPosition = newPosition;
        }
    }

    Vector2d getPosition() {
        return this.currPosition;
    }


}

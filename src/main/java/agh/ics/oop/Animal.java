package agh.ics.oop;

public class Animal {
    private MapDirection currDirection = MapDirection.NORTH;
    private Vector2d currPosition = new Vector2d(2, 2);

    public String toString() {
        return currPosition.toString() + currDirection.toString();
    }
    boolean isAt(Vector2d position) {
        return currPosition.equals(position);
    }
    void move(MoveDirection direction) {
        Vector2d newPosition = currPosition;
        switch (direction) {
            case LEFT -> currDirection = currDirection.previous();
            case RIGHT -> currDirection = currDirection.next();
            case FORWARD -> newPosition = currPosition.add(currDirection.toUnitVector());
            case BACKWARD -> newPosition = currPosition.subtract(currDirection.toUnitVector());
        }
        if (newPosition.precedes(new Vector2d(4, 4))) {
            if (newPosition.follows(new Vector2d(0, 0))) {
                currPosition = newPosition;
            }
        }
    }


}

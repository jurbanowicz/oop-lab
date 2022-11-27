package agh.ics.oop;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class Animal extends AbstractMapElement {
    private MapDirection currDirection = MapDirection.NORTH;
    private Vector2d currPosition;

    private IWorldMap map;
    private ArrayList<IPositionChangeObserver> observerList;

    public Animal() {
        currPosition = new Vector2d(2, 2);
    }
    public Animal(IWorldMap map) {
        currPosition = new Vector2d(2, 2);
        this.map = map;
        observerList = new ArrayList<>();
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        currPosition = initialPosition;
        this.map = map;
        observerList = new ArrayList<>();
        IPositionChangeObserver observer = (IPositionChangeObserver) map;
        addObserver(observer);
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
    void move(MoveDirection direction) {
        Vector2d newPosition = currPosition;
        Vector2d oldPosition = currPosition;
        switch (direction) {
            case LEFT -> currDirection = currDirection.previous();
            case RIGHT -> currDirection = currDirection.next();
            case FORWARD -> newPosition = currPosition.add(currDirection.toUnitVector());
            case BACKWARD -> newPosition = currPosition.subtract(currDirection.toUnitVector());
        }
        if (this.map.canMoveTo(newPosition)) {
            this.currPosition = newPosition;
            positionChanged(oldPosition, newPosition);
        }
        ((GrassField) map).updateGui();
    }
    public Vector2d getPosition() {
        return this.currPosition;
    }

    public void addObserver(IPositionChangeObserver observer) {
        observerList.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer) {
        observerList.remove(observer);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer: observerList) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
    public ImageView getImage(){
        ImageView imageView = null;
        switch (this.currDirection) {
            case NORTH -> imageView = getAnimalN();
            case EAST -> imageView = getAnimalE();
            case SOUTH -> imageView = getAnimalS();
            case WEST -> imageView = getAnimalW();
        }
        return imageView;
    }
}

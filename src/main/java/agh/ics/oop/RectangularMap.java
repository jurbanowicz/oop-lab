package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;

    private Object[][] map;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Object[height][width];
    }

    @Override
    public Vector2d findLowLeft() {
        return new Vector2d(0, 0);
    }
    @Override
    public Vector2d findUpperRight() {
        return new Vector2d(width - 1, height - 1);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.precedes(new Vector2d(width - 1, height - 1)) && position.follows(new Vector2d(0, 0))) {
            return !(isOccupied(position));
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())) {
            return false;
        }
        map[animal.getPosition().y][animal.getPosition().x] = animal;
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return map[position.y][position.x] != null;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = (Animal) objectAt(oldPosition);
        map[oldPosition.y][oldPosition.x] = null;
        map[newPosition.y][newPosition.x] = animal;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return map[position.y][position.x];
    }

    public void moveFromTo(Vector2d start, Vector2d end, Animal animal) {
        map[start.y][start.x] = null;
        map[end.y][end.x] = animal;
    }
}

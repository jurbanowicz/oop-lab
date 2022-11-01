package agh.ics.oop;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;

    private Object[][] map;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Object[height][width];
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualization = new MapVisualizer(this);
        return mapVisualization.draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
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
    public Object objectAt(Vector2d position) {
        return map[position.y][position.x];
    }

    @Override
    public void moveFromTo(Vector2d start, Vector2d end, Animal animal) {
        map[start.y][start.x] = null;
        map[end.y][end.x] = animal;
    }
}

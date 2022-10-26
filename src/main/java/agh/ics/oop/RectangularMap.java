package agh.ics.oop;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;

    private boolean[][] map;

    public RectangularMap(int width,int height) {
        this.width = width;
        this.height = height;
        map = new boolean[height][width];
    }


    @Override
    public String toString() {
        return "";
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)) {
            return false;
        }
        if (position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0, 0))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (map[animal.getPosition().y][animal.getPosition().x]) {
            return false;
        }
        map[animal.getPosition().y][animal.getPosition().x] = true;
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return map[position.y][position.x];
    }
    @Override
    public Object objectAt(Vector2d position) {
        return map[position.x][position.y];
    }
}

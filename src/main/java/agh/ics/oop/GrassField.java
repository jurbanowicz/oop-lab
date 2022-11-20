package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private Map<Vector2d, Animal> animals;
    private Map<Vector2d, Grass> grassList;
    private int grassAmount;

    public GrassField(int grassAmount) {
        animals = new HashMap<>();
        grassList = new HashMap<>();
        this.grassAmount = grassAmount;
        int i = 0;
        while (i < grassAmount) {
            int x = ThreadLocalRandom.current().nextInt(0, (int) sqrt(grassAmount*10));
            int y = ThreadLocalRandom.current().nextInt(0, (int) sqrt(grassAmount*10));
            Vector2d pos = new Vector2d(x, y);
            if (!(isOccupied(pos))) {
                grassList.put(pos, new Grass(pos));
                i++;
            }
        }
    }

    /** place new grass on a random position and remove the old one where the animal has moved
     * @param grass old grass to be removed
     */
    public void placeNewGrass(Grass grass) {
        grassList.remove(grass.getPosition());
        boolean flag = true;
        while (flag) {
            int x = ThreadLocalRandom.current().nextInt(0, (int) sqrt(grassAmount*10));
            int y = ThreadLocalRandom.current().nextInt(0, (int) sqrt(grassAmount*10));
            Vector2d pos = new Vector2d(x, y);
            if (!(isOccupied(pos))) {
                grassList.put(pos, new Grass(pos));
                flag = false;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (animals.containsKey(position)) {
                return false;
            }
        if (grassList.containsKey(position)) {
            placeNewGrass(grassList.get(position));
            return true;
            }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException("Not possible to place object at: " + animal.getPosition());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (animals.containsKey(position)) {
            return true;
        }
        if (grassList.containsKey(position)) {
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        if (grassList.containsKey(position)) {
            return grassList.get(position);
        }
        return null;
    }

    /**
     * Finds the lowest left item on the map
     * @return Vector2d of the position of such item
     */
    @Override
    public Vector2d findLowLeft() {
        int bestX = 0;
        int bestY = 0;
        boolean flag = true;
        for (Vector2d position : animals.keySet()) {
            if (flag) {
               bestX = position.x;
               bestY = position.y;
               flag = false;
            }
            if (position.x < bestX) {
                bestX = position.x;
            }
            if (position.y < bestY) {
                bestY = position.y;
            }
        }
        for (Vector2d position : grassList.keySet()) {
            if (position.x < bestX) {
                bestX = position.x;
            }
            if (position.y < bestY) {
                bestY = position.y;
            }
        }
        return new Vector2d(bestX, bestY);
    }

    /** Finds the most upper right item on the map
     * @return Vector2d of the most upper right item
    */
    @Override
    public Vector2d findUpperRight() {
        int bestX = 0;
        int bestY = 0;
        boolean flag = true;
        for (Vector2d position : animals.keySet()) {
            if (flag) {
                bestX = position.x;
                bestY = position.y;
                flag = false;
            }
            if (position.x > bestX) {
                bestX = position.x;
            }
            if (position.y > bestY) {
                bestY = position.y;
            }
        }
        for (Vector2d position : grassList.keySet()) {
            if (position.x > bestX) {
                bestX = position.x;
            }
            if (position.y > bestY) {
                bestY = position.y;
            }
        }
        return new Vector2d(bestX, bestY);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }
}

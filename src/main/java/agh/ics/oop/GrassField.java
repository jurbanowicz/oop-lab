package agh.ics.oop;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private ArrayList<Animal> animals;
    private ArrayList<Grass> grassList;

    public GrassField(int grassAmount) {
        animals = new ArrayList<>();
        grassList = new ArrayList<>();
        int i = 0;
        while (i < grassAmount) {
            int x = ThreadLocalRandom.current().nextInt(0, (int) sqrt(grassAmount*10));
            int y = ThreadLocalRandom.current().nextInt(0, (int) sqrt(grassAmount*10));
            Vector2d pos = new Vector2d(x, y);
            if (!(isOccupied(pos))) {
                grassList.add(new Grass(pos));
                i++;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal: animals)
            if (animal.getPosition().equals(position)) {
                return false;
            }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals)
            if (animal.getPosition().equals(position)) {
                return true;
        }
        for (Grass grass: grassList) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        for (Grass grass: grassList) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    /**
     * Finds the lowest left item on the map
     * @return Vector2d of the position of such item
     */
    @Override
    public Vector2d findLowLeft() {
        int bestX = animals.get(0).getPosition().x;
        int bestY = animals.get(0).getPosition().y;
        for (Animal animal : animals) {
            if (animal.getPosition().x < bestX) {
                bestX = animal.getPosition().x;
            }
            if (animal.getPosition().y < bestY) {
                bestY = animal.getPosition().y;
            }
        }
        for (Grass grass : grassList) {
            if (grass.getPosition().x < bestX) {
                bestX = grass.getPosition().x;
            }
            if (grass.getPosition().y < bestY) {
                bestY = grass.getPosition().y;
            }
        }
        return new Vector2d(bestX, bestY);
    }

    /** Finds the most upper right item on the map
     * @return Vector2d of the most upper right item
    */
    @Override
    public Vector2d findUpperRight() {
        int bestX = animals.get(0).getPosition().x;
        int bestY = animals.get(0).getPosition().y;
        for (Animal animal : animals) {
            if (animal.getPosition().x > bestX) {
                bestX = animal.getPosition().x;
            }
            if (animal.getPosition().y > bestY) {
                bestY = animal.getPosition().y;
            }
        }
        for (Grass grass : grassList) {
            if (grass.getPosition().x > bestX) {
                bestX = grass.getPosition().x;
            }
            if (grass.getPosition().y > bestY) {
                bestY = grass.getPosition().y;
            }
        }
        return new Vector2d(bestX, bestY);
    }

    @Override
    public void moveFromTo(Vector2d start, Vector2d end, Animal animal){}
}

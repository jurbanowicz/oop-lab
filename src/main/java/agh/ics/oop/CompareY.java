package agh.ics.oop;

import java.util.Comparator;

public class CompareY implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Animal) {
            if (o2 instanceof Animal) {
                // compare position values for animals
                return compareAnimals((Animal) o1, (Animal) o2);
            }
            else {
                // 1st is animal 2nd is grass
                return 1;
            }
            // 1st is not animal
        } else {
            if (o2 instanceof Animal) {
                // 1st is not animal, 2nd is animal
                return -1;
            }
        }
        // both are not animals
        return compareGrass((Grass) o1, (Grass) o2);
    }
    private int compareAnimals(Animal a1, Animal a2) {
        Vector2d vector1 = a1.getPosition();
        Vector2d vector2 = a2.getPosition();
        if (vector1.equals(vector2)) {
            return 0;
        }
        if (vector1.y > vector2.y) {
            return 1;
        } else if (vector1.y == vector2.y) {
            if (vector1.x > vector2.x) {
                return 1;
            } else {
                return -1;

            }
        } else {
            return -1;
        }
    }
    private int compareGrass(Grass g1, Grass g2) {
        Vector2d vector1 = g1.getPosition();
        Vector2d vector2 = g2.getPosition();
        if (vector1.equals(vector2)) {
            return 0;
        }
        if (vector1.y > vector2.y) {
            return 1;
        } else if (vector1.y == vector2.y) {
            if (vector1.x > vector2.x) {
                return 1;
            } else {
                return -1;

            }
        } else {
            return -1;
        }
    }
}

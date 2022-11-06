package agh.ics.oop;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void canMoveToTest() {
        String[] args = new String[]{"r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,2) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(3, 2)));
        assertTrue(map.canMoveTo(new Vector2d(4, 4)));
    }
    @Test
    public void isOccupiedTest() {
        String[] args = new String[]{"r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,2) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 2)));
        assertFalse(map.isOccupied(new Vector2d(4, 4)));
    }
    @Test
    public void ObjectAtTest() {
        String[] args = new String[]{"r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,2) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertInstanceOf(Animal.class, map.objectAt(new Vector2d(2, 2)));
        assertInstanceOf(Animal.class, map.objectAt(new Vector2d(3, 2)));
        assertEquals(null, map.objectAt(new Vector2d(4, 4)));
    }
    @Test
    public void Test_1() {
        String[] args = new String[]{"f", "b", "r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Animal animal1 = null;
        Animal animal2 = null;
        if (map.objectAt(new Vector2d(2, 3)) instanceof Animal) {
            animal1 = (Animal) map.objectAt(new Vector2d(2, 3));
        }
        if (map.objectAt(new Vector2d(3, 3)) instanceof Animal) {
            animal2 = (Animal) map.objectAt(new Vector2d(3, 3));
        }
        assertEquals("E", animal1.toString());
        assertEquals(new Vector2d(2, 3), animal1.getPosition());

        assertEquals("W", animal2.toString());
        assertEquals(new Vector2d(3, 3), animal2.getPosition());
    }
    @Test
    public void Test_2() {
        String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Animal animal1 = null;
        Animal animal2 = null;
        if (map.objectAt(new Vector2d(2, 0)) instanceof Animal) {
            animal1 = (Animal) map.objectAt(new Vector2d(2, 0));
        }
        if (map.objectAt(new Vector2d(3, 4)) instanceof Animal) {
            animal2 = (Animal) map.objectAt(new Vector2d(3, 4));
        }
        assertEquals("S", animal1.toString());
        assertEquals(new Vector2d(2, 0), animal1.getPosition());
        assertEquals("N", animal2.toString());
        assertEquals(new Vector2d(3, 4), animal2.getPosition());
    }
    @Test
    public void Test_3() {
        String[] args = new String[]{"f", "l", "f", "f", "l", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Animal animal1 = null;
        Animal animal2 = null;
        if (map.objectAt(new Vector2d(2, 4)) instanceof Animal) {
            animal1 = (Animal) map.objectAt(new Vector2d(2, 4));
        }
        if (map.objectAt(new Vector2d(3, 4)) instanceof Animal) {
            animal2 = (Animal) map.objectAt(new Vector2d(3, 4));
        }
        assertEquals("W", animal1.toString());
        assertEquals(new Vector2d(2, 4), animal1.getPosition());
        assertEquals("S", animal2.toString());
        assertEquals(new Vector2d(3, 4), animal2.getPosition());
    }
}

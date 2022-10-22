package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void testEquals() {
        Vector2d testVector = new Vector2d(1, 1);
        assertEquals(testVector, new Vector2d(1, 1));
        assertNotEquals(testVector, new Vector2d(0, 0));
        assertNotEquals(testVector, MapDirection.EAST);
    }

    @Test
    public void testToString() {
        Vector2d testVector = new Vector2d(1, 1);
        assertEquals("(1, 1)", testVector.toString());
    }

    @Test
    public void testPrecedes() {
        Vector2d testVector = new Vector2d(1, 1);
        assertTrue(testVector.precedes(new Vector2d(2, 2)));
        assertFalse(testVector.precedes(new Vector2d(0, 1)));
    }

    @Test
    public void testFollows() {
        Vector2d testVector = new Vector2d(1, 1);
        assertTrue(testVector.follows(new Vector2d(0, 1)));
        assertFalse(testVector.follows(new Vector2d(2, 2)));
    }

    @Test
    public void testUpperRight() {
        Vector2d testVector1 = new Vector2d(1, 1);
        Vector2d testVector2 = new Vector2d(3, 0);
        assertEquals(new Vector2d(3, 1), testVector1.upperRight(testVector2));
    }

    @Test
    public void testLowerLeft() {
        Vector2d testVector1 = new Vector2d(1, 1);
        Vector2d testVector2 = new Vector2d(3, 0);
        assertEquals(new Vector2d(1, 0), testVector1.lowerLeft(testVector2));
    }

    @Test
    public void testAdd() {
        Vector2d testVector1 = new Vector2d(1, 1);
        Vector2d testVector2 = new Vector2d(3, 0);
        assertEquals(new Vector2d(4, 1), testVector1.add(testVector2));
    }

    @Test
    public void testSubtract() {
        Vector2d testVector1 = new Vector2d(1, 1);
        Vector2d testVector2 = new Vector2d(3, 0);
        assertEquals(new Vector2d(-2, 1), testVector1.subtract(testVector2));
    }

    @Test
    public void testOpposite() {
        Vector2d testVector = new Vector2d(3, 1);
        assertEquals(new Vector2d(-3, -1), testVector.opposite());
    }
}

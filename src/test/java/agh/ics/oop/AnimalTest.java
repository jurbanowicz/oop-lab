package agh.ics.oop;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void OptionsParserTest_1() {
        boolean flag = false;
        try {
            String[] args = new String[]{"f", "f", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }catch (IllegalArgumentException e) {
            flag = true;
        }
        assertFalse(flag);

    }

    @Test
    // check if parser throws exception with incorrect input
    public void OptionParserTest_2() {
        boolean flag = false;
        try {
            String[] args = new String[]{"f", "x", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }catch (IllegalArgumentException e) {
            flag = true;
            System.out.println(e);
        }
        assertTrue(flag);
    }
    // chceck if place throws exception if given incorrect inputs
    @Test
    public void Test_3() {
        boolean flag = false;
        try {
            String[] args = new String[]{"f", "f", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 2)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }catch (IllegalArgumentException e) {
            flag = true;
            System.out.println(e);
        }
        assertTrue(flag);
    }
}

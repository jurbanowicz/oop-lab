package agh.ics.oop;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    // check if the animal stays within upper right boundries
    public void Test_1() {
        Animal animal = new Animal();

        String[] input = new String[]{"f", "f", "f", "f"};

        MoveDirection[] animalDirections = new OptionsParser().parse(input);

        for(MoveDirection direction: animalDirections) {
            animal.move(direction);
        }
        assertEquals("(2, 4)Północ", animal.toString());
    }

    @Test
    // check if the animal stays within lower left boundries
    public void Test_2() {
        Animal animal = new Animal();

        String[] input = new String[]{"l", "f", "f", "f", "f", "l", "f", "f", "f", "f"};

        MoveDirection[] animalDirections = new OptionsParser().parse(input);

        for(MoveDirection direction: animalDirections) {
            animal.move(direction);
        }
        assertEquals("(0, 0)Południe", animal.toString());
    }
    @Test
    // check if given some incorrect inputs
    public void Test_3() {
        Animal animal = new Animal();

        String[] input = new String[]{"x", "l", "x", "f", "x", "l"};

        MoveDirection[] animalDirections = new OptionsParser().parse(input);

        for(MoveDirection direction: animalDirections) {
            animal.move(direction);
        }
        assertEquals("(1, 2)Południe", animal.toString());
    }
    @Test
    // check position and direction
    public void Test_4() {
        Animal animal = new Animal();

        String[] input = new String[]{"r", "f", "l", "f", "r", "f", "l", "f"};

        MoveDirection[] animalDirections = new OptionsParser().parse(input);

        for(MoveDirection direction: animalDirections) {
            animal.move(direction);
        }
        assertEquals("(4, 4)Północ", animal.toString());
    }
}

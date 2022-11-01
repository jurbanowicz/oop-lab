package agh.ics.oop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OptionsParser {
    public MoveDirection[] parse(String[] directions) {
        int errors = 0;
        Set<String> possibleDirections = new HashSet<String>(Arrays.asList(
                "f", "forward", "b", "backward", "r", "right", "l", "left"));

        // count the number of incorrect inputs
        for (String direction: directions) {
            if (!(possibleDirections.contains(direction))) {
                errors++;
            }
        }
        // create an array with the correct number of inputs
        MoveDirection[] moveDirections = new MoveDirection[directions.length - errors];

        int curr_i = 0;
        for(int i = 0; i < directions.length; i++) {
            String direction = directions[i];
            switch (direction) {
                case "f", "forward" -> moveDirections[curr_i] = MoveDirection.FORWARD;
                case "b", "backward" -> moveDirections[curr_i] = MoveDirection.BACKWARD;
                case "r", "right" -> moveDirections[curr_i] = MoveDirection.RIGHT;
                case "l", "left" -> moveDirections[curr_i] = MoveDirection.LEFT;
                default -> curr_i--;
            }
            curr_i++;
        }
        return moveDirections;
    }
}

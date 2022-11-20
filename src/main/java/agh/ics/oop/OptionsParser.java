package agh.ics.oop;


import java.util.ArrayList;

public class OptionsParser {
    public MoveDirection[] parse(String[] directions) {
        ArrayList<MoveDirection> moveDirections = new ArrayList<>();

//        int curr_i = 0;
        for (String direction : directions) {
            switch (direction) {
                case "f", "forward" -> moveDirections.add(MoveDirection.FORWARD);
                case "b", "backward" -> moveDirections.add(MoveDirection.BACKWARD);
                case "r", "right" -> moveDirections.add(MoveDirection.RIGHT);
                case "l", "left" -> moveDirections.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(direction + " is invalid direction");
            }
//            curr_i++;
        }
        MoveDirection[] result = new MoveDirection[moveDirections.size()];
        return moveDirections.toArray(result);
    }
}

package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;

public class SimulationEngine implements IEngine{

    private final MoveDirection[] directions;
    private List<Animal> animals = new ArrayList<Animal>();

    private IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] startPositions) {
        this.directions = directions;
        this.map = map;

        for (Vector2d startingPosition: startPositions) {
            Animal animal = new Animal(map, startingPosition);
            if (map.place(animal)) {
                animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        int i = 0;

        for (MoveDirection currMove: directions) {
            animals.get(i).move(currMove, map);
            i++;
        }

    }
}

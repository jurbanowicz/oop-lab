package agh.ics.oop;

import javafx.application.Platform;

import java.util.List;
import java.util.ArrayList;


public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] directions;
    private final List<Animal> animals = new ArrayList<Animal>();
    private int moveDelay;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] startPositions) {
//        this.directions = directions;

        for (Vector2d startingPosition: startPositions) {
            Animal animal = new Animal(map, startingPosition);
            if (map.place(animal)) {
                animals.add(animal);
            }
        }
    }
    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }
    public void setMoveDelay(int moveDelay) {
        this.moveDelay = moveDelay;
    }
    @Override
    public void run() {
        System.out.println("Thread started.");
        int i = 0;

        for (MoveDirection currMove: directions) {
            try {
//                System.out.println("Time to sleep");
                Thread.sleep(moveDelay);
//                System.out.println("Wake up");
//                System.out.println(map);
            }catch (InterruptedException e) {
                System.out.println(e);
            }
            animals.get(i).move(currMove);
            // System.out.println("Animal " + i + " is moving " + currMove + " Curr animal position is: " +
            //        animals.get(i).getPosition());
//            System.out.println(map);
            i = (i + 1) % animals.size();

        }
    }
}

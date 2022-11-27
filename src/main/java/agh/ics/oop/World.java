package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;
import static java.lang.System.out;

import static agh.ics.oop.Direction.PossibleDirections;

public class World {
    public static void main(String[] args) {

        out.println("System wystartował");

        try {
            Application.launch(App.class, args);
        } catch (IllegalArgumentException e) {
            out.println(e);
        }
        out.println("System zakończył działanie");
    }
}



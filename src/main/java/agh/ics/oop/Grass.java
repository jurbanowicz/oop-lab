package agh.ics.oop;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Grass extends AbstractMapElement{
    private Vector2d position;
    public Grass(Vector2d position) {
        this.position = position;
    }
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String toString() {
        return "*";
    }
    public ImageView getImage() {
        return getGrass();
    }
}

package agh.ics.oop;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AbstractMapElement implements IMapElement{
    private ImageView animalN;
    private ImageView animalE;
    private ImageView animalS;
    private ImageView animalW;
    private ImageView grass;
    public AbstractMapElement() {
        try {
        animalN = new ImageView(new Image(new FileInputStream("src/main/resources/pixel_frog_up.png")));
        animalE = new ImageView(new Image(new FileInputStream("src/main/resources/pixel_frog_right.png")));
        animalS = new ImageView(new Image(new FileInputStream("src/main/resources/pixel_frog_down.png")));
        animalW = new ImageView(new Image(new FileInputStream("src/main/resources/pixel_frog_left.png")));
        grass = new ImageView(new Image(new FileInputStream("src/main/resources/pixel_grass_2.png")));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    @Override
    public ImageView getAnimalN() {
        return animalN;
    }
    @Override
    public ImageView getAnimalE() {
        return animalE;
    }
    @Override
    public ImageView getAnimalS() {
        return animalS;
    }
    @Override
    public ImageView getAnimalW() {
        return animalW;
    }
    @Override
    public ImageView getGrass() {
        return grass;
    }
}
package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.Grass;
import agh.ics.oop.IMapElement;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
public class GuiElementBox {
    ImageView imageView;
    VBox vBox;
    public GuiElementBox(IMapElement object){
        if (object instanceof Animal) {
            imageView = ((Animal) object).getImage();
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            Label label = new Label(((Animal) object).getPosition().toString());
            vBox = new VBox();
            vBox.getChildren().addAll(imageView, label);
        } else {
            imageView = ((Grass) object).getImage();
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            Label label = new Label("Grass");
            vBox = new VBox();
            vBox.getChildren().addAll(imageView, label);
        }
    }
}

package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static java.lang.System.out;

public class App extends Application implements IMapObserver {
    private IWorldMap map;
    private Thread engineThread;
    private GridPane gridPane;
    private SimulationEngine engine;
    @Override
    public void init() throws Exception {

        String[] args = getParameters().getRaw().toArray(new String[0]);
//        args = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        map = new GrassField(10);
        ((GrassField) map).addObserver(this);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        engine = new SimulationEngine(directions, map, positions);
        engine.setMoveDelay(200);
        runDirections(args);
    }
    private void runDirections(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        engine.setDirections(directions);
        engineThread = new Thread(engine);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Grid Testing");
        Button startButton = new Button("Start Simulation");
        gridPane = new GridPane();
        TextField inputs = new TextField();
        VBox box = new VBox(startButton, inputs, gridPane);
        Scene scene = new Scene(box, 600, 600);
        drawMap(gridPane);
        startButton.setOnAction(event -> {
            String moves = inputs.getText();
            if (moves.length() > 0) {
                runDirections(moves.split(" "));
                //draw initial position
                drawMap(gridPane);
            }
            engineThread.start();
        });
        primaryStage.setScene(scene);
        primaryStage.show();
        }
    /**
     * Fills the grid pane with header, labels and elements from map
     * @param gridPane grid to be filled with elements from the map
     */
    private void drawMap(GridPane gridPane) {
        gridPane.setGridLinesVisible(false);
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getChildren().clear();
        gridPane.setGridLinesVisible(true);

        AbstractWorldMap abstractWorldMap = (AbstractWorldMap) map;

        gridPane.add(new Text(" y\\x "), 0, 0, 1, 1);
        gridPane.getColumnConstraints().add(new ColumnConstraints(25));
        gridPane.getRowConstraints().add(new RowConstraints(25));

        Vector2d lowL = abstractWorldMap.findLowLeft();
        Vector2d hiR = abstractWorldMap.findUpperRight();

        // Label the columns
        for (int i = 1; i <= hiR.x - lowL.x + 1; i++) {
            Label label = new Label(Integer.toString(lowL.x + i - 1));
            gridPane.add(label, i, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(40));
            GridPane.setHalignment(label, HPos.CENTER);
        }
        // Label the rows
        for (int i = 1; i <= hiR.y - lowL.y + 1; i++) {
            Label label = new Label(Integer.toString(hiR.y - i + 1));
            gridPane.add(label, 0, i, 1, 1);
            gridPane.getRowConstraints().add(new RowConstraints(40));
            GridPane.setHalignment(label, HPos.CENTER);
        }
        // Fill the grid with map items
        for (int i = 1; i <= hiR.x - lowL.x + 1; i++) {
            for (int j = 1; j <= hiR.y - lowL.y + 1; j++) {
                if (map.isOccupied(new Vector2d(lowL.x + i - 1,hiR.y - j + 1))) {
                    VBox box = getObject(new Vector2d(lowL.x + i - 1, hiR.y - j + 1));
                    box.setAlignment(Pos.CENTER);
                    gridPane.add(box, i, j, 1, 1);
                    GridPane.setHalignment(box, HPos.CENTER);
                }
            }
        }
    }
    /**
     * Returns string of object at currentPosition on the map
     * @param currentPosition vector with position to be checked on the map
     * @return string representation of object at currPosition
     */
    private VBox getObject(Vector2d currentPosition){
        Object object = map.objectAt(currentPosition);
        GuiElementBox box = new GuiElementBox((IMapElement) object);
        return box.vBox;
    }
    @Override
    public void positionChanged() {
        Platform.runLater(() -> {
            drawMap(gridPane);
        });
    }
}

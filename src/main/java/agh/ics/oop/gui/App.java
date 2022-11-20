package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.lang.System.out;

public class App extends Application {
    private IWorldMap map;
    @Override
    public void init() throws Exception {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        out.println(map);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Grid Testing");
//        Label label = new Label("Zwierzak");
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 600, 600);
//        Button button1 = new Button("Click me!");
//        gridPane.add(button1, 0, 0, 1, 1);

//        String[] args = getParameters().getRaw().toArray(new String[0]);
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new GrassField(10);
//        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        out.println(map);

        drawMap(gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Fills the grid pane with header, labels and elements from map
     * @param gridPane grid to be filled with elements from the map
     */
    private void drawMap(GridPane gridPane) {
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

        //
        for (int i = 1; i <= hiR.x - lowL.x + 1; i++) {
            for (int j = 1; j <= hiR.y - lowL.y + 1; j++) {
                Label label = new Label(getObject(new Vector2d(lowL.x + i - 1,hiR.y - j + 1)));
                gridPane.add(label, i, j, 1, 1);
                gridPane.setHalignment(label, HPos.CENTER);
                label.setFont(new Font(30));
            }
        }
    }

    /**
     * Returns string of object at currentPosition on the map
     * @param currentPosition vector with position to be checked on the map
     * @return string representation of object at currPosition
     */
    private String getObject(Vector2d currentPosition) {
        String result = null;
        if (map.isOccupied(currentPosition)) {
            Object object = map.objectAt(currentPosition);
            if (object != null) {
                result = object.toString();
            } else {
                result = "";
            }
        } else {
            result = "";
        }
        return result;
    }
}

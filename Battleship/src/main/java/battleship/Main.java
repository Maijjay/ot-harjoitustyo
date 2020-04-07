package battleship;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage window) throws FileNotFoundException {
        Grid grid = new Grid();
        VBox startBox = new VBox();
        Button startButton = new Button("Start Game");
        startBox.getChildren().add(startButton);

        Scene startScene = new Scene(startBox);
        Scene gridScene = new Scene(grid.setUpGrid());

        startButton.setOnAction(event -> {
            window.setScene(gridScene);
        });

        window.setMinHeight(600);
        window.setMinWidth(600);
        window.setTitle("Battleships");
        window.setScene(startScene);
        window.show();

    }
}

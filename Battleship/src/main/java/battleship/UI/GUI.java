package battleship.UI;

import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class GUI extends Button{
    GridPane layout;
    
    public GUI() throws FileNotFoundException {
        Stage window = new Stage();
        this.layout = new GridPane();
        this.makeGrid();
        this.start(window);        
    }

    
    public void start(Stage window) throws FileNotFoundException {
        VBox startBox = new VBox();
        Button startButton = new Button("Start Game");
        startBox.getChildren().add(startButton);

        Scene startScene = new Scene(layout);


        window.setMinHeight(600);
        window.setMinWidth(600);
        window.setTitle("Battleships");
        window.setScene(startScene);
        window.show();

    }
    public void makeGrid(){
        for (int i = 0 ; i < 10 ; i++){
            for (int y = 0 ; y < 10 ; y++){
                this.layout.add(new Button(), i, y);
            }
        }
    }

    public void render() {
        
    }
    
    public void turnClick(){
        
    }

 
}

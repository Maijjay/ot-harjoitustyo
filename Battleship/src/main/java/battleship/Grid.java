package battleship;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.layout.GridPane;

public class Grid {

    private GridPane layout;
    ArrayList<Ship> p1Ships;

    GameState state;

    public Grid() {
       
        this.p1Ships = new ArrayList<>();
        this.initializeShipsList();
        layout = new GridPane();
        this.state = new GameState();
    }

    public void initializeShipsList() {
        p1Ships.add(new Ship(0, 0, 1, true));
        p1Ships.add(new Ship(0, 1, 1, true));
        p1Ships.add(new Ship(0, 2, 2, true));
//       p1Ships.add(2);
//       p1Ships.add(3);
//       p1Ships.add(3);

    }

    public GridPane setUpGrid() {
        layout.setHgap(2);
        layout.setVgap(2);
        layout.setMinSize(200, 200);

        for (int x = 0; x < state.getWidth(); x++) {
            for (int y = 0; y < state.getHeight(); y++) {
                Cell cell = new Cell(x, y, state);
                state.grid[x][y] = cell;
                layout.add(cell, x, y);
            }
        }
        this.setShip();
        return layout;
    }

    public void setShip() {
        for (Ship ship : p1Ships) {
            if (ship.horizontal == true) {
                for (int i = 0; i < ship.size; i++) {
                    state.grid[ship.x + i][ship.y].p1Ship = ship;
                }
            } else {
                for (int i = 0; i < ship.size; i++) {
                    state.grid[ship.x][ship.y + i].p1Ship = ship;
                }
            }
        }
    }

    //    public void killShip(Ship ship) {
    //
    //    }

    
    
    
}

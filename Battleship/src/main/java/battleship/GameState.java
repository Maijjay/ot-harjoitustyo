package battleship;

import java.util.Random;

public class GameState {

    Cell[][] grid;
    int currentPlayer;

    public GameState() {
        this.grid = new Cell[10][10];
        this.determineFirstTurn();
    }

    public void determineFirstTurn() {
        Random r = new Random();
        int number = r.nextInt(2);
        if (number == 0) {
            currentPlayer = 1;
        } else if (number == 1) {
            currentPlayer = 2;
        }
    }

    public void changeTurn() {
        if (this.currentPlayer == 1) {
            this.currentPlayer = 2;
        } else {
            this.currentPlayer = 1;
        }
        for (Cell[] c : grid) {
            for (Cell t : c) {
                t.render();
            }
        }

    }

//    public void win() {
//
//    }

}

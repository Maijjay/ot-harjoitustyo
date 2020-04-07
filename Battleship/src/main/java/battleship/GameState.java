package battleship;

import java.util.Random;

public class GameState {

    Cell[][] grid;
    int currentPlayer;
    int height;
    int width;

    public GameState() {
        this.width = 10;
        this.height = 10;
        this.grid = new Cell[this.width][this.height];
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
        for (Cell[] c : grid) {
            for (Cell t : c) {
                t.render();
            }
        }
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
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public int getCurrentPlayer() {
        return currentPlayer;
    }
}

package battleship.GameState;

import battleship.UI.GUI;
import battleship.User.Player;
import java.io.FileNotFoundException;
import java.util.Random;

public class State {

    int turn;
    int currentPlayer;
    Player p1;
    Player p2;
    GUI gui;

    public State() throws FileNotFoundException {
        //gui = new GUI();
        this.p1 = new Player();
        this.p2 = new Player();
        this.currentPlayer = this.determineFirstTurn();
        this.firstTurn();
        this.turn();

    }

    public int determineFirstTurn() {
        Random r = new Random();
        int number = r.nextInt(2);
        if (number == 0) {
            return 1;
        }
        return 2;
    }

    public void firstTurn() {
        System.out.println("Both players will insert 4 ships to the grid:"
                + "\n   The ships will be sized 1, 2, 3, and 4. Coordinates x and y represent the ships starting point in the grid. "
                + "\n   If you want the ship to be in horizontal position insert true and false if in vertical.\n \n");
        if (currentPlayer == 1) {
            System.out.println("Player 1 set up.");
            p1.initializeShips();
            System.out.println("Player 2 set up.");
            p2.initializeShips();
        } else {
            System.out.println("Player 2 set up.");
            p2.initializeShips();
            System.out.println("Player 1 set up.");
            p1.initializeShips();

        }

    }

    public void changeTurn() {
        if (this.currentPlayer == 1) {
            this.currentPlayer = 2;
        } else {
            this.currentPlayer = 1;
        }
        turn();
    }

    public void turn() {
        if (this.currentPlayer == 1) {
            System.out.println("Player 1's turn");
            boolean newTurn = p2.hit();
            while (newTurn) {
                p2.getGrid().soutGrid();
                if (p2.getGrid().getShipsLeft() == 0) {
                    System.out.println("-- Player 1 WINS --");
                    return;
                }
                newTurn = p2.hit();
            }
            this.changeTurn();
        } else {
            System.out.println("Player 2's turn");
            boolean newTurn = p1.hit();
            while (newTurn) {
                p1.getGrid().soutGrid();
                if (p1.getGrid().getShipsLeft() == 0) {
                    System.out.println("-- Player 2 WINS --");
                    return;
                }
                newTurn = p1.hit();

            }
            this.changeTurn();
        }

    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

}
//    public void changeTurn() {
//        for (Cell[] c : grid) {
//            for (Cell t : c) {
//                t.render();
//            }
//        }
//        if (this.currentPlayer == 1) {
//            this.currentPlayer = 2;
//        } else {
//            this.currentPlayer = 1;
//        }
//        for (Cell[] c : grid) {
//            for (Cell t : c) {
//                t.render();
//            }
//        }
//
//    }
//public void turn() {
//        this.setOnAction((event) -> {
//            if (this.state.currentPlayer == 1) {
//                System.out.println("1");
//                this.p1Hit = true;
//                if (p1Hit == true && p2Ship != null) {
//                    p2Ship.hit();
//                    this.setText("1X");
//                    if (p2Ship.isAlive == false) {
//                        this.setText("Sunk");
//                    }
//                } else {
//                    this.setText("1O");
//                    this.state.changeTurn();
//                }
//            } else if (this.state.currentPlayer == 2) {
//                System.out.println("2");
//                this.p2Hit = true;
//                if (p2Hit == true && p1Ship != null) {
//                    p1Ship.hit();
//                    this.setText("X");
//                    if (p1Ship.isAlive == false) {
//                        this.setText("Sunk");
//                    }
//                } else {
//                    this.setText("O");
//                    this.state.changeTurn();
//                }
//            }
//        });
//
//    }
//
//    public void render() {
//        if (state.currentPlayer == 1) {
//            if (p2Hit == false) {
//                this.setText("");
//            } else if (p2Hit == true && this.p2Ship == null) {
//                this.setText("O");
//            } else if (p2Hit == true && this.p2Ship != null) {
//                this.setText("X");
//            }
//        } else if (state.currentPlayer == 2) {
//            if (p1Hit == false) {
//                this.setText("");
//            } else if (p1Hit == true && this.p1Ship == null) {
//                this.setText("O");
//            } else if (p1Hit == true && this.p1Ship != null) {
//                this.setText("X");
//            }
//        }
//    }
//
//    public void setShip(Ship s) {
//        this.setOnAction(event -> {
//
//        });
//
//        p1Ship = s;
//        this.setText("S");
//    }

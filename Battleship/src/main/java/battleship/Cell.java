package battleship;

import javafx.scene.control.Button;

public class Cell extends Button {

    int x;
    int y;
    Ship p1Ship;
    Ship p2Ship;
    boolean p1Hit;
    boolean p2Hit;
    GameState state;

    public Cell(int x, int y, GameState s) {
        this.setMinHeight(50);
        this.setMinWidth(50);
        this.state = s;
        this.x = x;
        this.y = y;
        turn();
    }

    public void turn() {
        this.setOnAction((event) -> {
            if (this.state.currentPlayer == 1) {
                System.out.println("1");
                this.p1Hit = true;
                if (p1Hit == true && p2Ship != null) {
                    p2Ship.hit();
                    this.setText("1X");
                    if (p2Ship.isAlive == false) {
                        this.setText("Sunk");
                    }
                } else {
                    this.setText("1O");
                    this.state.changeTurn();
                }
            } else if (this.state.currentPlayer == 2) {
                System.out.println("2");
                this.p2Hit = true;
                if (p2Hit == true && p1Ship != null) {
                    p1Ship.hit();
                    this.setText("X");
                    if (p1Ship.isAlive == false) {
                        this.setText("Sunk");
                    }
                } else {
                    this.setText("O");
                    this.state.changeTurn();
                }
            }
        });

    }

    public void render() {
        if (state.currentPlayer == 1) {
            if (p2Hit == false) {
                this.setText("");
            } else if (p2Hit == true && this.p2Ship == null) {
                this.setText("O");
            } else if (p2Hit == true && this.p2Ship != null) {
                this.setText("X");
            }
        } else if (state.currentPlayer == 2) {
            if (p1Hit == false) {
                this.setText("");
            } else if (p1Hit == true && this.p1Ship == null) {
                this.setText("O");
            } else if (p1Hit == true && this.p1Ship != null) {
                this.setText("X");
            }
        }
    }

    public void setShip(Ship s) {
        this.setOnAction(event -> {

        });

        p1Ship = s;
        this.setText("S");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

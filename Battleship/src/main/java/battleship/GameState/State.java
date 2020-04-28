package battleship.gamestate;

import battleship.user.Player;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * State class keeps track of the state of the game and handles the turns, it
 * has two players (Player class) and knowledge of the turn.
 */
public final class State {

    private int turn;
    private int currentPlayer;
    private final Player p1;
    private final Player p2;

    public State() throws FileNotFoundException {
        this.p1 = new Player();
        this.p2 = new Player();
        this.currentPlayer = this.determineFirstTurn();
        this.firstTurn();
        this.turn();
    }

    public State(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.currentPlayer = this.determineFirstTurn();
    }

    /**
     * Determines at random which player starts
     *
     * @return 1 if player1 starts ans 2 if player2 starts
     */
    public int determineFirstTurn() {
        Random r = new Random();
        int number = r.nextInt(2);
        if (number == 0) {
            return 1;
        }
        return 2;
    }

    /**
     * Prints the instructions for inserting ships and calls for method
     * initializeShips in Players class.
     */
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

    /**
     * Changes the players turn
     */
    public void changeTurn() {
        if (this.currentPlayer == 1) {
            this.currentPlayer = 2;
        } else {
            this.currentPlayer = 1;
        }
        for (int i = 0; i < 15; i++) {
            System.out.println(" ");
        }
        turn();
    }

    /**
     * Handles the turns of the players, prints whose turn it is and keeps their
     * turn as long as they hit ships, this method uses the Player class hit
     * method, if player.hit returns false the turn changes.
     */
    public void turn() {
        if (this.currentPlayer == 1) {
            System.out.println("Player 1's turn");
            p2.getGrid().soutGrid();
            boolean newTurn = p2.askCoordinatesForTheHit();
            while (newTurn) {
                p2.getGrid().soutGrid();
                if (p2.getGrid().getShipsLeft() == 0) {
                    System.out.println("-- Player 1 WINS --");
                    return;
                }
                newTurn = p2.askCoordinatesForTheHit();
            }
            this.changeTurn();
        } else {
            System.out.println("Player 2's turn");
            p1.getGrid().soutGrid();
            boolean newTurn = p1.askCoordinatesForTheHit();
            while (newTurn) {
                p1.getGrid().soutGrid();
                if (p1.getGrid().getShipsLeft() == 0) {
                    System.out.println("-- Player 2 WINS --");
                    return;
                }
                newTurn = p1.askCoordinatesForTheHit();
            }
            this.changeTurn();
        }
    }

    /**
     * @return Number of the current player
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @return Prints the turn of the player
     */
    public String getTurn() {
        if (this.currentPlayer == 1) {
            return "Turn of player 1";
        } else {
            return "Turn of player 2";
        }
    }

}

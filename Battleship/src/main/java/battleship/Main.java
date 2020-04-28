package battleship;

import battleship.GameState.State;
import java.io.FileNotFoundException;
/**
     * Main class of the game, prints starting instructions.
     */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to battleships."
                + "\n");
        System.out.println("Instructions: "
                + "\n1. In order to play you need two players."
                + "\n2. The game will randomly select which player starts."
                + "\n3. Starting player will insert ships first. "
                + "\n   -- Please insert stats of the ship strictly as instructed --"
                + "\n4. The grid is sized 10x10 and coordinates go from [0, 0] to [9, 9]");
        System.out.println("\n \n");
        State s = new State();

    }

}

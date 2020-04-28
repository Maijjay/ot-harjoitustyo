package battleship.user;

import battleship.board.Grid;
import java.util.Scanner;

/**
 * Player has two grids, their own and the other players grid and methods
 * initializeShip and hit.
 */
public class Player {

    private final Grid grid;
    private final Grid ownGrid;
    private final Scanner scanner;
    private int shipSize;

    public Player() {
        this.scanner = new Scanner(System.in);
        this.shipSize = 1;
        this.grid = new Grid(10, 10);
        this.ownGrid = new Grid(10, 10);

    }

    /**
     * Initializes ships by asking the player the first coordinates of the ship
     * and whether the it's horizontal or not, player puts five ships in the
     * grid, also checks that the given input is correct.
     */
    public void initializeShips() {

        System.out.println("\nInsert ship. Input: x y horizontal. Example: 1 2 true. Ships length is " + this.shipSize + ".");
        int x = -1;
        int y = -1;
        boolean horizontal;

        while (true) {
            String ship = scanner.nextLine();
            String[] split = ship.split(" ");

            if (!split[0].matches("9|0|1|2|3|4|5|6|7|8")) {
                System.out.println("The x you inserted is not a number between 0 and 9. Try again.");
            } else if (!split[1].matches("9|0|1|2|3|4|5|6|7|8")) {
                System.out.println("The y you inserted is not a number between 0 and 9. Try again.");
            } else if (!split[2].matches("true|false")) {
                System.out.println("The value of horizontal was incorrect, you need to insert either true on false. Try again.");
            } else {
                x = Integer.parseInt(split[0]);
                y = Integer.parseInt(split[1]);
                horizontal = Boolean.parseBoolean(split[2]);
                this.setNewShip(x, y, horizontal);
                break;
            }
        }
    }

    /**
     * Sets the ship in the grid if there is empty space to do so.
     *
     * @param x
     * @param y
     * @param horizontal
     */
    public void setNewShip(int x, int y, boolean horizontal) {
        if (grid.addShip(x, y, shipSize, horizontal) == true) {
            boolean t = this.ownGrid.addShip(x, y, shipSize, horizontal);
            System.out.println("Ship added");
            this.ownGrid.setUpOwnGrid();
            this.ownGrid.soutGrid();
            this.shipSize++;

            if (this.shipSize <= 5) {
                this.initializeShips();
            }
        } else {
            System.out.println("\n-- Ship you tried to insert is over grid or there is already a ship. Try again. --\n");
            this.initializeShips();
        }
    }

    /**
     * Asks the player coordinates x and y and proceeds to check if the input is
     * correct.
     *
     * @return True if hit was successful
     */
    public boolean askCoordinatesForTheHit() {
        System.out.println("Give coordinates:");
        int x = -1;
        int y = -1;
        while (true) {
            System.out.print("Insert x: ");
            String temp = scanner.nextLine();
            if (temp.matches("9|0|1|2|3|4|5|6|7|8")) {
                x = Integer.parseInt(temp);
                break;
            } else {
                System.out.println("The x you inserted is not a number between 0 and 9. Try again");
            }
        }
        while (true) {
            System.out.print("Insert y: ");
            String temp = scanner.nextLine();
            if (temp.matches("9|0|1|2|3|4|5|6|7|8")) {
                y = Integer.parseInt(temp);
                break;
            } else {
                System.out.println("The x you inserted is not a number between 0 and 9. Try again");
            }
        }
        return this.hit(x, y);
    }

    /**
     * Checks whether the square is already hit, if not the proceeds to hit the
     * square in the grid.
     *
     * @param x
     * @param y
     * @return true if given coordinates are correct and square has not yet been
     * hit
     */
    public boolean hit(int x, int y) {
        if (grid.isSquareHit(x, y) == false) {
            System.out.println("You have already hit this square, try again");
            this.askCoordinatesForTheHit();
        }
        return grid.hit(x, y);
    }

    /**
     * @return Grid
     */
    public Grid getGrid() {
        return grid;
    }

    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

}

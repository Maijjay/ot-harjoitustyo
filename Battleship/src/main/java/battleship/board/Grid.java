package battleship.board;

import java.util.ArrayList;

/**
 * Grid sized 10x10, knows which squares has ships and if the squares are hit or
 * not.
 */
public final class Grid {

    private String[][] grid;
    private ArrayList<Ship> ships;
    private ArrayList<int[]> hitCoordinates;

    private int shipsLeft;
    private int width;
    private int height;

    public Grid(int w, int h) {
        this.ships = new ArrayList<>();
        this.hitCoordinates = new ArrayList<>();
        this.width = w;
        this.height = h;
        this.grid = new String[w][h];
        this.shipsLeft = 0;
        this.setUpGrid();

    }

    /**
     * Adds a new ship to the grid
     *
     * @param x
     * @param y
     * @param size
     * @param horizontal
     * @return True if the ship was added successfully
     */
    public boolean addShip(int x, int y, int size, boolean horizontal) {
        if (x >= 0 && x <= 9) {
            if (y >= 0 && y <= 9) {
                if (!ships.stream().noneMatch((ship) -> (!ship.getCoordinates().stream().noneMatch((i) -> (i[0] == x && i[1] == y || i[0] == y && i[1] == x))))) {
                    return false;
                }
                if (horizontal == true && size + x < 9) {
                    ships.add(new Ship(x, y, size, horizontal));
                    shipsLeft++;
                    return true;
                } else if (horizontal == false && size + y < 9) {
                    ships.add(new Ship(x, y, size, horizontal));
                    shipsLeft++;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sets up players own grid and puts "1" in the coordinates that has a ship.
     */
    public void setUpOwnGrid() {
        for (Ship s : ships) {
            for (int[] i : s.getCoordinates()) {
                this.grid[i[0]][i[1]] = " 1 ";
            }
        }
    }

    /**
     * Sets up grid.
     */
    public void setUpGrid() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                this.grid[x][y] = " _ ";
            }
        }
    }

    /**
     * Prints the grid.
     */
    public void soutGrid() {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid.length; x++) {
                System.out.print(grid[x][y]);
            }
            System.out.println("");

        }
    }

    /**
     * @return Returns grid (matrix)
     */
    public String[][] getGrid() {
        return grid;
    }

    /**
     * @return How many ships the player has left
     */
    public int getShipsLeft() {
        return shipsLeft;
    }

    /**
     * Checks if square is hit
     *
     * @param x
     * @param y
     * @return True if square is not hit
     */
    public boolean isSquareHit(int x, int y) {
        return this.grid[x][y].equals(" _ ");
    }

    /**
     * Hits the square with given coordinates, if the other players ship is in
     * that square takes one health from the ship and puts "X" in the square if
     * you hit, "O" if you miss.
     *
     * @param x coordinate x
     * @param y coordinate y
     * @return True if player hits the ship
     */
    public boolean hit(int x, int y) {
        if (this.grid[x][y].equals(" _ ")) {
            for (Ship ship : ships) {
                for (int[] i : ship.getCoordinates()) {
                    if (i[0] == x && i[1] == y || i[0] == y && i[1] == x) {
                        System.out.println("You hit!");
                        ship.hit();
                        this.grid[x][y] = " X ";

                        if (ship.getIsAlive() == false) {
                            this.shipsLeft--;
                        }
                        return true;
                    }
                }
            }
        }
        System.out.println("You missed!");
        this.grid[x][y] = " O ";
        return false;
    }

    /**
     * @return List of coordinates that has been hit
     */
    public ArrayList<int[]> getHitCoordinates() {
        return hitCoordinates;
    }

    /**
     * @return Height of the grid
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return Width of the grid
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return List of ships
     */
    public ArrayList<Ship> getShips() {
        return ships;
    }

}

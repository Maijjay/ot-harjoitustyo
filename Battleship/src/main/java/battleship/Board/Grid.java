package battleship.Board;

import java.util.ArrayList;

public class Grid {

    private String[][] grid;
    private ArrayList<Ship> ships;
    ArrayList<int[]> hitCoordinates;

    private int shipsLeft;
    private int widht;
    private int height;

    public Grid(int w, int h) {
        this.ships = new ArrayList<>();
        this.hitCoordinates = new ArrayList<>();
        this.widht = w;
        this.height = h;
        this.grid = new String[w][h];
        this.shipsLeft = 0;
        this.setUpGrid();

    }

    public boolean addShip(int x, int y, int size, boolean horizontal) {
        if (x >= 0 && x <= 9) {
            if (y >= 0 && y <= 9) {
                for (Ship ship : ships) {
                    for (int[] i : ship.coordinates) {
                        if (i[0] == x && i[1] == y || i[0] == y && i[1] == x) {
                            return false;
                        }
                    }
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

    public void setUpGrid() {
        for (int x = 0; x < this.widht; x++) {
            for (int y = 0; y < this.height; y++) {
                this.grid[x][y] = "_";
            }
        }

    }

    public void soutGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int y = 0; y < grid.length; y++) {
                System.out.print(grid[i][y]);
            }
            System.out.println("");
        }
    }

    public String[][] getGrid() {
        return grid;
    }

    public int getShipsLeft() {
        return shipsLeft;
    }

    public boolean isSquareHit(int x, int y) {
        return this.grid[x][y].equals("_");
    }

    public boolean hit(int x, int y) {
        if (this.grid[x][y].equals("_")) {
            for (Ship ship : ships) {
                for (int[] i : ship.coordinates) {
                    if (i[0] == x && i[1] == y || i[0] == y && i[1] == x) {
                        ship.hit();
                        this.grid[x][y] = "X";
                        if (ship.isAlive == false) {
                            shipsLeft--;
                        }
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public ArrayList<int[]> getHitCoordinates() {
        return hitCoordinates;
    }

    public int getHeight() {
        return height;
    }

    public int getWidht() {
        return widht;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

}

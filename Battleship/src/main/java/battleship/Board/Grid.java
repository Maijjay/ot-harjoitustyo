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

    public void addShip(int x, int y, int size, boolean horizontal) {
        ships.add(new Ship(x, y, size, horizontal));
        shipsLeft++;
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

//    public boolean isHit(int x, int y) {
//        for (int[] i : this.hitCoordinates) {
//            if (i[0] == x && i[1] == y || i[0] == y && i[1] == x) {
//                System.out.println("Coordinate is already hit");
//                return true;
//            }
//        }
//        this.hitCoordinates.add(new int[2])[0] = 1;
//    }
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

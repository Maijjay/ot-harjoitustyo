package battleship.board;

import java.util.ArrayList;

/**
 * Ship represents a single ship that has size, coordinates and information if
 * the ship has sunk or not.
 */
public final class Ship {

    private final int x;
    private final int y;
    private final int size;
    private int health;
    private final boolean horizontal;
    private boolean isAlive;
    private final ArrayList<int[]> coordinates;

    public Ship(int x, int y, int size, boolean horizontal) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.coordinates = new ArrayList<>();
        this.horizontal = horizontal;
        this.health = size;
        this.isAlive = true;
        this.setCoordinates();
    }

    /**
     * Sets all coordinates of the ship to list of arrays.
     */
    public void setCoordinates() {
        for (int i = 0; i < this.size; i++) {
            this.coordinates.add(new int[2]);
        }
        if (this.horizontal == true) {
            for (int i = 0; i < this.size; i++) {
                this.coordinates.get(i)[0] = x + i;
                this.coordinates.get(i)[1] = y;
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                this.coordinates.get(i)[0] = x;
                this.coordinates.get(i)[1] = y + i;
            }
        }
    }

    /**
     * Decreases ships health by 1 and checks if the ship has sunk.
     */
    public void hit() {
        if (health > 0) {
            this.health = this.health - 1;
        }
        if (health == 0) {
            sink();
            System.out.println("Ship has sunk");
        }
    }

    /**
     * @return Has the ship sunk
     */
    public boolean sink() {
        return this.isAlive = false;
    }

    /**
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * @return Size of the ship (length)
     */
    public int getSize() {
        return size;
    }

    /**
     * @return Health of the ship
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return True if ship is horizontal
     */
    public boolean getHorizontal() {
        return horizontal;
    }

    /**
     * @return Whether the ship is alive
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * @return List of coordinates
     */
    public ArrayList<int[]> getCoordinates() {
        return coordinates;
    }

}

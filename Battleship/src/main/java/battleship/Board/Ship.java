package battleship.Board;

import java.util.ArrayList;

public final class Ship {

    int x;
    int y;
    int size;
    int health;
    boolean horizontal;

    boolean isAlive;
    ArrayList<int[]> coordinates;

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

    public void hit() {

        if (health > 0) {
            this.health = this.health - 1;
        }
        if (health == 0) {
            sink();
            System.out.println("Ship has sunk");
        }
    }

    public boolean sink() {
        return this.isAlive = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getHealth() {
        return health;
    }

    public boolean getHorizontal() {
        return horizontal;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public ArrayList<int[]> getCoordinates() {
        return coordinates;
    }

}

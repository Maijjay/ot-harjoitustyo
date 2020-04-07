package battleship;

public class Ship {

    int x;
    int y;
    int size;
    boolean horizontal;
    int health;
    boolean isAlive;

    public Ship(int x, int y, int size, boolean horizontal) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.horizontal = horizontal;
        this.health = size;
        this.isAlive = true;
    }

    public void hit() {
        if (health > 0) {
            this.health = this.health -1;
        }
        if (health == 0) {
            sink();
        }
    }

    public boolean sink() {
        return this.isAlive = false;
    }

}

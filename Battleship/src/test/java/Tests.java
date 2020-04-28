
import battleship.board.Grid;
import battleship.board.Ship;
import battleship.gamestate.State;
import battleship.user.Player;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    State state;

    public Tests() {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        //this.state = new State();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void shipSetsCorrectConstuctorValues() {
        Ship s = new Ship(0, 2, 3, true);
        assertEquals(0, s.getX());
        assertEquals(2, s.getY());
        assertEquals(3, s.getSize());
        assertTrue(s.getHorizontal());
    }

    @Test
    public void shipSetsUpCorrectHealth() {
        Ship s = new Ship(0, 2, 3, true);
        assertEquals(3, s.getHealth());
    }

    @Test
    public void shipHasCorrectCoordinates() {
        Ship s = new Ship(0, 0, 3, true);
        s.setCoordinates();
        ArrayList<int[]> testList = s.getCoordinates();

        assertEquals(0, testList.get(0)[0]);
        assertEquals(0, testList.get(0)[1]);
        assertEquals(1, testList.get(1)[0]);
        assertEquals(0, testList.get(1)[1]);
        assertEquals(2, testList.get(2)[0]);
        assertEquals(0, testList.get(2)[1]);

        Ship t = new Ship(0, 0, 3, false);
        t.setCoordinates();
        testList = t.getCoordinates();

        assertEquals(0, testList.get(0)[0]);
        assertEquals(0, testList.get(0)[1]);
        assertEquals(0, testList.get(1)[0]);
        assertEquals(1, testList.get(1)[1]);
        assertEquals(0, testList.get(2)[0]);
        assertEquals(2, testList.get(2)[1]);
    }

    @Test
    public void shipHitdecreasesHealth() {
        Ship s = new Ship(0, 0, 3, true);
        assertEquals(3, s.getHealth());
        s.hit();
        assertEquals(2, s.getHealth());
    }

    @Test
    public void shipCannotHaveNegativeHealth() {
        Ship s = new Ship(0, 0, 1, true);
        s.hit();
        s.hit();
        s.hit();
        assertEquals(0, s.getHealth());

    }

    @Test
    public void shipDiesWhenHealthIsZero() {
        Ship s = new Ship(0, 0, 3, true);
        assertEquals(3, s.getHealth());
        s.hit();
        s.hit();
        s.hit();
        assertEquals(0, s.getHealth());
        assertFalse(s.getIsAlive());
    }

//    @Test
//    public void shipCannotBeHitSamePlaceTwice(){
//        
//    }
    @Test
    public void gridHasCorrectWidhtAndHeight() {
        Grid g = new Grid(10, 10);
        assertEquals(10, g.getHeight());
        assertEquals(10, g.getWidth());
    }

    @Test
    public void gridAddsShipsOnList() {
        Grid g = new Grid(10, 10);
        g.addShip(0, 0, 1, true);
        g.addShip(2, 2, 1, true);
        assertEquals(2, g.getShips().size());
    }

    @Test
    public void cannotAddOverlappingShips() {
        Grid g = new Grid(10, 10);
        g.addShip(0, 0, 1, true);
        g.addShip(0, 0, 1, true);
        assertEquals(1, g.getShips().size());
    }

    @Test
    public void cannotInsertShipOverGrid() {
        Grid g = new Grid(10, 10);
        g.addShip(0, 0, 13, true);
        g.addShip(9, 9, 2, true);
        assertEquals(0, g.getShips().size());
    }

    @Test
    public void gridCountsTheAmountOfShips() {
        Grid g = new Grid(10, 10);
        g.addShip(0, 0, 1, true);
        g.addShip(4, 4, 1, true);
        assertEquals(2, g.getShipsLeft());
        g.hit(0, 0);
        assertEquals(1, g.getShipsLeft());
    }

    @Test
    public void gridKnowsIfSquareIsHit() {
        Grid g = new Grid(10, 10);
        assertTrue(g.isSquareHit(0, 0));
        g.hit(0, 0);
        assertFalse(g.isSquareHit(0, 0));
    }

    @Test
    public void playerSetsShipCorrectly() {
        Player p = new Player();
        p.setShipSize(5);
        p.setNewShip(0, 0, true);
        assertTrue(p.getGrid().hit(0, 0));
    }

    @Test
    public void playerHitWorks() {
        Player p = new Player();
        p.setShipSize(5);
        p.setNewShip(0, 0, true);
        assertTrue(p.hit(0, 0));
    }

    @Test
    public void stateDetermineFirstTurnWorks() {
        Player p1 = new Player();
        Player p2 = new Player();
        State s = new State(p1, p2);
        int turn = s.determineFirstTurn();
        assertTrue(turn == 1 || turn == 2);

    }
    
    @Test
    public void stateGetTurnWorks(){
        Player p1 = new Player();
        Player p2 = new Player();
        State s = new State(p1, p2);
        if (s.getCurrentPlayer() == 1){
            assertEquals("Turn of player 1", s.getTurn());
        } else {
            assertEquals("Turn of player 2", s.getTurn());
        }
    }

}

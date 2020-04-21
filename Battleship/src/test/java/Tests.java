
import battleship.Board.Grid;
import battleship.Board.Ship;
import battleship.GameState.State;
import battleship.User.Player;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        assertEquals(10, g.getWidht());
    }

    @Test
    public void gridAddsShipsOnList() {
        Grid g = new Grid(10, 10);
        g.addShip(0, 0, 1, true);
        g.addShip(2, 2, 1, true);
        assertEquals(2, g.getShips().size());
    }
    
    @Test
    public void cannotAddOverlappingShips(){
        Grid g = new Grid(10, 10);
        g.addShip(0, 0, 1, true);
        g.addShip(0, 0, 1, true);
        assertEquals(1, g.getShips().size());
    }
    
    @Test
    public void cannotInsertShipOverGrid(){
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
        assertTrue(g.isSquareHit(0, 0));
    }
    
    
    
}

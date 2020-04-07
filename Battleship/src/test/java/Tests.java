
import battleship.GameState;
import battleship.Grid;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Tests {
    GameState state;
    Grid grid;
    
    public Tests() {
    }
    
    @Before
    public void setUp() {
        this.state = new GameState();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void gridHasCorrectSize(){
        assertEquals(10, state.getHeight());
        assertEquals(10, state.getWidth());
    }
    
    @Test
    public void firstTurnSetPlayerCorrectly(){
        state.determineFirstTurn();
        assertEquals(1, 2, state.getCurrentPlayer());
    }
    
    @Test
    public void turnChangesCorrectly(){
       int player =  state.getCurrentPlayer();
       if(player == 1){
           state.changeTurn();
           assertEquals(2, state.getCurrentPlayer());
       } else if (player == 2){
           state.changeTurn();
           assertEquals(1, state.getCurrentPlayer());
       }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

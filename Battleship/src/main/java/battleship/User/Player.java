package battleship.User;

import battleship.Board.Grid;
import java.util.Scanner;

public class Player {

   private Grid grid;
   Scanner s;

    public Player() {
        s = new Scanner(System.in);
        this.grid = new Grid(10, 10);
        
   }

    public void initializeShips() {

        System.out.println("Insert 10 ships. Input: x y horizontal. Example: 1 2 true");
        for (int i = 0; i < 10 ; i++){
        String ship = s.nextLine();
        String[] split = ship.split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        int size = Integer.parseInt(split[2]);
        boolean horizontal = Boolean.parseBoolean(split[3]);
        grid.addShip(x, y, size, horizontal);
    }
    }
    
    public boolean hit(){
        System.out.println("Insert coordinates x and y");
        
        String coordinates = s.nextLine();
        String[] temp = coordinates.split(" ");
        int x = Integer.parseInt(temp[0]);
        int y = Integer.parseInt(temp[1]);
      
        if (grid.isSquareHit(x, y) == false){
            System.out.println("You have already hit this square, try again");
            this.hit();
        }
        
        if(grid.hit(x, y)){
            return true;
        }
        return false;
    }

    public Grid getGrid() {
        return grid;
    }

}

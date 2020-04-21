package battleship.User;

import battleship.Board.Grid;
import java.util.Scanner;

public class Player {

   private Grid grid;
  
   Scanner s;
   int shipSize;
    public Player() {
        s = new Scanner(System.in);
        this.shipSize = 1;
        this.grid = new Grid(10, 10);
        
   }

    public void initializeShips() {

        System.out.println("\nInsert ship. Input: x y horizontal. Example: 1 2 true");
 
        String ship = s.nextLine();
        String[] split = ship.split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        boolean horizontal = Boolean.parseBoolean(split[2]);
        if (grid.addShip(x, y, shipSize, horizontal) == true){
            System.out.println("Ship added");
            this.shipSize ++;
            if(this.shipSize <= 4){
                this.initializeShips();
            }
        } else {
            System.out.println("\n-- Ship you tried to insert is over grid or there is already a ship. Try again. --\n");
            this.initializeShips();
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

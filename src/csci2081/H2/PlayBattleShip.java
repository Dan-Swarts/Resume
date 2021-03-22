package csci2081.H2;
import java.util.Scanner;
// written by Daniel Swarts, Swart179

public class PlayBattleShip {

    // initialize input:
    private static Scanner input = new Scanner(System.in);
    private static String in;
    private static int droneCount;
    private static int missileCount;

    private static void droneImplementation(BattleshipBoard board, int powerLimit){

        if(droneCount >= powerLimit){
            System.out.println("you cannot use this power any more times.");
            return;
        }

        char orientation;

        System.out.println("Would you like to scan a row or a column? type \"row\" for row or \"column\" for column.");
        while(true){
            in = input.next();
            if(in.equals("row")){
                orientation = 'h';
                break;
            }
            else if(in.equals("column")){
                orientation = 'v';
                break;
            }
            else if(in.equals("drone")){
                droneImplementation(board,powerLimit);
                return;
            }
            else if(in.equals("missile")){
                missileImplementation(board,powerLimit);
                return;
            }
            else if(in.equals("print")){
                board.print();
            }
            else{
                System.out.print("invalid input. ");
            }
            System.out.println("Type \"row\" for row or \"column\" for column.");
        }

        while(true){
            System.out.println("which " + in + " would you like to scan?");
            in = input.next();
            if(in.equals("drone")){
                droneImplementation(board,powerLimit);
                return;
            }
            else if(in.equals("missile")){
                missileImplementation(board,powerLimit);
                return;
            }
            else if(in.equals("print")){
                board.print();
            }
            else{
                break;
            }
        }

        int shipCount = board.drone(orientation,Integer.valueOf(in));
        System.out.println("drone has scanned " + shipCount + " targets in the specified area.");
        droneCount++;
        board.display();
    }

    private static void missileImplementation(BattleshipBoard board, int powerLimit){

        if(missileCount >= powerLimit){
            System.out.println("you cannot use this power any more times.");
            return;
        }

        int row = Integer.valueOf(in);
        while(true){
            System.out.println("which column would you like to missile?");
            in = input.next();
            if(in.equals("drone")){
                droneImplementation(board,powerLimit);
                return;
            }
            else if(in.equals("missile")){
                missileImplementation(board,powerLimit);
                return;
            }
            else if(in.equals("print")){
                board.print();
            }
            else{
                break;
            }
        }

        while(true){
            System.out.println("which row value would you like attack?");
            in = input.next();
            if(in.equals("drone")){
                droneImplementation(board,powerLimit);
                return;
            }
            else if(in.equals("missile")){
                missileImplementation(board,powerLimit);
                return;
            }
            else if(in.equals("print")){
                board.print();
            }
            else{
                break;
            }
        }

        int col = Integer.valueOf(in);
        board.missile(row,col);
        missileCount++;
        board.display();
    }

    public static void main(String args[]){

        droneCount = 0;
        missileCount = 0;

        // set difficulty:
        boolean difficulty;
        System.out.print("Hello, welcome to BattleShip! ");
        while(true){
            System.out.println("Please enter S to play in standard mode or E to play in expert.");
            in = input.nextLine();
            if(in.equals("S")){
                difficulty = false;
                break;
            }
            else if (in.equals("E")){
                difficulty = true;
                break;
            }
        }

        // create board:
        BattleshipBoard board;
        if(!difficulty){
            board = new BattleshipBoard(8,5);
        }
        else{
            board = new BattleshipBoard(12,10);
        }

        int powerLimit;
        // add ships:
        if(!difficulty){
            powerLimit = 1;
            board.placeShips(5);
            board.placeShips(4);
            board.placeShips(3);
            board.placeShips(3);
            board.placeShips(2);
        }
        else{
            powerLimit = 1;
            board.placeShips(5);
            board.placeShips(5);
            board.placeShips(4);
            board.placeShips(4);
            board.placeShips(3);
            board.placeShips(3);
            board.placeShips(3);
            board.placeShips(3);
            board.placeShips(2);
            board.placeShips(2);
        }

        // play the game:
        int x;
        int y;
        int outcome;
        int turnCounter = 0;
        while(!board.win()){
            board.display();


            while (true){
                System.out.println("which column would you like to attack?");
                in = input.next();
                if(in.equals("drone")){
                    droneImplementation(board, powerLimit);
                }
                else if(in.equals("missile")){
                    missileImplementation(board, powerLimit);
                }
                else if (in.equals("print")){
                    board.print();
                }
                else{
                    x = Integer.valueOf(in);
                    break;
                }
            }

            while (true){
                System.out.println("which row would you like to attack?");
                in = input.next();
                if(in.equals("drone")){
                    droneImplementation(board, powerLimit);
                }
                else if(in.equals("missile")){
                    missileImplementation(board, powerLimit);
                }
                else if(in.equals("print")){
                    board.print();
                }
                else{
                    y = Integer.valueOf(in);
                    break;
                }
            }

            outcome = board.fire(y,x);

            if(outcome == 1){
                System.out.println("Hit");
            }
            else if (outcome == 2){
                System.out.println("Miss");
            }
            else if (outcome == 3){
                System.out.println("Sunk");
            }
            else if (outcome == 4){
                System.out.println("penalty");
                turnCounter++;
            }
            turnCounter++;
            System.out.println();

        }

        System.out.println("You've won in " + turnCounter + " turns.");
    }
}

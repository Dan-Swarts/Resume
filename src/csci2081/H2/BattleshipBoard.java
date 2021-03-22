package csci2081.H2;

// written by Daniel Swarts, Swart179

public class BattleshipBoard {

    // variables:
    private CharPtr[][] data;
    private int size;
    private Ship[] ships;
    private int shipCount;
    private int sunkCount;

    // constructor:
    public BattleshipBoard(int size, int ships){

        // initialize variables:
        this.size = size;
        this.ships = new Ship[ships];
        shipCount = 0;

        // populate the board with every space being empty by default:
        data = new CharPtr[size][size];
        for(int i1 = 0; i1 < size; i1++){
            for(int i2 = 0; i2 < size; i2++){
                CharPtr n = new CharPtr('E');
                data[i1][i2] = n;
            }
        }
    }

    // methods:

    // This is a private static helper method. It uses Math.random to generate a random integer.
    // It will return an integer greater than or equal to zero, and less than the value passed in.
    public static int rand(int bound){
        double out = Math.random();
        out *= bound;
        return (int) out;
    }

    // this method randomly adds a ship of a specified length to the board using the rand method.
    public void placeShips(int length){

        // initialize ship:
        Ship s = new Ship(length);

        // Step 1: determine orientation. 50/50 chance for the ship to be either vertical or horizontal.
        int orientation = rand(2); // 0 = horizontal, 1 = vertical

        if(orientation == 0){

            while(true){
                // step 2: find a valid position for the head of the ship.
                int x = rand(size);
                int y = rand(size - length + 1);

                // step 3: check to see if the designated space is already occupied by a ship.
                boolean occupied = false;
                for(int i = 0; i < length; i++){
                    if(!data[y + i][x].equals('E')){
                        occupied = true;
                    }
                }

                // step 4: if not occupied, add the ship onto the board.
                if(!occupied){
                    for(int i = 0; i< length; i++){
                        data[y + i][x].setData('S');
                        s.addCoordinate(data[y + i][x]);
                    }

                    // if successfully added a ship, add the ship to the data and break out of the loop.
                    ships[shipCount] = s;
                    shipCount += 1;
                    break;
                }
                // if not successful, repeat steps 2-4.
            }
        }

        // steps 2-4 for a vertical ship looks slightly different:
        if(orientation == 1){

            while(true){
                // step 2: find a valid position for the head of the ship.
                int x = rand(size);
                int y = rand(size - length + 1);

                // step 3: check to see if the designated space is already occupied by a ship.
                boolean occupied = false;
                for(int i = 0; i < length; i++){
                    if(!data[x][y + i].equals('E')){
                        occupied = true;
                    }
                }

                // step 4: if not occupied, add the ship onto the board.
                if(!occupied){
                    for(int i = 0; i< length; i++){
                        data[x][y + i].setData('S');
                        s.addCoordinate(data[x][y + i]);
                    }

                    // if successfully added a ship, add the ship to the data and break out of the loop.
                    ships[shipCount] = s;
                    shipCount += 1;
                    break;
                }
                // if not successful, repeat 2-4.
            }
        }
        // end of method
    }

    // this is a private helper method. It takes in a coordinate, and determines if that coordinate
    // is a valid position on the board.
    private boolean inRange(int input){
        if(input < 0 || input > size - 1){
            return false;
        }
        return true;
    }

    // this is a private helper method. It determines the number of ships that have been sunk.
    private int countSunk(){
        int out = 0;
        for(int i = 0; i < ships.length; i++){
            if(ships[i].sunk()){
                out++;
            }
        }
        return out;
    }

    // this is a private helper method. It uses countSunk and sunkCount to determine if a new ship has been sunk.
    private boolean newSunk(){
        if(countSunk() > sunkCount){
            sunkCount++;
            return true;
        }
        return false;
    }

    // the fire method simulates a shot fired at the board. It will return an integer based on the result of the attack:
    // -1 = something went wrong
    // 0 = input variables are out of range
    // 1 = a hit
    // 2 = a miss
    // 3 = sunk a ship
    // 4 = penalty
    public int fire(int x, int y) {

        // first, check to make sure the input is a valid coordinate:
        if(!inRange(x) || !inRange(y)){
            return 0;
        }

        // identify the attacked space on the board:
        CharPtr n = data[x][y];

        // checks the status of that space:

        if (data[x][y].equals('E')){ // if there is no ship at this space:
            data[x][y].setData('M'); // update status to missed and return.
            return 2;
        }

        // if the space was already attacked, return a penalty:
        else if(data[x][y].equals('H')){
            return 4;
        }
        else if(data[x][y].equals('M')){
            return 4;
        }

        // the only other possibility is that there is a ship at this space.
        else{
            data[x][y].setData('H'); // update status to hit ship
            if(newSunk()){ // if the ship was sunk, return 3.
                return 3;
            }
            return 1; // if the ship was not sunk, return 1.
        }
    }

    // this method is used to determine if the game has been won.
    public boolean win(){

        // the win condition is that every ship has been sunk. It checks this using the sunk method of the Ship class.
        for(int i = 0; i < shipCount; i ++){
            if(!ships[i].sunk()){
                return false;
            }
        }
        return true;
    }

    // this is a private helper method.
    private boolean droneHelper(int row, int col){
        // skipping all the neutral cases:
        if(data[row][col].equals('E')){return false;}
        else if(data[row][col].equals('H')){return false;}
        else if(data[row][col].equals('M')){return false;}
        // if there is a ship present, return true:
        else{
            data[row][col].setData('R');
            return true;
        }
    }

    // this method implements the drone power up.
    public int drone(char orientation, int num){
        int droneCount = 0;

        if(orientation == 'h'){
            for(int i = 0; i < size; i++){
                if(droneHelper(num,i)){
                    droneCount++;
                }
            }
        }

        else if(orientation == 'v'){
            for(int i = 0; i < size; i++){
                if(droneHelper(i,num)){
                    droneCount++;
                }
            }
        }
    return droneCount;
    }

    // this method implements the missile power up.
    public void missile(int row, int col){

        fire(row,col);

        if(inRange(row + 1)){
            fire(row + 1,col);
        }

        if(inRange(row - 1)){
            fire(row - 1,col);
        }

        if(inRange(col + 1)){
            fire(row,col + 1);
        }

        if(inRange(col - 1)){
            fire(row, col - 1);
        }

        if(inRange(row + 1) && inRange(col + 1)){
            fire(row + 1, col + 1);
        }

        if(inRange(row + 1) && inRange(col - 1)){
            fire(row + 1, col - 1);
        }

        if(inRange(row - 1) && inRange(col + 1)){
            fire(row - 1, col + 1);
        }

        if(inRange(row - 1) && inRange(col - 1)){
            fire(row - 1,col - 1);
        }
    }

    public void display(){
        String out = "";

        for(int i1 = size - 1; i1 >= 0; i1--){
            out += i1 + " ";
            for(int i2 = 0; i2 < size; i2++){
                if(data[i1][i2].equals('M')){
                    out += "O ";
                }
                else if(data[i1][i2].equals('H')){
                    out += "X ";
                }
                else if(data[i1][i2].equals('R')){
                    out += "S ";
                }
                else if(data[i1][i2].equals('E')){
                    out += "- ";
                }
                else{
                    out += "- ";
                }
            }
            out += "\n";
        }

        out += "  ";
        for(int i = 0; i < size; i++){
            out += i + " ";
        }
        out += "\n";

        System.out.println(out);
    }

    public void print(){
        String out = "";

        for(int i1 = size - 1; i1 >= 0; i1--){
            out += i1 + " ";
            for(int i2 = 0; i2 < size; i2++){
                if(data[i1][i2].equals('M')){
                    out += "O ";
                }
                else if(data[i1][i2].equals('H')){
                    out += "X ";
                }
                else if(data[i1][i2].equals('R')){
                    out += "S ";
                }
                else if (data[i1][i2].equals('E')){
                    out += "- ";
                }
                else{
                    out += data[i1][i2].getData() + " ";
                }
            }
            out += "\n";
        }

        out += "  ";
        for(int i = 0; i < size; i++){
            out += i + " ";
        }
        out += "\n";

        System.out.println(out);
    }
}

package csci2081.H2;

// written by Daniel Swarts, Swart179

// the Ship class represents an array of consecutive positions on a BattleShipBoard. This will allow me to keep track of
// each individual ship on the board, so that I can make sure there is no overlap. I can also use the sunk method to
// tell when a new ship has been sunk.
public class Ship {

    // variables:
    private CharPtr[] data;
    private int count;
    private int id;
    private static int idMaker = 49;

    // constructor:
    public Ship(int length){
        data = new CharPtr[length];
        count = 0;
        id = idMaker;
        idMaker++;
    }

    public void addCoordinate(CharPtr n){
        data[count] = n;
        count++;
        n.setData((char) id);
    }

    public String toString(){
        String out = "";
        for(int i = 0; i < data.length; i++){
            out += data[i];
        }
        return out;
    }

    public boolean sunk(){
        for(int i = 0; i < data.length; i++){
            if(data[i].getData() != 'H'){
                return false;
            }
        }
        return true;
    }

    public void printShip(){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i].getData());
        }
    }
    public static void main(String args[]){
        CharPtr c1 = new CharPtr('E');
        CharPtr c2 = new CharPtr('E');
        CharPtr c3 = new CharPtr('E');
        CharPtr c4 = new CharPtr('E');

        Ship myShip = new Ship(4);
        myShip.addCoordinate(c1);
        myShip.addCoordinate(c2);
        myShip.addCoordinate(c3);
        myShip.addCoordinate(c4);
        myShip.printShip();
    }
}

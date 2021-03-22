package csci2081.H2;

// written by Daniel Swarts, Swart179

// the CharPtr class is a data structure with exactly the same functionality as a basic char type, except that it deals
// with a pointer instead of an actual value. this allows me to have synergy between the Ship class and BattleShipBoard
// class, so that if I alter a BattleShipBoard, the Ship class pointing to the same data will update automatically.

// a char was chosen as the underlying data structure for the a position on the board because it takes less space than
// an integer, and more intuitive. The data stored here will be interpreted as follows:

// 'E' stands for "empty". This means there is not a ship here.
// 'H' stands for "hit". This means there is a ship in this space, but it was already shot.
// 'M' stands for "miss". This means this is an empty space that has been fired apron.
// a number stands for the id of a ship. This means that there is a ship at this space.

public class CharPtr {
    // variables:
    char data;

    // constructor:
    public CharPtr(char data){this.data = data;}

    // methods:
    public void setData(char data){ this.data = data;}

    public char getData(){ return data;}

    public String toString(){ return "" + data; }

    public boolean equals(char c){
        if (data == c){
            return true;
        }
        return false;
    }
}

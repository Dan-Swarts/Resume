package csci2081.H1;

// written by Daniel Swarts;
// swart179;

// the Roots class is returned by the Quadratic "roots" method. It consists of 2 Complex roots in an array.
public class Roots {

    // initialize variables:
    private Complex[] roots;
    // i is used to keep track of the soonest empty slot in the array
    private int i = 0;

    // constructor:
    public Roots (){
        roots = new Complex[2];
    }

    // getters:
    public Complex[] getRoots(){ return roots; }

    // the toString method converts the data into a readable String
    public String toString(){
        String output = "";
        output += roots[0].toString();
        output += ", ";
        output += roots[1].toString();
        return output;
    }
    public void print(){
        System.out.println(this.toString());
    }

    // this method adds a Complex number to the array
    public void addRoot(Complex root){
        if(i > 1){
            System.out.println("already have 2 roots");
        }
        else{
            roots[i] = root;
            i += 1;
        }
    }
}

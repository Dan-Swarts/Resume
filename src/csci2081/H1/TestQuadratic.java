package csci2081.H1;

// written by Daniel Swarts;
// swart179;

// this class is designed to test the Quadratic class
public class TestQuadratic {

    public static void print(Quadratic q){
        System.out.println(q.toString());
        return;
    }

    public static void print(Roots r1){
        System.out.println(r1.toString());
    }

    public static void main(String args[]){

        // testing the toString method (the print method prints the String from the toString method):

        Quadratic q1 = new Quadratic(1,4,12);
        print(q1);   // should output 1x^2 + 4x + 12

        q1 = new Quadratic(0,0,0);
        print(q1);  // should output nothing

        q1 = new Quadratic(0,0,-1);
        print(q1);   // should output -1

        q1 = new Quadratic(-10,0,-12);
        print(q1);   // should output -10x^2 - 12

        System.out.println();


        // testing the add method
        Quadratic q2;
        Quadratic q3;
        q1 = new Quadratic(3,4,5);
        q2 = new Quadratic(3,0,-17);
        q3 = q1.add(q2);
        print(q3); // should output 6x^2 + 4 -12

        q1 = new Quadratic(-1,0,-3);
        q2 = new Quadratic(-12,5,-2);
        q3 = q1.add(q2);
        print(q3); // should output -13x^2 + 5 -5
        System.out.println();


        //testing the subtract method
        q1 = new Quadratic(3,4,5);
        q2 = new Quadratic(3,0,-17);
        q3 = q1.subtract(q2);
        print(q3); // should output 4x + 22

        q3 = q2.subtract(q1);
        print(q3); // should output -4x - 22

        q1 = new Quadratic(-1,0,-3);
        q2 = new Quadratic(-12,5,-2);
        q3 = q1.subtract(q2);
        print(q3); // should output 11x^2 - 5x -1

        q3 = q2.subtract(q1);
        print(q3); // should output -11x^2 + 5x +1
        System.out.println();


        // testing the equals method:

        q1 = new Quadratic(1,1,1);
        q2 = new Quadratic(1,1,1);
        System.out.println(q1.equals(q2)); // should output true
        System.out.println(q2.equals(q1)); // should output true

        q1 = new Quadratic(1,1,2);
        System.out.println(q1.equals(q2)); // should output false
        System.out.println(q2.equals(q1)); // should output false
        System.out.println();



        // testing the roots function:
        Roots r1 = new Roots();
        q1 = new Quadratic(1,-3,1);
        r1 = q1.findRoots();
        r1.print(); // should print "2.61803, 0.381966"

        q1 = new Quadratic(12,3,3);
        r1 = q1.findRoots();
        r1.print(); // should print "-0.125 + 0.484123i, -0.125, - 0.484123i"
    }
}

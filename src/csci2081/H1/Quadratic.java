package csci2081.H1;

// written by Daniel Swarts;
// swart179;

// this class represents a quadratic function in the for of ax^2 + bx + c.
public class Quadratic {

    // initialize variables:
    private double a;
    private double b;
    private double c;

    // constructor:
    public Quadratic(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // getters:
    public double getA(){return a;}
    public double getB(){return b;}
    public double getC(){return c;}

    // this method converts the data of a quadratic object into a readable string.
    public String toString(){

        // adds first argument if it exists:
        String output = "";
        if(Math.abs(a) < 0.0001){
        }
        else{
            output += String.format("%.0fx^2 ",a);
        }

        // adds first '+' sign if it belongs:
        if(Math.abs(a) > 0.0001 && b > 0){
            output += "+";
        }

        // adds second argument if it exists:
        if(Math.abs(b) < 0.0001){
        }
        else{
            output += String.format("%.0fx ", b);
        }

        // adds the second '+' sign if it belongs:
        if(Math.abs(b) > 0.0001 && c > 0){
            output += "+";
        }

        // adds third argument if it exists:
        if(Math.abs(c) < 0.0001){
        }
        else{
            output += String.format("%.0f", c);
        }

        return output;
    }

    public void print(){
        System.out.println(this.toString());
        return;
    }

    // setters:
    public void setA(double a){this.a = a;}
    public void setB(double b){this.b = b;}
    public void setC(double c){this.c = c;}

    // methods:

    // the following methods add and subtract two different quadratic objects
    public Quadratic add(Quadratic other){
        return new Quadratic(
                a + other.a,
                b + other.b,
                c + other.c);
    }

    public Quadratic subtract(Quadratic other){
        return new Quadratic(
                a - other.a,
                b - other.b,
                c - other.c);
    }

    // this method calculates the roots of a quadratic function
    public Roots findRoots(){
        double square = b * b - 4 * a * c;
        Roots output = new Roots();

        Complex c1 = new Complex(square);
        c1.add(-1 * b);
        c1.divide(2 * a);
        output.addRoot(c1);

        Complex c2 = new Complex(square);
        c2.multiply(-1);
        c2.add(-1 * b);
        c2.divide(2 * a);
        output.addRoot(c2);
        return output;
    }

    // this method determines if two quadratic functions are equal
    public boolean equals(Quadratic other){
        if(Math.abs(a - other.getA()) > 0.0001){
            return false;
        }
        if(Math.abs(b - other.getB()) > 0.0001){
            return false;
        }
        if(Math.abs(c - other.getC()) > 0.0001){
            return false;
        }
        return true;
    }
}

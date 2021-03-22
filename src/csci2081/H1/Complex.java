package csci2081.H1;

// written by Daniel Swarts;
// swart179;

// the complex class represents a complex number. This includes all real numbers, and an imaginary component "i", which
// represents the square root of negative 1. This is written as a+bi.
public class Complex {

    // initialize variables:
    // a represents the real component, b represents the imaginary component.
    private double a;
    private double b;

    // constructor:
    // this constructor takes in a number and squares it, taking into account if it has an imaginary component.

    // if the number squared is positive, it will not have an imaginary component.
    public Complex(double square){
        if(square >= 0){
            a = Math.sqrt(square);
            b = 0.0;
        }
        // if the number squared is negative, it will only have an imaginary component.
        else{
            b = Math.sqrt(Math.abs(square));
            a = 0.0;
        }
    }

    // this secondary constructor just takes in the a and b components.
    public Complex(double a, double b){
        this.a = a;
        this.b = b;
    }

    // getters:
    public double getA(){return a;}
    public double getB(){return b;}

    // this toString method takes the data and puts it in a + bi form, in the form of a string.
    public String toString(){
        String output = "";

        // adds the a component if it exists:
        if(Math.abs(a) < 0.0001){
        }
        else{
            output += String.format("%f ", a);
        }

        // adds the '+' sign if appropriate:
        if(Math.abs(a) > 0.0001 && b > 0){
            output += "+";
        }

        // adds the b component if it exists:
        if(Math.abs(b) < 0.0001){
        }
        else{
            output += String.format("%fi", b);
        }

        return output;
    }

    // setters:
    public void setN(double n){this.a = n;}
    public void setI(double i){this.b = i;}

    // methods:

    // the following methods enable basic arithmetic with complex numbers, needed to calculate roots using the
    // quadratic formula:
    public void add(double addend){this.a += addend;}

    public void subtract(double minuend){this.a -= minuend;}

    public void multiply(double factor){a *= factor; b *= factor;}

    public void divide(double divisor){a /= divisor; b /= divisor;}
}
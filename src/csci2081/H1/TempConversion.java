package csci2081.H1;

// written by Daniel Swarts;
// swart179;

// this class includes the conversions between Celsius, fahrenheit, and kelvin
public class TempConversion {

    public double fToC(double temp){
        return (temp - 32) * 5 / 9;
    }

    public double cToF(double temp) {
        return temp * 9 / 5 + 32;
    }

    public double fToK(double temp){
        return (temp + 459.67) * 5 / 9;
    }

    public double kToF(double temp){
        return temp * 9 / 5 - 459.67;
    }

    public double cToK(double temp){
        return temp + 273.15;
    }

    public double kToC(double temp){
        return temp - 273.15;
    }


    // the following main method is designed to test the conversion methods:
    public static void main(String args[]){
        TempConversion t1 = new TempConversion();

        // testing fToC
        System.out.println(t1.fToC(32)); // should print 0
        System.out.println(t1.fToC(212)); // should print 100

        // testing cToF
        System.out.println(t1.cToF(0)); // should print 32
        System.out.println(t1.cToF(100)); // should print 212

        // testing fToK
        System.out.println(t1.fToK(32)); // should print 273.15
        System.out.println(t1.fToK(212)); // should print 373.15

        // testing kToF
        System.out.println(t1.kToF(273.15)); // should print 32
        System.out.println(t1.kToF(373.15)); // should print 212

        // testing cToK
        System.out.println(t1.cToK(0)); // should print 273.15
        System.out.println(t1.cToK(100)); // should print 373.15

        //testing kToC
        System.out.println(t1.kToC(273.15));
        System.out.println(t1.kToC(373.15));
    }
}

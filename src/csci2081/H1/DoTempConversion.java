package csci2081.H1;

// written by Daniel Swarts;
// swart179;

import java.util.Scanner;

// this class implements the TempConversion class and takes user input to easily convert between temperatures.
public class DoTempConversion {
    public static void main(String args[]){
        TempConversion t = new TempConversion();
        Scanner input = new Scanner(System.in);


        System.out.println("enter in your temperature and conversion: ");

        double temp = input.nextDouble();
        String in2 = input.next();

        if(in2.equals("fToC")){
            System.out.println(temp + " in Fahrenheit is " + t.fToC(temp) + " in Celsius.");
        }

        else if(in2.equals("cToF")){
            System.out.println(temp + " in Celcius is " + t.cToF(temp) + " in Fahrenheit.");
        }

        else if(in2.equals("fToK")){
            System.out.println(temp + " in Fahrenheit is " + t.fToK(temp) + " in Kelvin.");
        }

        else if(in2.equals("kToF")){
            System.out.println(temp + " in Kelvin is " + t.kToF(temp) + " in Fahrenheit.");
        }

        else if(in2.equals("cToK")){
            System.out.println(temp + " in Celsius is " + t.cToK(temp) + " in Kelvin.");
        }

        else if(in2.equals("kToC")){
            System.out.println(temp + " in Kelvin is " + t.kToC(temp) + " in Celsius.");
        }
        else {
            System.out.println("error: no action detected. ");
        }
    }
}

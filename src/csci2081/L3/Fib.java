package csci2081.L3;

import java.util.Scanner;

public class Fib {
    public static int fibonacciRecursive(int n){

        // case 0:
        if(n < 0){
            System.out.println("not a valid number");
            return -1;
        }

        // case 1:
        else if(n == 0){return 0;}

        // case 2:
        else if(n == 1){return 1;}

        // case 3:
        else{
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }


    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("what number in the fibonacci sequence do you want?");
        int n = input.nextInt();
        System.out.println("the answer is: " + fibonacciRecursive(n));
    }
}

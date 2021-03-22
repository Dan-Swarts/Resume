package csci2081.L3;

import java.util.Scanner;

public class HistogramApp {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("what is the lower bound of your histogram?");
        int low = input.nextInt();

        System.out.println("what is the upper bound of your histogram?");
        int up = input.nextInt();

        Histogram h1 = new Histogram(low, up);

        while(1==1) {
            String in = input.nextLine();

            if (in.equals("add")) {
                System.out.println("enter number(s): ");
                in = input.nextLine();
                String[] enteredNumbers = in.split(" ");
                for(int i = 0; i < enteredNumbers.length; i++){
                    int num = Integer.valueOf(enteredNumbers[i]);
                    h1.add(num);
                }
            }

            else if (in.equals("print")) {
                h1.print();
            }

            else if (in.equals("quit")){
                return;
            }
        }
    }
}

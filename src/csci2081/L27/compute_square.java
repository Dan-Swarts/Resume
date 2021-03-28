package csci2081.L27;

import java.util.Scanner;

public class compute_square {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.printf("Please enter an integer, or q to quit: ");
            String input = in.next();
            if (input.equals("q")) {
                System.out.printf("Exiting...\n");
                break;
            }
            int number;
            try {
                number = Integer.parseInt(input);
            }
            catch (Exception e) {
                System.out.printf("Error: %s is not a valid integer.\n\n", input);
                continue;
            }
            int square = number * number;
            System.out.printf("%d squared = %d\n\n", number, square);
        }
    }
}

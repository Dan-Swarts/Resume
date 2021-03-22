package csci2081.L1;

import java.util.Scanner;

public class MostCommonCharacter {
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter string: ");

        String s = in.nextLine();
        int index;
        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }

        int max = 0;
        char mChar =' ';

        for (int i = 0; i < 256; i++){
            if (count[i] > max){
                max = count[i];
                mChar = (char) i;
            }
        }

        System.out.println(String.format("The most common character is %c. it occurred %d times.",mChar,max));
    }
}

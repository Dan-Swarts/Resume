package csci2081.L1;

import java.util.Scanner;

public class Palindrome {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        Palindrome(s,0,(s.length()-1));
    }
    public static void Palindrome(String str, int left, int right){
        if ((right - left) < 1){
            System.out.println("This is a palindrome");
        }
        else if(str.charAt(left) == str.charAt(right)){
            Palindrome(str,(left + 1),(right - 1));
        }
        else{
            System.out.println("This is not a palindrome");
        }
    }
}

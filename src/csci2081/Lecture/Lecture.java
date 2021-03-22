package csci2081.Lecture;

public class Lecture {

    public static int countDigits(int n){
        if (n / 10 == 0){
            return 1;
        }

        else {
            return 1 + countDigits(n / 10);
        }
    }

    public static void main (String [] args) {
        System.out.println(countDigits(-43));
    }
}

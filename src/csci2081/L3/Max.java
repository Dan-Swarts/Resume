package csci2081.L3;

public class Max {

    public static int iterativeMaxDigit(int num){
        String digits = Integer.toString(num);
        int max = digits.charAt(0) - 48;

        for(int i = 1; i < digits.length(); i++){
            if((digits.charAt(i) - 48) > max){
                max = digits.charAt(i) - 48;
            }
        }
        return max;
    }

    public static int recursiveMaxDigit(int num){

        // case 1: there is only one digit
        if(num / 10 == 0){
            return num;
        }

        // case 2: the rightmost digit is largest:
        else if(num % 10 > recursiveMaxDigit(num / 10)){
            return num % 10;
        }

        // case 3: the rightmost digit is not largest:
        else {
            return recursiveMaxDigit(num / 10);
        }
    }

    public static void main(String args[]){
        System.out.println(recursiveMaxDigit(10));
    }
}

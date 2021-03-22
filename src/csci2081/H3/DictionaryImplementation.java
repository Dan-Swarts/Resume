package csci2081.H3;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryImplementation {

    public static void main(String[] args) throws FileNotFoundException {
        Dictionary slang = new Dictionary("C:\\Users\\danst\\IdeaProjects\\Resume\\src\\csci2081\\H3\\slangdictionary.txt",100);

        Scanner in = new Scanner(System.in);
        String input;

        while(true){
            System.out.println();
            System.out.println("next lookup?: ");
            input = in.next();
            slang.lookup(input);
        }
    }
}

//package csci2081.H3;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class DictionaryImplementation {
//
//    private static Scanner in = new Scanner(System.in);
//    private static String input;
//
//    public static void lookupImplemented(Dictionary dict){
//        System.out.println("\nwhat word are you looking up? \n");
//        input = in.nextLine();
//        String[] printing = dict.lookupPhrase(input);
//        if(printing[0].equals("false")){
//            System.out.println("no word starting with " + input + " was found");
//            System.out.println();
//            return;
//        }
//        else{
//            for(int i = 1; i < printing.length; i++){
//                if(printing[i] != null){
//                    System.out.println(printing[i]);
//                    System.out.println();
//                }
//            }
//        }
//    }
//
//    public static void removeImplemented(Dictionary dict){
//        System.out.println("\nwhat value are you removing?: \n");
//        input = in.nextLine();
//        String[] printing = dict.lookupWord(input);
//
//        if(printing[0].equals("false")){
//            System.out.println("no word starting with " + input + " was found\n");
//            System.out.println();
//        }
//        else if(printing[2] == null){
//            dict.remove(printing[1]);
//            System.out.println("removed\n");
//        }
//
//        else{
//            System.out.println("several phrases starting with " + input + " were found: ");
//            System.out.println();
//            for(int i = 1; i < printing.length; i++){
//                if(printing[i] != null){
//                    System.out.println(printing[i]);
//                        System.out.println();
//                }
//            }
//            removeImplemented(dict);
//        }
//    }
//
//    public static void addImplemented(Dictionary dict){
//        System.out.println("\nwhat word or phrase are you adding? \n");
//        input = in.nextLine();
//        int result = dict.findAdd(input);
//
//        if(result != -1){
//            System.out.println(input + " is already in the dictionary.\n");
//        }
//        else{
//            String wordOrPhrase = input;
//            System.out.println("what is the definition of " + wordOrPhrase + "?: \n");
//            input = in.nextLine();
//            dict.add(new DictionaryEntry(wordOrPhrase,input));
//            System.out.println();
//        }
//    }
//
//    public static void updateImplemented(Dictionary dict){
//        System.out.println("\nwhich entry are you updating? \n");
//        String wordOrPhrase = in.nextLine();
//        int result = dict.findAdd(wordOrPhrase);
//
//        if(result != -1){
//            System.out.println("what is the new definition of " + wordOrPhrase + "?:\n");
//            input = in.nextLine();
//            dict.changeDef(result,input);
//        }
//
//        else{
//            System.out.println("There is no entry with that name. \n ");
//        }
//    }
//
//    public static void close(String filePath, Dictionary dict) throws IOException {
//        dict.writeToFile(filePath);
//    }
//
//    public static void main(String[] args) throws IOException {
//        String filePath = "C:\\Users\\danst\\IdeaProjects\\Resume\\src\\csci2081\\H3\\slangdictionary.txt";
//        Dictionary slang = new Dictionary(filePath,100);
//
//        System.out.println("commands:\n\nL: lookup a word or phrase\nR: remove a word or phrase\nA: add a new word or phrase\nU: update an existing word or phrase\nC: close the program\nH: reprint the commands for you\n");
//        while(true){
//            System.out.println("what is your next command?\n");
//            input = in.nextLine();
//            if(input.equals("C")){
//                break;
//            }
//
//            else if(input.equals("H")){
//                System.out.println("commands:\n\nL: lookup a word or phrase\nR: remove a word or phrase\nA: add a new word or phrase\nU: update an existing word or phrase\nC: close the program\nH: reprint the commands for you\n");
//            }
//
//            else if(input.equals("L")){
//                lookupImplemented(slang);
//            }
//
//            else if(input.equals("R")){
//                removeImplemented(slang);
//            }
//
//            else if(input.equals("A")){
//                addImplemented(slang);
//            }
//
//            else if(input.equals("U")){
//                updateImplemented(slang);
//            }
//
//            else{
//                System.out.println("command not recognized\n");
//            }
//        }
//        System.out.println(slang);
//        close(filePath,slang);
//    }
//}

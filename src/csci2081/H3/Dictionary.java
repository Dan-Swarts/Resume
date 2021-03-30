package csci2081.H3;

import DataStructures.Lists.MyArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Dictionary {

    // variables:
    private MyArray<DictionaryEntry> data;

    // constructor:
    Dictionary(String filePath, int length) throws FileNotFoundException {

        data = new MyArray<>(length);
        File slangDictionary = new File(filePath);
        Scanner slangReader = new Scanner(slangDictionary);
        String[] entry;

        while(slangReader.hasNextLine()){
            entry = slangReader.nextLine().split("-");
            String definition = entry[1];
            for(int i = 2; i < entry.length; i++){
                definition += "-";
                definition += entry[i];
            }
            entry[1] = definition;
            data.add(new DictionaryEntry(entry));
        }
    }

    // methods:
    public String toString(){
        return data.toString();
    }

//    public void sort(){
//        data.sort();
//    }

    public String[] lookupPhrase(String lookingFor){
        String[] out = new String[data.length() + 1];
        out[0] = "false";
        int iteration = 1;
        DictionaryEntry currEntry;
        System.out.println();

        for(int i = 0; i < data.length(); i++){

            currEntry = data.get(i);
            if(currEntry.hasGot(lookingFor)){
                out[iteration] = currEntry.getWordOrPhrase() + " - " + currEntry.getDefinition();
                iteration++;
                out[0] = "true";
            }
        }
        return out;
    }

    public String[] lookupWord(String lookingFor){
        String[] out = new String[data.length() + 1];
        out[0] = "false";
        int iteration = 1;
        DictionaryEntry currEntry;
        System.out.println();

        for(int i = 0; i < data.length(); i++){

            currEntry = data.get(i);
            if(currEntry.hasGot(lookingFor)){
                out[iteration] = currEntry.getWordOrPhrase();
                iteration++;
                out[0] = "true";
            }
        }
        return out;
    }

    public int findAdd(String lookingFor){
        int iteration = 0;
        int out = -1;
        DictionaryEntry currEntry;
        System.out.println();

        for(int i = 0; i < data.length(); i++){
            currEntry = data.get(i);
            if(currEntry.hasGotExact(lookingFor)){
                return i;
            }
        }
        return -1;
    }

    public void changeDef(int index, String newDef){
        data.get(index).setDefinition(newDef);
    }

//    public void add(DictionaryEntry input){
//        data.add(input);
//        data.sort();
//    }

    public void remove(String wordOrPhrase){
        for(int i = 0; i < data.length(); i++){
            if(data.get(i).getWordOrPhrase().equals(wordOrPhrase)){
                data.remove(i);
                return;
            }
        }
    }

    public void writeToFile(String filePath) throws IOException {
        FileWriter myWriter = new FileWriter(filePath);
        for(int i = 0; i < data.length(); i++){
            myWriter.write(data.get(i).toString());
            myWriter.write("\n");
        }
    }
}

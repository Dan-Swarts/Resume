package csci2081.H3;

import DataStructures.MyArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {

    // variables:
    private MyArrayList<DictionaryEntry> data;

    // constructor:
    Dictionary(String filePath, int length) throws FileNotFoundException {

        data = new MyArrayList<>(length);
        File slangDictionary = new File(filePath);
        Scanner slangReader = new Scanner(slangDictionary);
        String[] entry;

        while(slangReader.hasNextLine()){
            entry = slangReader.nextLine().split("-");
            data.add(new DictionaryEntry(entry));
        }
    }

    // methods:
    public String toString(){
        return data.toString();
    }

    public void sort(){
        data.sort();
    }

    public void lookup(String lookingFor){
        boolean hasMatch = false;
        DictionaryEntry currEntry;

        for(int i = 0; i < data.length(); i++){

            currEntry = data.get(i);
            if(currEntry.hasGot(lookingFor)){
                System.out.println(currEntry.getWordOrPhrase() + " - " + currEntry.getDefinition());
            }
        }
        if(!hasMatch){
            System.out.println("");
        }
    }
}

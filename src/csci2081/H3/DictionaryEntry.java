package csci2081.H3;
// Comparable vs Comparable
//
import java.lang.Comparable;
public class DictionaryEntry implements Comparable<DictionaryEntry> {

    // instance variables
    private String wordOrPhrase;
    private String definition;

    // constructors
    public DictionaryEntry() {
    }

    public DictionaryEntry(String wop, String def) {
        this.wordOrPhrase = wop;
        this.definition = def;
    }

    // You are free to implement other constructors as you see fit

    public DictionaryEntry(String[] data){
        this.wordOrPhrase = data[0];
        this.definition = data[1];
    }

    // You should implement at least the getters and setters below

    public String getWordOrPhrase(){
        return wordOrPhrase;
    }
    public String getDefinition(){
        return definition;
    }

    public void setWordOrPhrase(String wordOrPhrase){
        this.wordOrPhrase = wordOrPhrase;
    }
    public void setDefinition(String definition){
        this.definition = definition;
    }

    // returns a String array with the wordOrPhrase at location zero and definition
    // at location 1

    public String [] getData() {
        String[] output = new String[2];
        output[0] = wordOrPhrase;
        output[1] = definition;
        return output;
    }

    // accepts a String array with the wordOrPhrase at location zero and the definition
    // of the wordOrPhrase at location 1 and sets the variables accordingly
    public void setData(String [] data) {
        wordOrPhrase = data[0];
        definition = data[1];
    }

    // Define a Comparator method that can be used to sort an ArrayList of Nodes in Lexically
    // Ascending order - that is, from A to Z, according to the wordOrPhrase
    // Note that you must keep the exact method signature provided here


    @Override
    public int compareTo(DictionaryEntry o) {
        return wordOrPhrase.compareTo(o.getWordOrPhrase());
    }

    public String toString(){
        return wordOrPhrase + definition;
    }

    public boolean hasGot(String lookingFor){
        for(int i = 0; i < lookingFor.length(); i++){
            if(Character.toLowerCase(wordOrPhrase.charAt(i)) != Character.toLowerCase(lookingFor.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public boolean hasGotExact(String lookingFor){
        if(lookingFor.length() != wordOrPhrase.length()){
            return false;
        }
        for(int i = 0; i < wordOrPhrase.length(); i++){
            if(Character.toLowerCase(wordOrPhrase.charAt(i)) != Character.toLowerCase(lookingFor.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
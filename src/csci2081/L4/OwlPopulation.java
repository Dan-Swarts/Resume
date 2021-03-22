package csci2081.L4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public void populateData() throws FileNotFoundException{
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;

        while(scanner.hasNextLine()){
            numLines++;
            scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);

        int i = 0;

        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] v = s.split(","); // v stands for "variables"
            Owl owl = new Owl(v[0],Integer.parseInt(v[1]),Double.parseDouble(v[2]));
            data[i] = owl;
            i++;
        }
    }

    public OwlPopulation(String fileName) throws FileNotFoundException{
        this.fileName = fileName;
        this.populateData();
    }

    public double averageAge(){

        int sum = 0;

        for(int i = 0; i< data.length; i++){
            Owl currOwl = data[i];
            sum += currOwl.getAge();
        }

        return sum / data.length;
    }

    public Owl getYoungest(){

        if(popSize() == 0){
            return null;
        }

        Owl youngest = data[0];

        for(int i = 1; i < data.length; i++){
            if (data[i].getAge() < youngest.getAge()){
                youngest = data[i];
            }
        }
        return youngest;
    }

    public Owl getHeaviest(){

        if(popSize() == 0){
            return null;
        }

        Owl heaviest = data[0];

        for(int i = 1; i < data.length; i++){
            if (data[i].getWeight() > heaviest.getWeight()){
                heaviest = data[i];
            }
        }
        return heaviest;
    }

    public String toString(){
        String output = "";

        for(int i = 0; i < data.length; i++){
            Owl currOwl = data[i];
            output += currOwl.toString() + "\n";
        }

        return output;
    }

    public void print(){System.out.print(toString());}

    public boolean containsOwl(Owl other){
        for(int i = 0; i < data.length; i++){
            if(other.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    public Owl getOwl(int index){
        if(index < 0 || index > data.length - 1){
            return null;
        }
        else{
            return data[index];
        }
    }

    public void merge(OwlPopulation other){

        //1) determine (and store) the distinct owls in the other population.

        int l = 0;
        for(int i = 0; i < other.popSize(); i++){
            if(!containsOwl(other.getOwl(i))){
                l++;
            }
        }

        Owl[] toAdd = new Owl[l];

        l = 0;
        for(int i = 0; i < other.popSize(); i++){
            if(!containsOwl(other.getOwl(i))){
                toAdd[l] = other.getOwl(i);
                l++;
            }
        }

        //2) make a new data array to hold the correct number of owls for the merged population

        Owl[] newData = new Owl[l + popSize()];

        //3) copy over the distinct owls from each population to the data array

        for(int i = 0; i < data.length; i++){
            newData[i] = data[i];
        }

        for(int i = 0; i < toAdd.length; i++){
            newData[i + popSize()] = toAdd[i];
        }

        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)

        this.data = newData;
    }

    public int popSize(){
        return data.length;
    }

    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("C:\\Users\\danst\\Downloads\\owlPopulation1.csv");
            System.out.println(pop1);
            System.out.println(pop1.popSize());

            System.out.println("the heaviest is: ");
            System.out.println(pop1.getHeaviest() + "\n");
            System.out.println("the youngest is: ");
            System.out.println(pop1.getYoungest() + "\n");

            OwlPopulation pop2 = new OwlPopulation("C:\\Users\\danst\\Downloads\\owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());

            System.out.println("the heaviest is: ");
            System.out.println(pop2.getHeaviest() + "\n");
            System.out.println("the youngest is: ");
            System.out.println(pop2.getYoungest() + "\n");

            pop1.merge(pop2);
            System.out.println(pop1);
            System.out.println(pop1.popSize());
            System.out.println("the heaviest is: ");
            System.out.println(pop1.getHeaviest() + "\n");
            System.out.println("the youngest is: ");
            System.out.println(pop1.getYoungest() + "\n");


        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }


}


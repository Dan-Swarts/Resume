package csci2081.Lecture;// IntNode.java
// October 2020
// Simple integer node class with test driver main() method

import java.util.Scanner;

public class IntNodeDriver {

    private int data;
    private IntNodeDriver next;  // pointer to next node in list

    public IntNodeDriver() {}  // default constructor

    public void printAll(){
        while(next != null){
            System.out.println(data);
        }
    }

    public IntNodeDriver(int value, IntNodeDriver ptr) {
        data = value;
        next = ptr;
    }
  
    // accessor methods

    public int getData() {
        return data;
    }

    public IntNodeDriver getNext() {
        return next;
    }

    public void setData(int value) {
        data = value;
    }

    public void setNext(IntNodeDriver ptr) {
        next = ptr;
    }

    public boolean equals(Object anotherObject) {
        // returns true iff both fields of
        // the corresponding nodes are ==

        if (anotherObject instanceof IntNodeDriver) {
          IntNodeDriver temp = (IntNodeDriver) anotherObject; 
          if (data == temp.getData() &&
              next == temp.getNext())
            return true;
        }
        return false;
    }

    public String toString() {
        return "" + data;
    }

    public static void main(String[] args) {
        // tests the IntNodeDriver class by building a short list of ints

        IntNodeDriver start = new IntNodeDriver();
        IntNodeDriver currNode = new IntNodeDriver();
        start.setNext(currNode);
        
        Scanner s = new Scanner(System.in);

        System.out.print("Enter an integer (^d to quit): ");
        while (s.hasNextInt()) {
            currNode.setData(s.nextInt());
            currNode.setNext(new IntNodeDriver());
            currNode = currNode.getNext();
            System.out.print("Next integer (^d to quit): ");
        }

        System.out.println("\nList of ints entered...");
        currNode = start.getNext();
        while (currNode.getNext() != null) {
            System.out.println(currNode.getData());
            currNode = currNode.getNext();
        }

    }  // main

}  // IntNode

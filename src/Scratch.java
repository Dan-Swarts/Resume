import java.util.Scanner;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class Scratch {
    public static void main(String[] args) {
        Queue<String> customers = new LinkedList<String>();

        customers.add("Ina");
        customers.add("Ben");
        customers.add("Noa");
        customers.add("Ron");

        System.out.println(customers.poll());
        System.out.println(customers.element());
        System.out.println(customers.peek());
        customers.remove();
    }
}
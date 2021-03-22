package csci2081.Lecture18;

public class Main1 {
    public static void main (String[] args) {
        Square s1 = new Square("Square1", 5, 4);
        s1.print_name();
        s1.print_area();

        Circle c1 = new Circle("Circle1",3.5);
        c1.print_name();
        c1.print_area();
    }
}

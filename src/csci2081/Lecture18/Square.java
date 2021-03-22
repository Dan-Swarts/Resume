package csci2081.Lecture18;

public class Square implements Shape {
    String aName;
    double height;
    double width;

    public Square (String name, double w, double h) {
        aName = name;
        height = h;
        width = w;
    }

    public void print_area() {
        System.out.println("Area of square: " + aName + " = " + height * width);
    }

    public void print_name() {
        System.out.println("Name of Square: " + aName);
    }
}

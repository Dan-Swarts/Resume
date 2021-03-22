package csci2081.Lecture18;

public class Circle implements Shape {
    String aName;
    double radius;

    public Circle (String name, double r) {
        aName = name;
        radius = r;
    }

    public void print_area() {
        System.out.println("Area of Circle: " + aName + " = " + radius * radius * 3.14159);
    }

    public void print_name() {
        System.out.println("Name of Circle: " + aName);
    }
}


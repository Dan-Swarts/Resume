package csci2081.L8;

public abstract class Triangle implements Shape {

    protected double a;
    protected double b;
    protected double c;
    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double p = perimeter();
        return Math.sqrt(p * (p-a) * (p-b) * (p-c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}

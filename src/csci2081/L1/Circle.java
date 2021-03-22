package csci2081.L1;

public class Circle {

    public static void main(String args[]){

        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(6.0);

        System.out.println(c1.getArea());
        System.out.println(c1.getRadius());
        System.out.println(c1.getCircumference());

        c1.setRadius(7.0);

        System.out.println(c1.getArea());
        System.out.println(c1.getRadius());
        System.out.println(c1.getCircumference());

        c1.setRadius(6.0);
        System.out.println(c1.eq(c2));
    }

    // initialize variables:
    double radius;

    //constructors:
    public Circle(double r) {
        this.radius = r;
    }

    // methods:

    public double getRadius(){
        return radius;
    }

    public void setRadius(double r){
        radius = r;
    }

    public double getArea(){
        return 3.14159 * radius * radius;
    }

    public double getDiameter(){
        return 2 * radius;
    }

    public double getCircumference(){
        return 3.14159 * radius * 2;
    }

    public boolean eq(Circle c){
        if (radius == c.getRadius()){
            return true;
        }
        return false;
    }
}

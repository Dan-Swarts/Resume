package csci2081.L8;

public class Bike implements Drivable {

    @Override
    public void movingForward() {
        System.out.println("Bike moving forwards");
    }

    @Override
    public void movingBackward() {
        System.out.println("Bike moving backwards");
    }

    public static void main(String[] args) {
        Bike b = new Bike();
        b.movingBackward();
        b.movingForward();
    }
}

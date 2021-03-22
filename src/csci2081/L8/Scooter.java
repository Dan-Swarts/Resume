package csci2081.L8;

public class Scooter implements Drivable {
    @Override
    public void movingForward() {
        System.out.println("Scooter moving forwards");
    }

    @Override
    public void movingBackward() {
        System.out.println("Scooter moving backwards");
    }

    public static void main(String[] args) {
        Scooter s = new Scooter();
        s.movingBackward();
        s.movingForward();
    }
}

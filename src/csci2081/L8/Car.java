package csci2081.L8;

public class Car extends Vehicle {

    String model;

    public Car (String model, double horsePower){
        this.model = model;
        this.horsePower = horsePower;
        numVehicles++;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getHorsepower() {
        return horsePower;
    }

    @Override
    public void movingForward() {
        System.out.println("Car moving forwards");
    }

    @Override
    public void movingBackward() {
        System.out.println("Car moving backwards");
    }

    public static void main(String[] args) {
        Car c = new Car("Honda",5.9);
        System.out.println(c.getHorsepower());
        System.out.println(c.getModel());
        c.movingBackward();
        c.movingForward();

        System.out.println();

        Boat b = new Boat("not a boat",7.0);
        System.out.println(b.getHorsepower());
        System.out.println(b.getModel());
        b.movingBackward();
        b.movingForward();

        Helicopter h = new Helicopter(" ",0.0);

        System.out.println();

        System.out.println(getNumVehicles());
    }
}
package csci2081.L8;

public class Boat extends Vehicle {

    public Boat (String model, double horsePower){
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
        System.out.println("Boat moving forwards");
    }

    @Override
    public void movingBackward() {
        System.out.println("Boat moving backwards");
    }

    public void hoistAnchor(){
        System.out.println("Boat Hoisting Anchor");
    }

    public void dropAnchor(){
        System.out.println("Boat Dropping Anchor");
    }

}
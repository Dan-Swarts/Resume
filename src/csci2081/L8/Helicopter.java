package csci2081.L8;

public class Helicopter extends Vehicle {

    public Helicopter (String model, double horsePower){
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
        System.out.println("Helicopter moving forwards");
    }

    @Override
    public void movingBackward() {
        System.out.println("Helicopter moving backwards");
    }

    public void moveUp(){
        System.out.println("Helicopter Moving Up");
    }

    public void moveDown(){
        System.out.println("Helicopter Moving Down");
    }
}

package csci2081.L8;

public abstract class Vehicle implements Comparable<Vehicle> {
    protected static int numVehicles = 0;

    public String model;
    public double horsePower;

    public abstract String getModel();
    public abstract double getHorsepower();
    public abstract void movingForward();
    public abstract void movingBackward();

    public void start(){
        System.out.println("Starting Vehicle Engine..");
    }

    public void stop(){
        System.out.println("Stopping Vehicle Engine..");
    }

    // Returns this vehicle as a nicely formatted string.
    public String toString() {
        return getClass() + " [" + getModel() + ", " + getHorsepower() + "hp]";
    }

    // Returns true if and only if o is the same type of vehicle and has the
    // same horsepower as the vehicle being called upon.
    public boolean equals(Object o) {
        if (o != null && getClass().equals(o.getClass())) {
            Vehicle v = (Vehicle)o;
            if (getHorsepower() == v.getHorsepower()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // Returns the number of vehicles that have been instantiated.
    public static final int getNumVehicles() {
        return numVehicles;
    }

    // Compares v to the vehicle instance based on horsepower.
    public int compareTo(Vehicle v) {

        if(Math.abs(horsePower) > Math.abs(v.horsePower)){
            return 1;
        }

        else if (Math.abs(horsePower) < Math.abs(v.horsePower)){
            return -1;
        }

        return 0;
    }
}

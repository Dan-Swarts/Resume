package csci2081.Lecture17;

public class Bird extends Animal{

    private final boolean isVegan;

    public Bird (boolean v, String aName){
        isVegan = v;
        name = aName;
    }

    public void speak(){ super.Speak();}

    public boolean isVegan(){return isVegan;}

    public String toString(){ return name + " is a vegan?: " + isVegan; }

    public static void main(String[] args) {
        Bird foo = new Bird(true,"Cahooo");
        foo.speak();
    }

}

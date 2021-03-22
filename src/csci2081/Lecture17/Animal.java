package csci2081.Lecture17;

public class Animal {
    protected String name;
    public Animal() {name = "noName";}
    public void Speak() {
        System.out.println("I have nothing to say");
    }
    public String getName() { return name;}
    public void setName(String aName) {name = aName;}

    public static void main(String args[]){
        Bird george = new Bird(true,"George");
        george.speak();
        System.out.println(george);
        System.out.println(george.isVegan());
    }
}

package csci2081.Lecture;

public abstract class Pet {
    String name;

    public void speak(){
        System.out.print(name + " says ");
    }
    public void info(){
        System.out.println("name: " + name);
    }
}

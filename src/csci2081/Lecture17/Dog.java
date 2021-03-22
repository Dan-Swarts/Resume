package csci2081.Lecture17;

public class Dog  extends Animal {
    private final boolean chasesCats;
    
    public Dog (boolean CC, String aName){
        chasesCats = CC;
        name = aName;
    }


    public void Speak(){
        System.out.println("Woof Woof");
    }

    public boolean catChaser() {
        return chasesCats;
    }

    public String toString () {return super.name + " Chases Cats? " + chasesCats;}

}

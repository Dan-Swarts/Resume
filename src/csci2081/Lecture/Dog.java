package csci2081.Lecture;

public class Dog extends Pet {

    String breed;

    public Dog(String name,String breed){
        this.name = name;
        this.breed = breed;
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("woof");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("breed: " + breed);
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("bud","york");
        d1.speak();
        d1.info();
    }
}

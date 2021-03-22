package csci2081.L4;

public class Owl {

    private String name;
    private int age;
    private double weight;

    public Owl (String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public boolean equals(Owl other){
        if(this.name == other.name && this.age == other.age && this.weight == other.weight){
            return true;
        }
        else{
            return false;
        }
    }

    // getters:
    public String getName(){ return name; }
    public int getAge(){ return age;}
    public double getWeight(){ return weight; }


    public String toString(){
        String output = "";
        output += "Name: " + name + ", ";
        output += "Age: " + age + ", ";
        output += "Weight: " + weight + ", ";
        return output;
    }

    // print statement shortcuts:
    public void print(){ System.out.print(toString()); }
    public void println(){ System.out.println(toString()); }

    public static void main(String args[]){
        Owl o1 = new Owl("Jeff",4,3.2);
        Owl o2 = new Owl("Bob", 6,3.0);
        Owl o3 = new Owl("Jeff",4,3.2);

        System.out.println("should return false:");
        System.out.println(o1.equals(o2));

        System.out.println("should return true:");
        System.out.println(o1.equals(o3));
        System.out.println();

        o1.println();
        o2.println();
        o3.println();
    }
}

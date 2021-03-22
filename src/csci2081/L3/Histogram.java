package csci2081.L3;

public class Histogram {

    private int[] data;
    private int lowerBound;
    private int upperBound;

    public Histogram (int lowerBound, int upperBound){

        if(lowerBound > upperBound){
            upperBound = lowerBound;
            lowerBound = upperBound;
        }

        else {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        data = new int[upperBound - lowerBound + 1];
        for(int i = 0; i < data.length; i++){
            data[i] = 0;
        }
    }

    public String toString(){
        String out = "";

        for(int i1 = 0; i1 < data.length; i1++){
            out += i1 + lowerBound + ": ";

            for(int i2 = 0; i2 < data[i1]; i2++){
                out += "*";
            }
            out += "\n";
        }
        return out;
    }

    public void println(){ System.out.println(this.toString()); }

    public void print(){ System.out.print(this.toString()); }

    public boolean add(int n){
        if(n < lowerBound || n > upperBound){
            System.out.println(n + " is not in the range");
            return false;
        }
        else{
            data[n - lowerBound] += 1;
            return true;
        }
    }

    public static void main(String args[]){
        int[] data = new int[20];
        Histogram h1 = new Histogram(3,3);
        h1.print();

        System.out.println(h1.add(4));
        h1.print();

        System.out.println(h1.add(3));
        h1.print();

        System.out.println(h1.add(5));
        h1.print();

        System.out.println(h1.add(6));
        h1.print();

        System.out.println(h1.add(7));
        h1.print();

        System.out.println(h1.add(3));
        h1.print();
    }
}

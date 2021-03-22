package csci2081.L7;

public class SparseVector {

    private Node head;
    private int length;

    public SparseVector(int len){
        head = null;
        length = len;
    }

    // Prints out a sparse vector (including zeros)
    public String toString(){

        String result = "";
        Node currNode = head;
        int currIndex = 0;
        while( currNode != null ){
            int idx = currNode.getIndex();

            // Pad the space between nodes with zero
            while( currIndex < idx ){
                result += "0, ";
                currIndex++;
            }
            result += currNode;
            currNode = currNode.getNext();
            currIndex++;

            // Only add a comma if this isn't the last element
            if( currNode != null ){ result += ", "; }
        }
        return result;
    }

    // TODO: Implement me for milestone 1
    public void addElement(int index, double value){
        if(index >= length || index < 0){
            return;
        }

        Node next = new Node(index, value);

        if(head == null){
            head = next;
            return;
        }

        Node currentNode = head;
        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(next);
    }



    // TODO: Implement me for milestone 2
    public static double dot( SparseVector x, SparseVector y ){

        if(x.length != y.length){
            return 0.0;
        }

        double result = 0.0;
        Node xNode = x.head;
        Node yNode = y.head;

        while( xNode != null && yNode != null ){

            if(xNode.getIndex() > yNode.getIndex()){
                yNode = yNode.getNext();
            }

            else if(xNode.getIndex() < yNode.getIndex()){
                xNode = xNode.getNext();
            }

            else{
                result += xNode.getValue() * yNode.getValue();
                xNode = xNode.getNext();
                yNode = yNode.getNext();
            }
        }
        return result;
    }

    public void removeElement(int index){
        if(head == null){
            return;
        }
        if(head.getNext() == null){
            if(head.getIndex() == index){
                head = null;
            }
        }
        if(head.getIndex() == index){
            head = head.getNext();
        }

        Node currNode = head;
        int currIndex = 0;
        while(currNode.getNext() != null){
            if(currNode.getNext().getIndex() == index){
                currNode.setNext(currNode.getNext().getNext());
            }
            currNode = currNode.getNext();
        }
    }

    // TODO: Test out your code here!
    public static void main(String[] args) {
        SparseVector myVector = new SparseVector(6);
        myVector.addElement(0,10.0);
        myVector.addElement(3,-1.1);
        myVector.addElement(5,32.0);
        myVector.removeElement(0);
        System.out.println(myVector);

        SparseVector x = new SparseVector(100000000);
        x.addElement(0, 1.0);
        x.addElement(10000000, 3.0);
        x.addElement(10000001, -2.0);
        SparseVector y = new SparseVector(100000000);
        y.addElement(0, 2.0);
        y.addElement(10000001, -4.0); double
                result = dot(x, y);
        System.out.println(result);

        x = new SparseVector(100000000);
        x.addElement(0, 1.0);
        x.addElement(10000000, 3.0);
        x.addElement(10000001, -2.0);
        y = new SparseVector(100000000);
        y.addElement(0, 2.0);
        y.addElement(10000001, -4.0);
        y.removeElement(0);
        result = dot(x, y);
        System.out.println(result);
    }
}

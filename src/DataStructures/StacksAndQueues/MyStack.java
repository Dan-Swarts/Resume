package DataStructures.StacksAndQueues;
import DataStructures.Nodes.LNode;

public class MyStack<T> implements MySimpleList<T> {

    // variables
    private LNode<T> head = null;

    // constructor
    public MyStack() {}

    public MyStack(T element){
        push(element);
    }

    public MyStack(T[] elements){
        for(T element : elements){
            push(element);
        }
    }

    // methods:

    public boolean isEmpty(){
        return head == null;
    }

    public void push(T o) {
        head = new LNode<T>(o, head);
    }

    public T peek() {
        if(head == null){
            return null;
        }
        else{
            return head.getData();
        }
    }

    public T pop() {
        if(head == null){
            return null;
        }
        else{
            T temp = head.getData();
            head = head.getNext();
            return temp;
        }
    }

    // ONLY USE FOR TESTING!!!
    public String toString(){
        String out = "";
        while (!isEmpty()){
            out += pop().toString() + "\n";
        }
        return out;
    }
}

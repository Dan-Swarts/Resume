package DataStructures.StacksAndQueues;

import DataStructures.Nodes.LNode;

public class MyQueue<T> implements MySimpleList<T> {

    // variables:
    LNode<T> head;
    LNode<T> tail;

    // constructors:
    public MyQueue(){}

    public MyQueue(T element){
        push(element);
    }

    public MyQueue(T[] elements){
        for(T element : elements){
            push(element);
        }
    }

    public void push(T o) {
        if(head == null){
            head = new LNode<T>(o);
        }
        else if(tail == null){
            tail = new LNode<T>(o);
            head.setNext(tail);
        }
        else{
            tail.setNext(new LNode<T>(o));
            tail = tail.getNext();
        }
    }

    public T pop() {
        if(head == null){
            return null;
        }
        else if(tail == null){
            T temp = head.getData();
            head = null;
            return temp;
        }
        else{
            T temp = head.getData();
            head = head.getNext();
            return temp;
        }
    }

    public T peek() {
        if(head == null){
            return null;
        }
        else{
            return head.getData();
        }
    }

    public boolean isEmpty() {
        return head == null;
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

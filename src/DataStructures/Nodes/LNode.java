package DataStructures.Nodes;


public class LNode<T> { // L stands for "Linked", i.e. linked list

    // instance variables
    T data;
    private LNode<T> next;

    // constructors
    public LNode() {
    }

    public LNode(T data) {
        this.data = data;
        this.next = null;
    }

    public LNode(T data, LNode<T> next) {
        this.data = data;
        this.next = next;
    }

    // selectors
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LNode<T> getNext() {
        return next;
    }

    public void setNext(LNode<T> next) {
        this.next = next;
    }
}
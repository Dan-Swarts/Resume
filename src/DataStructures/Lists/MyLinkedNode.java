package DataStructures.Lists;

public class MyLinkedNode<T extends Comparable<T>> {

    // instance variables
    private T data;
    private MyLinkedNode<T> next;

    // constructors
    public MyLinkedNode() {
    }

    public MyLinkedNode(T data) {
        this.data = data;
        this.next = null;
    }

    public MyLinkedNode(T data, MyLinkedNode<T> next) {
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

    public MyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(MyLinkedNode<T> next) {
        this.next = next;
    }

    public static void main(String args[]) {
        System.out.println(3);
    }
}
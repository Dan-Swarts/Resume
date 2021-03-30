package DataStructures.Lists;
import DataStructures.Nodes.LNode;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    // initialize variables:
    private LNode<T> head;
    private int size;

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(2);
        list.add(3);
        System.out.println(list);
    }

    // constructors:

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    public MyLinkedList(T element){
        head = new LNode<T>(element);
        size = 1;
    }

    public MyLinkedList(LNode<T> head){
        this.head = head;
        LNode<T> currNode = head;
        size = 1;
        while(currNode.getNext() != null){
            size++;
            currNode = currNode.getNext();
        }
    }

    public MyLinkedList(T element, LNode<T> next){
        head = new LNode<T>(element,next);
        LNode<T> currNode = head;
        size = 1;
        while(currNode.getNext() != null){
            size++;
            currNode = currNode.getNext();
        }
    }

    public MyLinkedList(T[] data){
        size = 0;
        for (T datum : data) {
            this.add(datum);
        }
    }

    // methods:
    public int size(){return size;}

    public String toString(){
        String out = "";

        // if list is empty:
        if(size == 0){return out;}

        LNode<T> currNode = head;
        if(currNode.getData() != null){
            out = currNode.getData().toString() + "\n";
        }

        for (int i = 1; i < size; i++) {
            currNode = currNode.getNext();
            if(currNode.getData() != null){
                out += currNode.getData().toString() + "\n";
            }
        }
        return out;
    }

    public boolean add(T element) {
        if(element == null){
            return false;
        }
        LNode<T> next = new LNode<>(element);
        if(head == null){
            head = next;
            size++;
            return true;
        }
        else{
            LNode<T> currNode = head;
            while(currNode.getNext() != null){
                currNode = currNode.getNext();
            }
            currNode.setNext(next);
            size++;
            return true;
        }
    }


    public boolean add(int index, T element) {

        if (element == null || index < 0) {
            return false;
        }

        else if (index < size) {
            LNode<T> next = new LNode<T>(element);
            LNode<T> currNode = head;
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.getNext();
            }
            next.setNext(currNode.getNext());
            currNode.setNext(next);
            size++;
            return true;
        }

        else {

            if (head == null) {
                head = new LNode<T>();
            }

            LNode<T> currNode = head;

            for (int i = 0; i < index; i++) {
                if (currNode.getNext() != null) {
                    currNode = currNode.getNext();
                }
                currNode.setNext(new LNode<T>());
                currNode = currNode.getNext();
            }
            currNode.setData(element);
            size = index + 1;
            return true;
        }
    }

    public void clear() {
        head = new LNode<T>();
        size = 0;
    }

    public boolean set(int index, T element) {
        if (index < 0) {
            return false;
        }

        else if (index < size) {
            LNode<T> currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.getNext();
            }
            currNode.setData(element);
        }

        else {
            LNode<T> currNode;
            if (head == null) {
                currNode = new LNode<T>();
                head = currNode;
            } else {
                currNode = head;
            }

            for (int i = 0; i < index; i++) {
                if (currNode.getNext() != null) {
                } else {
                    currNode.setNext(new LNode<T>());
                }
                currNode = currNode.getNext();
            }
            currNode.setData(element);
            size = index + 1;
            return true;
        }
        return true;
    }

    public void squish(){}


    public T get(int index) {
        if(index < 0 || index > size){return null;}
        else{
            LNode<T> currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.getNext();
            }
            return currNode.getData();
        }
    }


    public int indexOf(T element) {
        LNode<T> currNode = head;
        for (int i = 0; i < size; i++) {
            if(currNode.getData().compareTo(element) == 0){
                return i;
            }
            currNode = currNode.getNext();
        }
        return -1;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public void sort() {

    }


    public T remove(int index) {
        return null;
    }


    public int remove(T object) {
        return 0;
    }
}

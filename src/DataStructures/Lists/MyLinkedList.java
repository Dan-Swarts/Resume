package DataStructures.Lists;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    // initialize variables:
    private MyLinkedNode head;
    private boolean isSorted;



    // constructor:
    public MyLinkedList() {
        this.head = new MyLinkedNode(null);
        isSorted = true;
    }

    public MyLinkedList extractGroupsOf(int n){

        MyLinkedList output = new MyLinkedList();

        if(n <= 0){
            return output;
        }

        if(n >= size()){
            return this;
        }

        MyLinkedNode currMyLinkedNode = head;
        int currIndex = 0;
        MyLinkedList subList = new MyLinkedList();

        while(currMyLinkedNode.getNext() != null){
            subList.add(currMyLinkedNode.getNext().getData());

            if(currIndex % n == 0){
                output.add((Comparable) subList);
                subList = new MyLinkedList();
            }

            currMyLinkedNode = currMyLinkedNode.getNext();
            currIndex += 1;
        }

        return output;
    }

    @Override
    public boolean add(T t) {

        if(t == null){
            return false;
        }

        MyLinkedNode currMyLinkedNode = head;
        while(currMyLinkedNode.getNext() != null){
            currMyLinkedNode = currMyLinkedNode.getNext();
        }
        currMyLinkedNode.setNext(new MyLinkedNode(t));

        if(size() != 1){
            isSorted = false;
        }
        return true;
    }

    @Override
    public boolean add(int index, T element) {

        if(isEmpty() || index < 0 || index >= size()){
            return false;
        }

        MyLinkedNode currMyLinkedNode = head;
        int currIndex = 0;
        while(currIndex < index){
            currMyLinkedNode = currMyLinkedNode.getNext();
            currIndex += 1;
        }
        currMyLinkedNode.setNext(new MyLinkedNode(element, currMyLinkedNode.getNext()));
        isSorted = false;
        return true;
    }

    @Override
    public void clear() {
        head.setNext(null);
        isSorted = true;
    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= size() || isEmpty()){
            return null;
        }

        MyLinkedNode currMyLinkedNode = head.getNext();
        int currIndex = 0;

        while (currIndex < index){
            currMyLinkedNode = currMyLinkedNode.getNext();
            currIndex += 1;
        }
        return (T) currMyLinkedNode.getData();
    }

    @Override
    public int indexOf(T element) {

        if(isEmpty()){
            return -1;
        }

        MyLinkedNode currNode = head.getNext();
        int currIndex = 0;

        while(currNode.getNext() != null){

            if(currNode.getData() == element){
                return currIndex;
            }

            currNode = currNode.getNext();
            currIndex += 1;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if(head.getNext() == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int size() {
        MyLinkedNode currMyLinkedNode = head;
        int CurrIndex = 0;

        while (currMyLinkedNode.getNext() != null){
            currMyLinkedNode = currMyLinkedNode.getNext();
            CurrIndex += 1;
        }
        return CurrIndex;
    }

    @Override

    // bubble sort algorithm
    public void sort() {

        // will not sort if empty or size of 1
        if(size() <= 1){
            return;
        }

        // sorts a number of times equal to the number of elements in the list minus 1
        for(int i=0;i<size()-1;i++){

            // each sort, the largest element will bubble up to the top of the list
            MyLinkedNode currMyLinkedNode = head.getNext();

            // goes through the list
            while(currMyLinkedNode.getNext() != null){

                // if previous data is larger than next data...
                if(currMyLinkedNode.getData().compareTo(currMyLinkedNode.getNext().getData()) > 0){

                    // ...switch data values
                    Comparable temp = currMyLinkedNode.getData();
                    currMyLinkedNode.setData(currMyLinkedNode.getNext().getData());
                    currMyLinkedNode.getNext().setData(temp);
                }

                // iterate
                currMyLinkedNode = currMyLinkedNode.getNext();
            }
        }
    }

    @Override
    public T remove(int index) {

        if(isEmpty() || index < 0 || index > size()){
            return null;
        }

        MyLinkedNode currMyLinkedNode = head;
        int currIndex = 0;

        while(currIndex < index){
            currMyLinkedNode = currMyLinkedNode.getNext();
            currIndex += 1;
        }

        if(index == size()){
            T output = (T) currMyLinkedNode.getNext().getData();
            currMyLinkedNode.setNext(null);
            return output;
        }

        T output = (T) currMyLinkedNode.getNext().getData();
        currMyLinkedNode.setNext(currMyLinkedNode.getNext().getNext());
        return output;
    }

    @Override
    public int remove(T object) {
        return 0;
    }

    public String toString(){
        String out = "";

        for(int i=0;i<size();i++){
            if(i==size()-1){
                out += String.format("%s.",get(i));
                return out;
            }
            else {
                out += String.format("%s, ", get(i));
            }
        }
        return out;
    }


    public void greaterThan(T element) {
        if(isEmpty()){
            return;
        }

        MyLinkedNode currMyLinkedNode = head;

        while(currMyLinkedNode.getNext() != null) {

            // if next node's data is smaller than the element...
            if (currMyLinkedNode.getNext().getData().compareTo(element) <= 0) {

                // remove next node

                // if at the end of the list, set node to null
                if (currMyLinkedNode.getNext().getNext() == null) {
                    currMyLinkedNode.setNext(null);
                }

                // otherwise skip next node
                else{
                    currMyLinkedNode.setNext(currMyLinkedNode.getNext().getNext());
                }
            }

            // if next node's data is greater or equal to...
            else {

                // ...AND list is sorted...
                if(isSorted){
                    // ...every other element will also be greater
                    return;
                }
                // ...increment
                currMyLinkedNode = currMyLinkedNode.getNext();
            }
        }
    }


    public void lessThan(T element) {
        if(isEmpty()){
            return;
        }

        MyLinkedNode currMyLinkedNode = head;

        while(currMyLinkedNode.getNext() != null) {

            // if next node's data is greater than the element...
            if (currMyLinkedNode.getNext().getData().compareTo(element) >= 0) {

                // remove next node...

                // if sorted, every future node will also be greater and must be removed
                if(isSorted){
                    currMyLinkedNode.setNext(null);
                    return;
                }

                // if at the end of the list, set final Node to null
                else if (currMyLinkedNode.getNext().getNext() == null) {
                    currMyLinkedNode.setNext(null);
                }

                // else, skip next node
                else {
                    currMyLinkedNode.setNext(currMyLinkedNode.getNext().getNext());
                }
            }

            else {
                // increment if nothing was removed
                currMyLinkedNode = currMyLinkedNode.getNext();
            }
        }
    }


    public void equalTo(T element) {
        if(isEmpty()){
            return;
        }

        MyLinkedNode currMyLinkedNode = head;

        while(currMyLinkedNode.getNext() != null) {

            // if next node's data is not equal to the element...
            if (currMyLinkedNode.getNext().getData().compareTo(element) != 0) {

                // remove next node...

                // if at the end of the list, set final Node to null
                if (currMyLinkedNode.getNext().getNext() == null) {
                    currMyLinkedNode.setNext(null);
                }

                // else, skip next node
                else {
                    currMyLinkedNode.setNext(currMyLinkedNode.getNext().getNext());
                }
            }

            else {
                // increment if nothing was removed
                currMyLinkedNode = currMyLinkedNode.getNext();
            }
        }
    }

    public void removeEvery(int n){
        if(n<=0 || n > size()){
            return;
        }
        MyLinkedNode currMyLinkedNode = head;
        int nth = 1;
        int index = 0;
        while(currMyLinkedNode.getNext() != null){
            if(nth == n){
                remove(index);
                nth = 1;
            }
            else{
                currMyLinkedNode = currMyLinkedNode.getNext();
                index += 1;
                nth += 1;
            }
        }
    }

    public static void main(String args[]){
        MyLinkedList myList = new MyLinkedList();

        myList.add('A');
        myList.add('B');
        myList.add('C');
        myList.add('D');
        myList.add('E');
        myList.add('F');

        System.out.println(myList.toString());

        System.out.println(myList.extractGroupsOf(2));
    }
}

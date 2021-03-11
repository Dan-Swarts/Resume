package DataStructures;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList<Integer>(10);
        myList.add(2,20);
        myList.add(6,19);
        myList.add(7,10);
        myList.add(0,40);
        myList.add(60);
        System.out.println(myList);
        myList.remove(0);
        System.out.println(myList);
    }

    // variables:
    private T[] data;
    private int nextEmpty;

    // constructor:
    public MyArrayList(int size){

        data = (T[]) new Comparable[size];
        nextEmpty = 0;
    }

    // methods:
    public int size() {
        return data.length;
    }

    public boolean add(T element) {

        if(element == null){
            return false;
        }

        // if there is no space in the list, creates a new array:
        if(nextEmpty == data.length){
            Comparable<T>[] newData = new Comparable[size() + 1];
            for(int i = 0; i < size(); i++){
                newData[i] = data[i];
            }
            data = (T[]) newData;
        }

        // add the data to the list:
        data[nextEmpty] = element;
        nextEmpty++;
        return true;
    }

    public boolean add(int index, T element) {

        // returns false if element is null or index is invalid:
        if(element == null){
            return false;
        }

        else if(index > size() || index < 0){
            return false;
        }

        Comparable[] temp;

        // if the list is already full, allocate more space:
        if(nextEmpty == size()){
            temp = new Comparable[size() + 1];
            for(int i = 0; i < size(); i++){
                temp[i] = data[i];
            }
            data = (T[]) temp;
        }

        // case 1: element is inserted at or after the next empty position
        if(index >= nextEmpty){
            data[index] = element;
            nextEmpty = index + 1;
            return true;
        }

        // case 2: element is inserted before the next empty position
        temp = new Comparable[size()];

        for(int i = 0; i < index - 1; i++){
            temp[i] = data[i];
        }

        temp[index] = element;

        for(int i = index + 1; i < size() - 1; i++){
            temp[i] = data[i - 1];
        }

        data = (T[]) temp;
        nextEmpty++;
        return true;
    }

    public T remove(int index) {

        if(index < 0 || index >= nextEmpty){
            return null;
        }

        T out = data[index];
        data[index] = null;
        nextEmpty--;

        if(index == nextEmpty){
            return out;
        }

        for(int i = index; i < nextEmpty + 1; i++){
            swap(i,i++);
        }
        return out;
    }

    public int remove(T element) {
        int out;
        for(int i = 0; i < size(); i++){
            if(data[i].compareTo(element) == 0){
                out = i;
                data[i] = null;

            }
        }
        return -1;
    }

    public void clear() {
        data = (T[]) new Comparable[size()];
    }

    public T get(int index) {
        return data[index];
    }

    public int indexOf(T element) {
        for(int i = 0; i < size(); i++){
            if(data[i] == null){}
            else if(element.compareTo((T) data[i]) == 0){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        for(int i = 0; i < size(); i++){
            if(data[i] != null){
                return false;
            }
        }
        return true;
    }

    // this method removes all stray null values
    public void squish(){
        for(int i = 0; i < nextEmpty - 1; i++){
            if(data[i] == null){
                remove(i);
            }
        }
    }

    public void swap(int index1, int index2){
        Comparable temp;
        temp = data[index1];
        data[index1] = data[index2];
        data[index2] = (T) temp;
        return;
    }

    private void quickSort(int start, int end){
        if(start < end){
            int pIndex = partition(start,end);
            quickSort(start,pIndex - 1);
            quickSort(pIndex + 1, end);
        }
    }

    private int partition(int start, int end){
        T pivot = (T) data[end];
        int pIndex = start;
        for(int i = start; i < end; i++){
            if(data[i].compareTo(pivot) <= 0){
                swap(i,pIndex);
                if(i == end){}
                else{
                pIndex++;
                }
            }
        }
        return pIndex;
    }

    public void sort() {
        squish();
        quickSort(0,nextEmpty);
    }


    public String toString(){
        String output = "";
        for(int i = 0; i < size(); i++){
            if(data[i] == null){
                output += "null\n";
            }
            else{output += data[i].toString() + "\n";
            }
        }
    return output;
    }
}
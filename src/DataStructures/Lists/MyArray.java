package DataStructures.Lists;

public class MyArray<T> implements MyList<T> {

    // variables:
    protected T[] data;
    protected int nextEmpty;

    // constructors (default size is 20):
    public MyArray(){
        data = (T[]) new Object[20];
        nextEmpty = 0;
    }

    public MyArray(int size){
        data = (T[]) new Object[size];
        nextEmpty = 0;
    }

    public MyArray(T[] data){
        this.data = data;
        nextEmpty = data.length;
        for(int i = data.length - 2; i >= 0; i--){
            if(data[i] != null){
                if(data[i + 1] == null){
                    nextEmpty = i + 1;
                }
            }
        }
    }

    //methods:
    public int length(){
        return nextEmpty;
    }

    public int size() {
        return data.length;
    }

    public T[] toArray(){
        return data;
    }

    public boolean add(T element) {

        if(element == null){
            return false;
        }

        // if there is no space in the list, creates a new array:
        if(nextEmpty == data.length){
            Object[] newData = new Object[size() + 1];
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

        else if(index < 0 || index > size() - 1){
            return false;
        }

        // case 1: element is inserted at or after the next empty position
        if(index >= nextEmpty){
            data[index] = element;
            nextEmpty = index + 1;
            return true;
        }

        // case 2: element is inserted before the next empty position

        // if the list is already full, allocate more space:

        Object[] temp;
        if(nextEmpty == size()){
            temp = new Comparable[size() + 1];
            for(int i = 0; i < size(); i++){
                temp[i] = data[i];
            }
            data = (T[]) temp;
        }
        // otherwise, we still need a new data array
        else{
            temp = new Comparable[size()];
        }

        for(int i = 0; i < index; i++){
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

    public void clear() {
        data = (T[]) new Comparable[size()];
        nextEmpty = 0;
    }

    public void squish(){ // this method removes all stray null values
        for(int i = 0; i < nextEmpty - 1; i++){
            if(data[i] == null){
                remove(i);
                i--;
            }
        }
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

        Object[] newData = new Comparable[size()];
        for(int i = 0; i < index; i++){
            newData[i] = data[i];

        }

        for(int i = index; i < nextEmpty; i++){
            newData[i] = data[i + 1];
        }

        data = (T[]) newData;

        return out;
    }

    public int remove(T element) {
        int out;
        for(int i = 0; i < nextEmpty; i++){
            if(data[i] == null){}
            else if(data[i] == element){
                out = i;
                data[i] = null;
            }
        }
        return -1;
    }

    public T get(int index) {
        if(index < 0 || index > size() - 1){
            return null;
        }
        return data[index];
    }

    public int indexOf(T element) {
        for(int i = 0; i < size(); i++){
            if(data[i] == null){}
            else if(element.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        for(int i = 0; i < length(); i++){
            if(data[i] != null){
                return false;
            }
        }
        return true;
    }

    public boolean set(int index, T element){
        if(index < 0 || index > size() - 1){
            return false;
        }

        else if(index < nextEmpty){
            data[index] = element;
            return true;
        }

        add(index, element);
        return true;
    }

    public String toString(){
        String output = "";
        for(int i = 0; i < nextEmpty; i++){
            if(data[i] != null){output += data[i].toString() + "\n";
            }
        }
        return output;
    }
}
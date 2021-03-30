package DataStructures.Lists;

import DataStructures.Nodes.LNode;

public class MyOrderedArray<T extends Comparable<T>> extends MyArray {

    // constructors:

    public MyOrderedArray(){
        data = (T[]) new Comparable[20];
        nextEmpty = 0;
    }

    public MyOrderedArray(int size){
        data = (T[]) new Comparable[size];
        nextEmpty = 0;
    }

    public MyOrderedArray(T[] data){
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


    public static void main(String[] args) {

    }

        public void swap(int index1, int index2){
        T temp;
        temp = (T) data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
        return;
    }

    public void sort() {
        selectionSort();
    }

    public void selectionSort(){
        squish();
        if(nextEmpty < 2){
            return;
        }

        for(int i = 0; i < nextEmpty - 1; i++){
            int smallestIndex = i;
            for(int n = i + 1; n < nextEmpty; n++){
                T t1 = (T) data[n];
                T t2 = (T) data[smallestIndex];
                if(t1.compareTo(t2) < 0){
                    smallestIndex = n;
                }
            }
            swap(i,smallestIndex);
        }
    }
}

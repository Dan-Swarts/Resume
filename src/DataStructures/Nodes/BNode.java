package DataStructures.Nodes;

public class BNode<T extends Comparable<T>> { // B stands for "binary", for use in binary trees

    // variables:
    private BNode left;
    private BNode right;
    private T data;

    // constructors:
    public BNode(T data, BNode right, BNode left){
        this.data = data;
        this.right = right;
        this.left = left;
    }
    public BNode(T data){
        this.data = data;
    }

    // getters:
    public T getValue(){
        return data;
    }

    public BNode getRight(){
        return right;
    }

    public BNode getLeft(){
        return left;
    }

    // setters:
    public void setLeft(BNode left){
        this.left = left;
    }
    public void setRight(BNode right){
        this.right = right;
    }
    public void setData(T data){
        this.data = data;
    }
}

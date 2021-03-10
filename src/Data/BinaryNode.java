package Data;

public class BinaryNode<T extends Comparable<T>> {

    // variables:
    private BinaryNode left;
    private BinaryNode right;
    private T data;

    // constructors:
    public BinaryNode(T data, BinaryNode right, BinaryNode left){
        this.data = data;
        this.right = right;
        this.left = left;
    }
    public BinaryNode(T data){
        this.data = data;
    }

    // getters:
    public T getValue(){
        return data;
    }

    public BinaryNode getRight(){
        return right;
    }

    public BinaryNode getLeft(){
        return left;
    }

    // setters:
    public void setLeft(BinaryNode left){
        this.left = left;
    }
    public void setRight(BinaryNode right){
        this.right = right;
    }
    public void setData(T data){
        this.data = data;
    }
}

package DataStructures.StacksAndQueues;

public interface MySimpleList<T> {

// Interface for a Generic Stack

    /* adds an object o to the top of a stack by placing it in the
       reverse order of arrival relative to other items added to the
       stack; that is, last in, first out (LIFO) */

    public void push(T o);

    /* removes and returns the object placed in a stack most recentlt
       relative to any other items presently in the stack */

    public T pop();

    /* returns the Object placed in a stack most recently, or null
       if the stack contains no items */

    public T peek();

    /* returns true when a stack currently contains no items, false
       otherwise */

    public boolean isEmpty();

}

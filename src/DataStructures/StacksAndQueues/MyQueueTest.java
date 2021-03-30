package DataStructures.StacksAndQueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    MyQueue<String> queue = new MyQueue<String>();

    @Test
    public void constructFromArray(){
        String[] test = new String[3];
        test[0] = "Hello";
        test[1] = "World";
        test[2] = "!!!";

        queue = new MyQueue<String>(test);
        String s = queue.toString();
        assertEquals("Hello\nWorld\n!!!\n", s);
    }

    @Test
    public void isEmptyTrue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyFalse(){
        queue.push("hello");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void isEmptyRemoved(){
        queue.push(" ");
        queue.pop();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void push() {
        queue.push("Hello");
        queue.push("World");
        queue.push("!!!");
        assertEquals("Hello\nWorld\n!!!\n", queue.toString());
    }

    @Test
    public void pop() {
        queue.push("Hello");
        assertEquals("Hello", queue.pop());
    }

    @Test
    public void popFIFO(){
        queue.push("Hello");
        queue.push("World");
        assertEquals("Hello", queue.pop());
        assertEquals("World", queue.pop());
    }

    @Test
    public void popEmpty(){
        assertNull(queue.pop());
    }

    @Test
    public void popNull(){
        String[] nullArray = new String[1];
        queue = new MyQueue<String>(nullArray[0]);
        assertNull(queue.pop());
    }

    @Test
    public void peek() {
        queue.push("Hello");
        assertEquals("Hello", queue.peek());
    }

    @Test
    public void peekDoesNotRemove(){
        queue.push("Hello");
        queue.push("World");
        assertEquals("Hello", queue.peek());
        assertEquals("Hello", queue.peek());
    }

    @Test
    public void peekEmpty(){
        assertNull(queue.peek());
    }
}
package DataStructures.StacksAndQueues;

import DataStructures.Lists.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    MyStack<String> stack = new MyStack<String>();

    @Test
    public void constructFromArray(){
        String[] test = new String[3];
        test[0] = "Hello";
        test[1] = "World";
        test[2] = "!!!";

        stack = new MyStack<String>(test);
        assertEquals("!!!\nWorld\nHello\n",stack.toString());
    }

    @Test
    public void isEmptyTrue() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmptyFalse(){
        stack.push("hello");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void isEmptyRemoved(){
        stack.push(" ");
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void push() {
        stack.push("!!!");
        stack.push("World");
        stack.push("Hello");
        assertEquals("Hello\nWorld\n!!!\n",stack.toString());
    }

    @Test
    public void pop() {
        stack.push("Hello");
        assertEquals("Hello",stack.pop());
    }

    @Test
    public void popLIFO(){
        stack.push("World");
        stack.push("Hello");
        assertEquals("Hello",stack.pop());
        assertEquals("World",stack.pop());
    }

    @Test
    public void popEmpty(){
        assertNull(stack.pop());
    }

    @Test
    public void popNull(){
        String[] nullArray = new String[1];
        stack = new MyStack<String>(nullArray[0]);
        assertNull(stack.pop());
    }

    @Test
    public void peek() {
        stack.push("Hello");
        assertEquals("Hello",stack.peek());
    }

    @Test
    public void peekDoesNotRemove(){
        stack.push("World");
        stack.push("Hello");
        assertEquals("Hello",stack.peek());
        assertEquals("Hello",stack.peek());
    }

    @Test
    public void peekEmpty(){
        assertNull(stack.peek());
    }
}
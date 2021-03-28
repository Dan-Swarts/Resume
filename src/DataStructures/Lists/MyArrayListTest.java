package DataStructures.Lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    MyArrayList list;

    // testing the basic add method:
    @Test
    public void addTest1(){
        list = new MyArrayList<Integer>(5);
        Integer i1 = 1;
        Integer i2 = 2;
        Integer i3 = 3;
        Integer i4 = 4;
        Integer i5 = 5;

        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);

        String s = "1\n2\n3\n4\n5\n";

        assertEquals(s,list.toString());
    }

    @Test
    public void addTest2(){
        list = new MyArrayList<Integer>(5);

        // creating a null pointer:
        Integer[] n = new Integer[1];

        // the add(null) function should return false:
        assertFalse(list.add(n[0]));
    }

    @Test
    public void addTest3(){
        list = new MyArrayList<Integer>(5);

        // creating a null pointer:
        Integer[] n = new Integer[4];

        // the null pointer should not add anything to the list
        list.add(n[0]);
        list.add(n[1]);
        list.add(n[2]);
        list.add(n[3]);
        assertEquals("",list.toString());
    }

    @Test
    public void addTest4(){
        list = new MyArrayList<Integer>(5);

        // creating a null pointer:
        Integer[] n = new Integer[4];

        // the null pointer should not update nextEmpty
        list.add(n[0]);
        list.add(n[1]);
        list.add(n[2]);
        list.add(n[3]);
        assertEquals(0,list.length());
    }
}
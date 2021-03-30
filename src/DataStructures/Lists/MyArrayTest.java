package DataStructures.Lists;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {

    MyArray<Integer> list = new MyArray<Integer>();

    // Testing isEmpty():
    @Test
    public void isEmptyTestTrue(){
        assertEquals(true,list.isEmpty());
    }
    @Test
    public void isEmptyTestFalse(){
        list.add(3);
        assertEquals(false,list.isEmpty());
    }

    // Testing size():
    @Test
    public void sizeTest20(){
        list = new MyArray<Integer>(20);
        assertEquals(20,list.size());
    }
    @Test
    public void sizeTest4(){
        list = new MyArray<Integer>(4);
        assertEquals(4,list.size());
    }

    // Testing length():
    @Test
    public void lengthTest0(){
        assertEquals(0,list.length());
    }
    @Test
    public void lengthTest5(){
        list.add(4,40);
        assertEquals(5,list.length());
    }

    // Testing the the add method:
    @Test
    public void add1Element(){
        list.add(1);
        String s = "1\n";
        assertEquals(s,list.toString());
    }
    @Test
    public void add2Elements(){
        list.add(2);
        list.add(3);
        String s = "2\n3\n";
        assertEquals(s,list.toString());
    }
    @Test // Adding more elements than the length of the array (should create a new, larger array)
    public void addGreaterElement(){
        MyArray<Integer> list = new MyArray<Integer>(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        String s = "4\n5\n6\n7\n";
        assertEquals(s,list.toString());
        assertEquals(4,list.length());
    }
    @Test // Testing that add() properly handles null values
    public void addTrue(){
        assertTrue(list.add(8));
    }
    @Test
    public void addNullFalse(){
        Integer[] nullList = new Integer[1];
        assertFalse(list.add(nullList[0]));
    }
    @Test
    public void addNullString(){
        Integer[] nullList = new Integer[4];
        list.add(nullList[0]);
        list.add(nullList[1]);
        list.add(nullList[2]);
        list.add(nullList[3]);
        assertEquals("",list.toString());
        assertEquals(0,list.length());
    }
    @Test
    public void addNullLength(){
        Integer[] nullList = new Integer[4];
        list.add(nullList[0]);
        list.add(nullList[1]);
        list.add(nullList[2]);
        list.add(nullList[3]);
        assertEquals(0,list.length());
    }
    @Test // Testing that add() method properly updates the nextEmpty variable:
    public void testNextEmpty1(){
        list.add(1);
        assertEquals(1,list.length());
    }
    @Test
    public void testNextEmpty4(){
        MyArray<Integer> list = new MyArray<Integer>(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        assertEquals(4,list.length());
    }
    @Test
    public void testNextEmptyNull(){
        Integer[] n = new Integer[1]; // creating a null pointer
        assertEquals(0,list.length());
    }

    // Testing the add(index, element) method:
    @Test
    public void addIndexTest1(){
        list.add(5,200);
        assertEquals(6,list.length());
    }
    @Test
    public void addIndexTest2(){
        list.add(5,200);
        assertEquals("200\n",list.toString());
    }
    @Test
    public void addIndexTest3(){
        list.add(5,200);
        list.add(20);
        assertEquals("200\n20\n",list.toString());
    }
    @Test
    public void addLesserIndex(){
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(2,200);
        assertEquals("7\n8\n200\n9\n10\n",list.toString());
        assertEquals(5,list.length());
    }
    @Test
    public void addIndexTrue(){
        assertTrue(list.add(3,500));
    }
    @Test
    public void addIndexLowerBoundFalse(){
        assertFalse(list.add(-1,300));
    }
    @Test
    public void addIndexUpperBoundFalse(){
        list = new MyArray<Integer>(3);
        assertFalse(list.add(3,400));
        assertFalse(list.add(4,300));
    }
    @Test
    public void addIndexNull(){
        Integer[] nullArray = new Integer[1];
        assertFalse(list.add(0,nullArray[0]));
        list.add(1,nullArray[0]);
        assertEquals("",list.toString());
        assertEquals(0,list.length());
    }


    // Testing the clear() method:
    @Test
    public void clearTestString(){
        list.add(20);
        list.add(30);
        list.add(40);
        list.clear();
        assertEquals("",list.toString());
    }
    @Test
    public void clearTestLength(){
        list.add(20);
        list.add(30);
        list.add(40);
        list.clear();
        assertEquals(0,list.length());
    }


    // Testing the get(index) method:
    @Test
    public void getTest1(){
        list.add(3,200);
        assertEquals(null,list.get(0));
    }
    @Test
    public void getTest2(){
        list.add(3,200);
        assertEquals(200,list.get(3));
    }
    @Test
    public void getTest3(){
        assertEquals(null,list.get(-3));
    }
    @Test
    public void getTest4(){
        MyArray<Integer> list = new MyArray<Integer>(3);
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(null,list.get(3));
        assertEquals(null,list.get(4));
    }

    // Testing the indexOf() method:
    @Test
    public void indexOfTest1(){
        list.add(300);
        list.add(400);
        assertEquals(0,list.indexOf(300));
    }
    @Test
    public void indexOfTest2(){
        list.add(400);
        list.add(500);
        assertEquals(1,list.indexOf(500));
    }
    @Test
    public void indexOfTest3(){
        list.add(30);
        list.add(40);
        assertEquals(-1,list.indexOf(-10));
    }

    // Testing set():
    @Test
    public void setLowTest(){
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.set(3,5);
        assertEquals("3\n4\n5\n5\n",list.toString());
    }
    @Test
    public void setHighTest(){
        list.add(4);
        list.add(5);
        list.set(10,40);
        assertEquals(11,list.length());
        assertEquals("4\n5\n40\n",list.toString());
    }
    @Test void setLowerBoundFalse(){
        assertFalse(list.set(-1,40));
    }

    @Test void setUpperBoundFalse(){
        list = new MyArray<>(5);
        assertTrue(list.set(4,2));
        assertFalse(list.set(5,3));
        assertFalse(list.set(6,4));
    }

    // Testing the squish() method:
    @Test
    public void squishTestLength(){
        list.add(4,200);
        list.add(10,300);
        list.squish();
        assertEquals(2,list.length());
    }
    @Test
    public void squishTestIndex(){
        list.add(4,200);
        list.add(10,300);
        list.squish();
        assertEquals(200,list.get(0));
        assertEquals(300,list.get(1));
    }


    // Testing the remove(Index) method:
    @Test
    public void removeIndexTest1(){
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.remove(2);
        assertEquals("3\n4\n6\n",list.toString());
    }
    @Test
    public void removeIndexTest2(){
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.remove(2);
        assertEquals(3,list.length());
    }

    // testing the remove(element) method:
    @Test
    public void removeItemTest1(){
        MyArray<String> list2 = new MyArray<String>();
        list2.add("Hello");
        list2.add("World");
        list2.add("!!!");
        list2.remove("Hello");
        assertEquals("World\n!!!\n",list2.toString());
    }
    @Test
    public void removeItemTest2(){
        MyArray<String> list2 = new MyArray<String>();
        list2.add("Hello");
        list2.add("World");
        list2.add("!!!");
        list2.remove("World");
        assertEquals("Hello\n!!!\n",list2.toString());
    }
    @Test
    public void removeItemTest3(){
        MyArray<String> list2 = new MyArray<String>();
        list2.add("Hello");
        list2.add("World");
        list2.add("!!!");
        list2.remove("!!!");
        assertEquals("Hello\nWorld\n",list2.toString());
    }
    @Test
    public void removeItemTest4(){
        MyArray<String> list2 = new MyArray<String>();
        list2.add(2,"Hello");
        list2.add(3,"World");
        list2.add(4,"!!!");
        list2.remove("!!!");
        assertEquals("Hello\nWorld\n",list2.toString());
    }


    // Testing the sort method:
    MyOrderedArray<Integer> orderedList = new MyOrderedArray<Integer>();
    @Test
    public void sortTestEmpty(){
        orderedList.sort();
        assertEquals("",list.toString());
    }

    @Test
    public void sortAlreadySorted(){
        orderedList.add(3);
        orderedList.add(4);
        orderedList.add(5);
        orderedList.add(6);
        orderedList.sort();
        assertEquals("3\n4\n5\n6\n",list.toString());
    }

    @Test
    public void sort5Elements(){
        orderedList.add(-400);
        orderedList.add(300);
        orderedList.add(-500);
        orderedList.add(100000);
        orderedList.add(-40);
        orderedList.sort();
        assertEquals("-500\n-400\n-40\n300\n100000\n",list.toString());
    }

    @Test
    public void sortStaggeredElements(){
        orderedList.add(6,-400);
        orderedList.add(0,300);
        orderedList.add(9,-500);
        orderedList.add(11,100000);
        orderedList.add(5,-40);
        orderedList.sort();
        assertEquals("-500\n-400\n-40\n300\n100000\n",list.toString());
    }
}
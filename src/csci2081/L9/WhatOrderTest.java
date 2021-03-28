package csci2081.L9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhatOrderTest {

    WhatOrder what = new WhatOrder();

    @Test
    void checkOrder1() {
        assertEquals(-1,what.checkOrder("bat","hat","mat","sat"));
    }

    @Test
    void checkOrder2(){
        assertEquals(-1,what.checkOrder("bat","hat","mat","sat"));
    }

    @Test
    void checkOrder3() {
        assertEquals(0, what.checkOrder("bat","mat","hat","sat"));
    }

    @Test
    void checkOrderInt1(){
        Integer p1 = 1;
        Integer p2 = 2;
        Integer p3 = 3;
        Integer p4 = 4;
        assertEquals(-1,what.checkOrder(p1,p2,p3,p4));
    }

    @Test
    void checkOrderInt2(){
        Integer p1 = 1;
        Integer p2 = 2;
        Integer p3 = 3;
        Integer p4 = 4;
        assertEquals(1,what.checkOrder(p4,p3,p2,p1));
    }

    @Test
    void checkOrderInt3(){
        Integer p1 = 1;
        Integer p2 = 2;
        Integer p3 = 3;
        Integer p4 = 4;
        assertEquals(0,what.checkOrder(p4,p2,p3,p1));
    }

    @Test
    void checkOrderDouble1(){
        Double d1 = 1.0;
        Double d2 = 2.0;
        Double d3 = 3.0;
        Double d4 = 4.0;
        assertEquals(-1,what.checkOrder(d1,d2,d3,d4));
    }

    @Test
    void checkOrderDouble2(){
        Double d1 = 1.0;
        Double d2 = 2.0;
        Double d3 = 3.0;
        Double d4 = 4.0;
        assertEquals(1,what.checkOrder(d4,d3,d2,d1));
    }

    @Test
    void checkOrderDouble3(){
        Double d1 = 1.0;
        Double d2 = 2.0;
        Double d3 = 3.0;
        Double d4 = 4.0;
        assertEquals(1,what.checkOrder(d4,d2,d3,d1));
    }

    @Test
    void checkOrderFalse1(){
        WhatOrder what = new WhatOrder();
        assertFalse(what.checkOrder("hat","mat","bat","cat") == 1);
    }

}
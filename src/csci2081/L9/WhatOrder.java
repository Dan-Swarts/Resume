package csci2081.L9;

import java.util.Scanner;
public class WhatOrder {

    public WhatOrder(){}

    // TODO: Define a generic method called checkOrder() that
    //       takes in four variables of generic type as arguments.
    //       The return type of the method is integer

    public static <T extends Comparable<T>> int checkOrder(T a, T b, T c, T d) {

        if(a.compareTo(b) == 0 && b.compareTo(c) == 0 && c.compareTo(d) == 0){
            return 0;
        }

        if(a.compareTo(b) >= 0 && b.compareTo(c) >= 0 && c.compareTo(d) >= 0){
            return 1;
        }

        if(a.compareTo(b) <= 0 && b.compareTo(c) <= 0 && c.compareTo(d) <= 0){
            return -1;
        }

        return 0;
    }

    // Check the order of the input: return -1 for ascending,
    // 0 for neither, 1 for descending}

}
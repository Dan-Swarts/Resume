package csci2081.L27;

public class Search {
    public static <T extends Comparable<T>> T findMin(T[] arr) {

        T min = arr[0];

        for (int i = 1; i < arr.length; ++i)
            if (arr[i].compareTo(min) < 0)
                min = arr[i];

        return min;
    }

    public static void main(String [] args) {

        Integer arr1[]  = {15, 20, 10, 12};
        Double arr2[] = {-0.7, -1.2, -0.5};

        //create a new Search class

        System.out.println(findMin(arr1)); // should print 10

        // after making the search class generic,
        // you should be able to uncomment the code between /* and */
        // and compile and run the program
        // the code below should print: -1.2

		Search minDouble = new Search();
		System.out.println(findMin(arr2));

        // Note, you will have to update the 2 lines after the comment
        // create a new search class as well!!!!
    }
}


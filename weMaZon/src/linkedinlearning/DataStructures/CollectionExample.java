package linkedinlearning.DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by oakinrele on Jul, 2020
 */


//Many data structures are often implemented using the concept of linkedList
// Each java collection has an iterator object to traverse the elements


public class CollectionExample {

    public static void main(String [] args)
    {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8);

        System.out.println("Position of value in List is: " + Collections.binarySearch(integerList,23));
    }

}

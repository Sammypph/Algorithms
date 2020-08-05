package linkedinlearning.DataStructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by oakinrele on Jul, 2020
 */



    //One of the most used
    // Not thread safe
    //Access to elements is in constant time

public class ArrayListExample {
    public static void main(String [] args)
    {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8);

        System.out.println("Position of value in List is: " + Collections.binarySearch(integerList,4));

    }
}

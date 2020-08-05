package linkedinlearning.DataStructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by oakinrele on Jul, 2020
 */
public class IteratorExample {

    public static void main(String [] args)
    {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8);
        Iterator iterator = integerList.iterator();


        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}

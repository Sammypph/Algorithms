package linkedinlearning.DataStructures;

import java.util.Vector;

/**
 * Created by oakinrele on Jul, 2020
 */


//One of the first datastructures
    //Behaviour is similar top that of the ArrayList
    //One of the advantage is that vectors are thread safe
    //Comes with automatic syncronization out of the box

public class VectorExample {
    public static void main(String [] args)
    {
        Vector vectorIntegers = new Vector();

        vectorIntegers.add(1);
        vectorIntegers.add(2);
        vectorIntegers.add(3);


        System.out.println(vectorIntegers);



    }

}

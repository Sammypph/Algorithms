package linkedinlearning.DataStructures;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by oakinrele on Jul, 2020
 */
public class LinkedListExample {
    public static void main(String [] args)
    {
        LinkedList states = new LinkedList();
        states.add("Lagos");
        states.add("Abia");
        states.add("Ondo");
        states.add("Abuja");
        states.add("Ogun");

        states.addFirst("Port Harcourt");

        System.out.println(states);


        System.out.println("Last element is : " + states.getLast());


        ListIterator listIterator = states.listIterator(states.size()); // get the index of the last element

        while(listIterator.hasPrevious())
        {
            System.out.println(listIterator.previous());
        }


    }
}

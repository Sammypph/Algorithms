package linkedinlearning.DataStructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by oakinrele on Jul, 2020
 */


//First in first out
public class QueueExample {

    public static void main(String [] args)
    {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <=10 ; i++) {
            queue.add(i);
        }

        System.out.println("ELEMENTS IN MY QUEUE: " +queue);

        int removed = queue.remove();

        System.out.println("First Element: " +removed);

        int firstElement = queue.peek();

        System.out.println("The current first element is: " +firstElement);
    }
}

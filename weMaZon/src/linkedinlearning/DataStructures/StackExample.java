package linkedinlearning.DataStructures;

import java.util.Stack;

/**
 * Created by oakinrele on Jul, 2020
 */


//Before popping it is important to test for an empty stack
    //Easy was to reverse a collection of values
public class StackExample {

    public static void main(String [] args)
    {
        Stack stack = new Stack();

        for (int i = 0; i < 10 ; i++) {
            stack.push(i);
        }


        while(!stack.isEmpty())
        {
            System.out.print(stack.pop());
            System.out.print(",");
        }

        System.out.println("LIFT-OFF!!!");
    }
}

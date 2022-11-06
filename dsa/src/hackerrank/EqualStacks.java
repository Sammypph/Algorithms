package hackerrank;

import java.util.Stack;

/**
 * Created by oakinrele on Feb, 2020
 */
public class EqualStacks {
    /*
     * Complete the equalStacks function below.
     */
    static Stack<Integer> firstStack;
    static Stack<Integer> secondStack;
    static Stack<Integer> thirdStack;
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        if(h1.length == 0 || h2.length == 0 || h3.length == 0)
        {
            return 0;
        }

        int maxHeight = 0;
        firstStack = createStack(h1);
        secondStack = createStack(h2);
        thirdStack = createStack(h3);

        maxHeight = findMaxHeight(firstStack,secondStack,thirdStack);

        return maxHeight;
    }

    static int findMaxHeight(Stack firstStack, Stack secondStack, Stack thirdStack)
    {
        while(!firstStack.isEmpty() &&!secondStack.isEmpty() && !thirdStack.isEmpty())
        {
            if((int)firstStack.peek() > (int)secondStack.peek()  ||
                    (int)firstStack.peek() > (int)thirdStack.peek())
            {
                firstStack.pop();
            }

            else if((int)secondStack.peek() > (int)firstStack.peek()  ||
                    (int)secondStack.peek() > (int)thirdStack.peek())
            {
                secondStack.pop();
            }

            else if((int)thirdStack.peek() > (int)firstStack.peek()  ||
                    (int)thirdStack.peek() > (int)secondStack.peek())
            {
                thirdStack.pop();
            }

            else
            {
                return (int)firstStack.peek();
            }
        }
        return 0;
    }

    public static Stack<Integer> createStack(int [] input)
    {
        Stack<Integer> inputStack = new Stack<>();
        inputStack.push(input[input.length - 1]);
        for(int i = input.length - 2; i >= 0; i--)
        {
            inputStack.push(inputStack.peek() + input[i]);
        }

        return inputStack;
    }


    public static void main(String [] args)
    {
        System.out.println(equalStacks(new int[]{1,1,1,1,2},new int[]{3,7},new int[]{1,3,1}));
    }
}

package hackerrank;

import java.util.*;

/**
 * Created by oakinrele on Feb, 2020
 */
public class maximumElement {

    public static int maxElement() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        Stack<StackNode> stack = new Stack<>();
        while (n > 0) {
            int choice = sc.nextInt();
            if(choice == 1) {
                int val = sc.nextInt();
                max = Math.max(val, max);

                stack.add(new StackNode(val, max));
            } else if(choice == 2) {
                if(!stack.isEmpty())
                    stack.pop();
                // reset max
                if(stack.isEmpty())
                    max = Integer.MIN_VALUE;
                else
                    max = stack.peek().currentMax;
            } else if(choice == 3) {
                if(!stack.isEmpty()) {
                    System.out.println(stack.peek().currentMax);
                }
            }

            n--;
        }
        sc.close();
        return max;

    }





    public static void main(String [] args){
        Integer [] numbers = new Integer[]{5,2,1,4,0};
        int x = 9;
        int i = 2;

        double second = (double)i;

        Arrays.sort(numbers);

        System.out.println(x%i);
    }





    static class StackNode{
        int val;
        int currentMax;

        StackNode(int val, int currentMax)
        {
            this.val = val;
            this.currentMax = currentMax;
        }

        public String toString() {
            return val + " [" + currentMax + "]";
        }
    }
}






class CustomStack<T> extends Stack<T>
{
    int max;

    CustomStack(int max)
    {
        this.max = max;
    }

    public CustomStack() {
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}


class CustomStackComparator implements Comparator<CustomStack>
{
    @Override
    public int compare(CustomStack first, CustomStack second)
    {
        return first.getMax() - second.getMax();
    }
}
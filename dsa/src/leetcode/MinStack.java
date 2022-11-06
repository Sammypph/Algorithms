package leetcode;

import java.util.Stack;

/**
 * Created by oakinrele on Apr, 2020
 */
public class MinStack {
    /** initialize your data structure here. */


    int minimum = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
      if(x <= minimum){ setMin(x);}
      stack.push(x);
    }

    public void pop() {
     stack.pop();
     minimum = Integer.MAX_VALUE;
    }

    public int top() {
        return stack.elementAt(stack.size() -1);
    }

    public int getMin() {
        for (int value: stack) {
            if(value < minimum)
            {
                minimum = value;
            }
        }
     return minimum;
    }

    public void setMin(Integer min) {
        this.minimum = min;
    }


    public static void main(String [] args)
    {
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());     // Returns -3.
//        minStack.pop();
//        System.out.println(minStack.top());       //Returns 0.
//        System.out.println(minStack.getMin());    //Returns -2.


//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        //minStack.push(0);
//        System.out.println(minStack.getMin());     // Returns -3.
//        minStack.pop();
//        System.out.println(minStack.top());     // Returns 0.
//        //minStack.pop();
//        System.out.println(minStack.getMin());     // Returns -2.


        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }



   class MinStack2
   {
       Stack<CustomObject> stack;
       public MinStack2() {
           stack = new Stack<>();
       }

       public void push(int x) {
           if(stack.isEmpty()) {
               stack.push(new CustomObject(x, x));
           }
           else {
               //Get the current minimum value and compare to the input
               int currentMinimum = stack.peek().min;
               stack.push(new CustomObject(x, Math.min(x, currentMinimum)));
           }
       }

       public void pop() {
           stack.pop();
       }

       public int top() {
           return stack.peek().val;
       }

       public int getMin() {
           return stack.peek().min;
       }
   }



    class CustomObject
    {
        int val;
        int min;
        public CustomObject(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}




package linkedinlearning.Recursion;

/**
 * Created by oakinrele on Jul, 2020
 */


//The concept of recursion is to take big problems and break it down into smaller problems
    //Recursion is when a method calls itself
    //The solution uses smaller instances of the same problem.
    //First, create a baseCase. We need to know when it's done.


    //Goes down and then up the stack.

    //Tower of Hanoi = 2 ^ n - 1

public class RecursionExample {
    public static void main(String [] args)
    {
        //Reverse a List

        int [] numberList = {10,20,30,40,50};
        reverseList(numberList);
        System.out.println(" ");
        System.out.println(factorial(0));
        System.out.println(GreatestCommonDivisor(58,16));

    }




    public static void reverseList(int [] numbers)
    {
       if(numbers.length == 0)
       {
           return;
       }

       int [] reversedList = new int [numbers.length - 1];
        for (int i = 0; i < reversedList.length; i++){
            //Skip first element and move rest of elements into array
            //Manual copying of elements excluding the first element.
            reversedList[i] = numbers[i + 1];
        }
            reverseList(reversedList);

        //20 30 40 50
        //30 40 50
        //40 50
        //50
        //return


            //We take the first value out to print it.
            System.out.print(numbers[0] + " ");

    }



    public static int factorial(int num)
    {
        if(num == 0)
        {
            return 0;
        }
        if(num == 1)
        {
            return 1;
        }

        return num * factorial(num - 1);
    }


    public static int GreatestCommonDivisor(int a , int b)
    {
       int temp = a;
       if(a < b)
       {
           a = b;
           b = temp;
       }

       if(b == 0)
       {
           return a;
       }

       int remainder = (a%b);
       return GreatestCommonDivisor(b,remainder);

    }


}

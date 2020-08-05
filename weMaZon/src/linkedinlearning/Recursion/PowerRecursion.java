package linkedinlearning.Recursion;

/**
 * Created by oakinrele on Jul, 2020
 */

//x ^ 4   This means X multiplied by itself n-1 times.

    // if n is even : x ^ n = (x ^ n/2) * (x ^ n/2)
    // if n is odd : x ^ n = x * (x ^ n/2) * (x ^ n/2)

public class PowerRecursion {

    public static void main(String [] args)
    {
        System.out.println(power(3,8));
    }


    public static double power(double number , int exponential)
    {
       double temp;
       if(exponential == 0)
           return 1.0;

       temp = power(number,exponential/2);
       temp = temp * temp;

       if(exponential % 2 == 0)
           return temp;

       return number * temp;
    }

}

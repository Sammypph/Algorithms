package leetcode;

import java.util.HashSet;

/**
 * Created by oakinrele on Apr, 2020
 */
public class HappyNumber {
    static HashSet<Integer> seen = new HashSet<>();
    public static boolean isHappy(int n) {
     if(n == 1)
     {
         return true;
     }

     return isHappyHelper(n);
    }


    public static boolean isHappyHelper(int n)
    {
        seen.add(n);
        int input = 0;
        String value = n + "";
        char [] valueArray = value.toCharArray();

        for (char number : valueArray) {
            input += Math.pow(Integer.parseInt(number +""),2);
        }

        if(input == 1)
        {
            return  true;
        }

        else if(seen.contains(input))
        {
            return false;
        }

        else
        {
           return isHappyHelper(input);
        }
    }


    public static void main(String [] args)
    {
        System.out.println(isHappy(13));
    }
}

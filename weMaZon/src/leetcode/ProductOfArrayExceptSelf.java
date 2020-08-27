package leetcode;

/**
 * Created by oakinrele on Apr, 2020
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        int count = 0;
        int snail = 0;
        int product = 1;
        for(int heir = 0; snail < nums.length; heir++)
        {
             if(heir != snail)
             {
                 product *= nums[heir];
             }
            result[snail] = product;
            snail++;
            //Reset the value of i
            heir = 0;
        }

        return result;
    }

    public static void main(String [] args)
    {
        int [] input = {1,2,3,4};
        System.out.println(productExceptSelf(input));
    }
}

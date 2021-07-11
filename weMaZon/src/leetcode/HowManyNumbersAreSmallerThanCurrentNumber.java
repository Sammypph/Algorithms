package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oakinrele on Apr, 2020
 */
public class HowManyNumbersAreSmallerThanCurrentNumber {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int [] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
                int count = 0;
                for(int j = 0; j < nums.length; j++)
                {
                    if(nums[i] > nums[j])
                    {
                        count++;
                    }
                }

                result[i] = count;
        }
        return result;
    }


    public static int[] smallerNumbersThanCurrentLeastOptimized(int[] nums) {
        int [] result = new int[nums.length];
        int currentPosition = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums.length == 1)
            {
                break;
            }

            else if(nums[currentPosition] > nums[i])
            {
                count++;
            }

            if(i == nums.length - 1)
            {
                result[currentPosition] = count;
                currentPosition++;
                i = -1;
                count = 0;
            }


            if(currentPosition > nums.length - 1)
            {
                break;
            }
        }
        return result;
    }


    public static int[] smallerNumbersThanCurrentOptimized(int[] nums) {
       int currentPosition = 0;
       int currentValue = nums[currentPosition];
       int count = 0;
       int [] result = new int[nums.length];

        for (int val: nums){
            if(currentValue > val)
            {
                count++;
            }
        }

        return new int[]{};
    }




    public static void main(String [] args)
    {
//        int [] nums = {7,7,7,7};
//
//        int [] nums2 = {6,5,4,8};
//
//
//        //smallerNumbersThanCurrent(nums);
//       // smallerNumbersThanCurrentOptimized(nums2);
//       // System.out.println();
//
//
//
//        String x = "7";
//        int y = 1;
//
//        System.out.println(x + y);


    }
}

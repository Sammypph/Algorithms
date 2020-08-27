package leetcode;

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




    public static void main(String [] args)
    {
        int [] nums = {7,7,7,7};
        smallerNumbersThanCurrent(nums);


    }
}

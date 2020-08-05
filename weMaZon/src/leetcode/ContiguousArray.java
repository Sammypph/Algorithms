package leetcode;

/**
 * Created by oakinrele on Apr, 2020
 */
public class ContiguousArray {
    static int maxLength = 0;
    public static int findMaxLength(int[] nums) {

        int numberOfOne = 0;
        int numOfZero = 0;


        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numOfZero++;
            }

            if (nums[i] == 1) {
                numberOfOne++;
            }
        }

        return Math.min(numOfZero,numberOfOne) * 2;
    }



    public static int findMaxLengthSolution(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            }

            if (nums[i] == 1) {
                count++;
            }
        }

        return 0;
    }




    public static void main(String [] args)
    {
        System.out.println(findMaxLength(new int []{0,1,0}));
        System.out.println(findMaxLength(new int []{0,0,0,1,1,1,0}));
        System.out.println(findMaxLength(new int []{0,1,1,0,1,1,1,0}));
    }
}


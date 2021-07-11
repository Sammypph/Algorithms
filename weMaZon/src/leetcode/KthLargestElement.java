package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by oakinrele on Apr, 2021
 */
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove();
    }

    public int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length-k];
    }


    public static void main(String[] args) {
        int [] input = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(input,2));
    }
}



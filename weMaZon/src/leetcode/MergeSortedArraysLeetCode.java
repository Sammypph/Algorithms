package leetcode;

import java.util.Arrays;

/**
 * Created by oakinrele on Aug, 2020
 */
public class MergeSortedArraysLeetCode {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int initialPosition = 0;

        //Merge both Arrays   O(m)
        for(int i = m ; i < (m + n); i++)
        {
            nums1[i] = nums2[initialPosition];
            if(initialPosition < n)
            {
                initialPosition++;
            }
        }

        //Sort the array O(nlogn) where n is the length of both arrays (m + n)
        Arrays.sort(nums1);
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oakinrele on May, 2020
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> valueFreq = new HashMap<>();
        int majorityElement = Integer.MIN_VALUE;
        int majorityElementFrequency = Integer.MIN_VALUE;

        for(int num : nums) {
            if (!valueFreq.containsKey(num)) {
                valueFreq.put(num, 1);
            } else {
                valueFreq.put(num, valueFreq.get(num) + 1);
            }
        }


        for(Map.Entry<Integer,Integer> intMap : valueFreq.entrySet())
        {
            if(intMap.getValue() > majorityElementFrequency)
            {
                majorityElement = intMap.getKey();
                majorityElementFrequency = intMap.getValue();
            }
        }

        return majorityElement;

    }



    public static void main(String [] args)
    {
        System.out.println(majorityElement(new int[] {3,3,4}));
        // System.out.println(majorityElement(new int[] {3,2,3}));
        //System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));

    }
}

package leetcode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

/**
 * Created by oakinrele on Aug, 2020
 */
public class HIndex {


    public static int hIndex(int[] citations) {
        //Arrays are reference types so sorting will impact the initial values
        Arrays.sort(citations);
        int totalPapers = citations.length;
        int hIndex = 0;

        for(int i = totalPapers - 1; i >=0; i--)
        {
           hIndex = totalPapers- i;
          //if the count of items to the right is larger than current value it means that's the max we can expect for hIndex

            if (hIndex - 1 >= citations[i])
            {
                return hIndex - 1;
            }

        }
        return hIndex;
    }


    public static void main(String [] args)
    {  // 1, 2, 3, 4 , 5
        //0,1,3,5,6
         // Yes, Yes , Yes ,


        System.out.println(hIndex(new int[]{3,0,6,1,5}));
    }
}

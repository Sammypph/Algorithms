package FireCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by oakinrele on Feb, 2020
 */
public class MergeTwoSortedArrays {
    public static int[] merge(int[] arrLeft, int[] arrRight){
        if(arrLeft.length < 1 && arrRight.length < 1)
        {
            return new int[]{};
        }

        List<Integer> mergedArray = new ArrayList<>();
        for(Integer value : arrLeft)
        {
            mergedArray.add(value);
        }

        for(Integer value : arrRight)
        {
            mergedArray.add(value);
        }

        Collections.sort(mergedArray);

        int [] merged = new int[mergedArray.size()];

        for(int i = 0; i < mergedArray.size(); i++)
        {
            merged[i] = mergedArray.get(i);
        }

        return merged;

    }


        public static int[] mergeUsingMergeSort(int[] arrLeft, int[] arrRight){

        final char emptyChar= ' ';
        if(arrLeft.length < 1 && arrRight.length < 1)
            {
                return new int[]{};
            }

            if(arrLeft.length < 1 && arrRight.length >= 1)
            {
                return arrRight;
            }

            if(arrRight.length < 1 && arrLeft.length >= 1)
            {
                return arrLeft;
            }

            int [] mergeArray = new int[arrLeft.length + arrRight.length];
            if(arrLeft[arrLeft.length -1] <= arrRight[0])
            {
                for(int i = 0; i < arrLeft.length; i++)
                {
                    mergeArray[i] = arrLeft[i];
                }

                for(int j = 0; j < arrRight.length; j++)
                {
                    mergeArray[j + arrLeft.length] = arrRight[j];
                }
            }

            else
            {
                for(int i = 0; i < arrRight.length; i++)
                {
                    mergeArray[i] = arrRight[i];
                }

                for(int j = 0; j < arrLeft.length; j++)
                {
                    mergeArray[j + arrRight.length] = arrLeft[j];
                }
            }


            return mergeArray;
        }



    public static void main(String [] args)
    {
        mergeUsingMergeSort(new int [] {2,5,7,8,9}, new int [] {9});
        //mergeUsingMergeSort(new int [] {7,8}, new int [] {1,2});
    }
}

package hackerrank;

import java.util.Arrays;

/**
 * Created by oakinrele on Jul, 2020
 */


public class BigSorting {
    static String[] bigSorting(String[] unsorted) {

        int [] unsortedInt = new int[unsorted.length];
        String [] sorted = new String[unsorted.length];


        for(int i = 0; i<unsorted.length; i++)
        {
            unsortedInt[i] = Integer.parseInt(unsorted[i]);
        }

        Arrays.sort(unsortedInt);

        for(int i = 0; i < sorted.length; i++)
        {
          sorted[i] = unsortedInt.toString();
        }
        return sorted;
    }





    public static void main(String [] args)
    {
       // BigInteger value = 12303479849857341718340192371;

       // bigSorting(new String[]{"8" , "1", "2" , "100"  , "12303479849857341718340192371" , "3084193741082937" , "3084193741082938" , "111" , "200"});
    }
}

package firecode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class MaxGain {
    public static int maxGain(int[] a) {
   int max = 0;
   int min = a[0];
   int difference;

   for(int i = 1; i < a.length; i++)
   {
       difference = a[i] - min;
       if(difference > max)
       {
           max = difference;
       }

       if(a[i] < min)
       {
           min = a[i];
       }
   }
   return max;
    }





    public static void main(String [] args)
    {
        int [] array = new int[]{100,40,20,10};
        System.out.println(maxGain(array));
    }
}

package firecode;

/**
 * Created by oakinrele on Jan, 2020
 */
public class BubbleSort {

    public static int [] sort(int [] arr)
    {
        if(arr == null )
        {
            return null;
        }

        if(arr.length <= 1)
        {
            return arr;
        }

        int arrLen = arr.length -1;

        for(int i = 0; i < arrLen; i++)
        {
            for(int j = i+1; j <= arrLen; j++)
            {

                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;

    }







    public static void main(String [] args)
    {
        sort(new int[]{2,3,4,1,5});
    }
}

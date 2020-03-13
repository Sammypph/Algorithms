package FireCode;

/**
 * Created by oakinrele on Jan, 2020
 */
public class SelectionSort {

    public static int[] selectionSortArray(int[] arr)
    {
        int arrLen = arr.length -1;
        int smallest = 0;

        if(arr.length <= 1)
        {
            return arr;
        }

        for(int i = 0; i <= arrLen; i++)
        {
            for(int j = i; j <= arrLen; j++)
            {
                smallest = arr[i];
                if(arr[i] > arr[j])
                {
                    smallest = arr[j];
                    arr[j] = arr[i];
                    arr[i] = smallest;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSortArrayFireCode(int[] arr){
        // Add your code below this line. Do not modify any other code.
        for(int i=0;i<arr.length-1;i++){
            int minElem = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minElem] > arr[j]){
                    minElem = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minElem];
            arr[minElem] = tmp;
        }
        // Add your code above this line. Do not modify any other code.
        return arr;
    }



    public static void main(String [] args)
    {
       selectionSortArray(new int [] {65,56,6,3,1});
    }
}

package firecode;

import java.util.Arrays;

/**
 * Created by oakinrele on Mar, 2021
 */
public class BinarySearch {

    public static Boolean binarySearch(int[] arr, int n){
        //BinarySearch works on a sort list
        //Find the length of the array and divide it by 2
        //If the target is equal to the value in the middle, return true;
        //if the value is less than than the value in the middle, left side of the array and if it's great explore value on the right side
        //Repeat step (1,2,3) till all values in the array as been explore
        //return false if the value is not in the array.

        if(arr.length < 1){
            return false;
        }

          return binarySearchHelper2(arr,n);
          //return binarySearchHelper3(arr,0,arr.length -1, n);
    }

    //Not optimized cause
    private static Boolean binarySearchHelper(int[] arr, int target){
        int arrLen = arr.length;
        int mid = arrLen/2;


     if(arrLen >= 1) {

         if (target == arr[mid]) {
             return true;
         }

         //Explore Left side
         if (target < arr[mid]) {
             return binarySearchHelper(Arrays.copyOfRange(arr, 0, mid), target);
         }

         //Explore Right side
         else {
             return binarySearchHelper(Arrays.copyOfRange(arr, mid, arrLen), target);
         }
     }

        return false;
    }

    //Performs slower cause of the Array.copy being used.
    //NB: If it's the index of the value in the initial array we are looking for this solution will never work

    private static Boolean binarySearchHelper2(int[] arr, int target){
        int arrLen = arr.length;
        int mid = arrLen/2;

        if(target == arr[mid]){
            return true;
        }

        //Explore Left side
        if(target < arr[mid] && arrLen > 1){
            return binarySearchHelper(Arrays.copyOfRange(arr,0, mid),target);
        }

        //Explore Right side
        else if(arrLen > 1){
            return binarySearchHelper(Arrays.copyOfRange(arr,mid,arrLen),target);
        }

        return false;
    }



    //Most Optimized
    private static Boolean binarySearchHelper3(int[] arr,int firstIndex, int lastIndex, int target){

        if(lastIndex >= firstIndex) {
            int mid = firstIndex + (lastIndex - firstIndex)/ 2;

            if (arr[mid] == target) {
                return true;
            }

            //Explore Left side
            if (arr[mid] > target) {
                return binarySearchHelper3(arr,firstIndex,mid -1,target);
            }

            //Explore Right side
            else {
                return binarySearchHelper3(arr,mid+1,lastIndex,target);
            }
        }

        return false;
    }



    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2,5,7,9,12},12));
    }
}

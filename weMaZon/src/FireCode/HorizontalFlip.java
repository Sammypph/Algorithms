package FireCode;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Created by oakinrele on Jan, 2020
 */
public class HorizontalFlip {

    public static void flipHorizontalAxis(int[][] matrix)
    {
//        for (int i = 0; i < matrix.length - 1; i++)
//        {
//            int[] temp = matrix[i];
//            matrix[i] = matrix[i+1];
//            matrix[i+1] = temp;
//        }

        int temp;
        int c = (matrix[0].length - 1);
        for (int i = 0; i <= matrix.length - 1; i++)
        {
            for(int j = 0; j <= c/2 && j > 0; j++)
            {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][c - j];
                matrix[i][c - j] = temp;
            }

        }

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                System.out.printf("%5d ", matrix[i][j]);
            }
            System.out.println();
        }


        int value = 'a';




        String name = "not unique";

        name.toUpperCase();
        name.replace(" ", "");
        int [] alphabet = new int[256];
        boolean isUnique = true;

        for(int i = 0; i < name.length(); i++)
        {
            int ascii = name.charAt(i);
            alphabet[ascii] = alphabet[ascii] + 1;
        }

        for (int values: alphabet)
        {
            if(values > 1)
            {
                isUnique = false;
            }
        }

        System.out.println(isUnique);
        System.out.println(matrix);
    }


    public static void isStringPalindrome(String str)
    {
           /// return  str.isEmpty() || str.equals(null)? true : false;


        //Get length of string and store in a variable to avoid having to calculate it everytime in the for loop
//        String name = "sanmi";
//        char [] nameToCharArray = name.toCharArray();
//        int stringLength = name.length() - 1;
//        //Reverse the String First
//        for(int i = 0; i <= stringLength/2; i++)
//        {
//            char temp = nameToCharArray[i];
//            nameToCharArray[i] = nameToCharArray[stringLength - i];
//            nameToCharArray[stringLength - i] = temp;
//        }

    }

public static void findNumberThatAppearsOnce() {
    int[] A = {1,2,3,4,1,2,4,3,5,1};
    HashMap<Integer,Integer> valuesAndCount = new HashMap<>();
    int uniqueNumber = 0;

    for(int i = 0; i < A.length; i++)
    {
        int counter = 0;
        for(int number : A)
        {
            if(A[i] == number)
            {
                counter++;
            }
        }

        valuesAndCount.put(A[i], counter);

        System.out.println(valuesAndCount.get(A[i]));
    }

    System.out.println("Sanmi");

}




    public static void duplicate(int[] numbers){
        List<String> duplicateList = new ArrayList<>();
        HashMap<Integer, Integer> hash_map = new HashMap<Integer, Integer>();

        for(int i = 0; i < numbers.length; i++)
        {
            int next = numbers[i]++;


            int counter = 0;
            for(int number : numbers)
            {
                if(numbers[i] == number)
                {
                    counter++;
                }
            }
            hash_map.put(numbers[i], counter);
        }

        for (Map.Entry<Integer, Integer> entry : hash_map.entrySet())
        {
            if(entry.getValue() > 1)
            {
                duplicateList.add(entry.getKey().toString());
            }
        }

    }


    public static void replace(String a, String b)
    {

    }


    public static Boolean binarySearch(int[] arr, int n)
    {
        // Think about maintaining the boundaries of your array with a lo
        // index and a hi index. lo=0; hi=length - 1;
        int lo = 0;
        int hi = arr.length - 1;
        // Use a while loop to iterate until lo <= hi. The moment that lo exceeds
        // hi, we can be sure that the entire array has been searched.
        while(lo <= hi){
            // Create a mid index. int mid = lo + (hi-lo)/2;
            int mid = lo + (hi-lo)/2;
            // If arr[mid] < n, set lo = mid+1 to divide the array
            if(arr[mid] < n) lo = mid+1;
                // Else If arr[mid] > n, set hi = mid - 1 to divide the array
            else if(arr[mid] > n) hi = mid-1;
                // Otherwise, return true!
            else return true;
        }
        return false;
    }


    public static void main(String [] args)
    {
        int [][] matrix = {{1,2,3},{1,2,3,4}};

        //1 ,2 , 3
        //1, 2 , 3

        // 2, 1, 3
        //2, 1, 3
       //flipHorizontalAxis(matrix);


        //duplicate(new int[]{1,2,4,4,4});

       // isStringPalindrome("madam");
        findNumberThatAppearsOnce();
    }



    public static Character firstNonRepeatedCharacter(String str)
    {
        Character uniqueCharacter = null;
        int lengthOfString = str.length();
        int [] ascii = new int[256];

        for(int i = 0; i < lengthOfString; i++)
        {
            int asciiPosition = str.charAt(i);
            ascii[asciiPosition]++;
        }

        for(int i = 0; i < ascii.length; i++)
        {
            if(ascii[i] == 1)
            {
                uniqueCharacter = (char)i;
                break;
            }
        }

        return uniqueCharacter;
    }


    public static Character firstNonRepeatedCharacterSecondSolution(String str) {
        // Add your code below this line. Do not modify any other code.
        if(str==null || str.length()==0) return null;

        int[] charQuantity = new int[256];
        for(char currentCharacter : str.toCharArray()) {
            charQuantity[currentCharacter] += 1;
        }
        for(char currentCharacter : str.toCharArray()) {
            if(charQuantity[currentCharacter]==1) {
                return currentCharacter;
            }
        }
        return null;
        // Add your code above this line. Do not modify any other code.
    }







}



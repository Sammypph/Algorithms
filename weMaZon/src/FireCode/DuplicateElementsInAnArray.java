package FireCode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by oakinrele on Feb, 2020
 */
public class DuplicateElementsInAnArray {
    public static String duplicate(int[] numbers){
        List<Integer> repeatedIntegers = new ArrayList<>();
        Map<Integer,Integer> keyValue = new HashMap<>();
        int count = 1;
        for(int i = 0; i < numbers.length; i++)
        {
            if(!keyValue.containsKey(numbers[i]))
            {
                keyValue.putIfAbsent(numbers[i],count);
            }
            else
            {
                keyValue.put(numbers[i],keyValue.get(numbers[i])+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : keyValue.entrySet())
        {
            if(entry.getValue() > 1)
            {
                repeatedIntegers.add(entry.getKey());
            }
        }

        Collections.sort(repeatedIntegers);
        return repeatedIntegers.toString();
    }



    // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

    public static String duplicatePreviousSolution(int[] numbers)
    {
        int lengthOfArray = numbers.length - 1;
        List<Integer> duplicateNumbers = new ArrayList<>();
        if(numbers == null)
        {
            return null;
        }
        Arrays.sort(numbers);

        for(int i = 0; i < lengthOfArray; i++)
        {
            if(numbers[i] == numbers[i+1])
            {
                duplicateNumbers.add(numbers[i+1]);
            }
        }

        return duplicateNumbers.toString();
    }



    public static void main(String [] args)
    {
        //System.out.println(duplicate(new int [] {1,3,4,2,1}));
        System.out.println(duplicate(new int [] {5,1,3,4,2,1,2,4,5,5}));
        System.out.println(duplicatePreviousSolution(new int [] {5,1,3,4,2,1,2,4,5,5})); //Fails for this input
    }
}

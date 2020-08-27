package firecode;

import java.util.*;

/**
 * Created by oakinrele on Jan, 2020
 */
public class repeatedElements
{
    public static String duplicateMySolution(int[] numbers)
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


        public static String duplicate(int[] numbers)
        {
            // Add your code below this line. Do not modify any other code.
            Set<Integer> map = new HashSet<>();
            Set<Integer> list = new TreeSet<>();
            for (int num : numbers) {
                if (map.contains(num)) list.add(num);
                else map.add(num);
            }

            return list.toString();
        }

}

package hackerrank;

import java.util.*;

/**
 * Created by oakinrele on Mar, 2020
 */
public class FrequencyQueries {
 //New implementation
 // Complete the freqQuery function below.

//   -  1 : Insert x in your data structure.
//  -  2 : Delete one occurence of y from your data structure, if present.
//-  3 : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.


    //Create a Map of Frequency -> Value


    // Complete the freqQuery function below.
    static Map<Integer,Integer> listToMap = new HashMap<>();
    static List<Integer> output = new ArrayList<>();
    static Set<Integer> valueSet = new HashSet<>();
    static Set<Integer> treeSet = new TreeSet<>();
    static Map<Integer, Integer> freqValueMap = new HashMap<>();
    static List<Integer> integers = new ArrayList<>();

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        return performOperation(queries);
    }

    static List<Integer> performOperation(List<List<Integer>> inputs)
    {
        for(List<Integer> value : inputs)
        {
            if(value.get(0) == 1)
            {
                insert(value);
                if(!freqValueMap.containsKey(listToMap.getOrDefault(value.get(1),0)))
                freqValueMap.put(listToMap.getOrDefault(value.get(1),0), (listToMap.getOrDefault(value.get(1),0)));
                else
                freqValueMap.put(listToMap.getOrDefault(value.get(1),0), (listToMap.getOrDefault(value.get(1),0)) + 1);
            }

            else if(value.get(0) == 2)
            {
                delete(value);
                if(!freqValueMap.containsKey(listToMap.getOrDefault(value.get(1),0)))
                freqValueMap.put(listToMap.getOrDefault(value.get(1),0), (listToMap.getOrDefault(value.get(1),0)));
                else
                    freqValueMap.put(listToMap.getOrDefault(value.get(1),0), (listToMap.getOrDefault(value.get(1),0)) - 1);
            }

            else if(value.get(0) == 3)
            {
                checkIfValueIsPresent(value);
            }
        }
        return output;
    }

    public static void insert(List<Integer> input)
    {
        if(!listToMap.containsKey(input.get(1)))
        {
            listToMap.put(input.get(1), 1);
        }

        else
        {
            listToMap.put(input.get(1), listToMap.getOrDefault(input.get(1),0) + 1);
        }

    }


    public static void delete(List<Integer> input)
    {
        if(listToMap.containsKey(input.get(1)))
        {
            if(listToMap.get(input.get(1)) == 0)
            {
                listToMap.put(input.get(1), listToMap.getOrDefault(input.get(1),0));
            }
            else
            {
                listToMap.put(input.get(1), listToMap.get(input.get(1)) - 1);
            }
        }
    }

    public static void checkIfValueIsPresent(List<Integer> value)
    {
        if (freqValueMap.getOrDefault(value.get(1),0) > 0) { output.add(1); }
        else { output.add(0);}
    }



 public static void main(String [] args)
 {
     List<List<Integer>> input = new ArrayList<>();
//     input.add(Arrays.asList(1,1));
//     input.add(Arrays.asList(2,2));
//     input.add(Arrays.asList(3,2));
//     input.add(Arrays.asList(1,1));
//     input.add(Arrays.asList(1,1));
//     input.add(Arrays.asList(2,1));
//     input.add(Arrays.asList(3,2));


     input.add(Arrays.asList(1,5));
     input.add(Arrays.asList(1,6));
     input.add(Arrays.asList(3,2));
     input.add(Arrays.asList(1,10));
     input.add(Arrays.asList(1,10));
     input.add(Arrays.asList(1,6));
     input.add(Arrays.asList(2,5));
     input.add(Arrays.asList(3,2));

     freqQuery(input);
     System.out.println("Hello");

 }
}

package leetcode;

import java.util.*;

/**
 * Created by oakinrele on Apr, 2020
 */
public class GroupAnagrams {

     static Map<Character,Integer> stringMap = new HashMap<>();
     static Map<Character,Integer> stringMap2 = new HashMap<>();
     static Set<String> stringSet = new HashSet<>();
     static List<List<String>> groupResult = new ArrayList<>();

    public static List<List<String>> groupAnagrams(String[] strs) {
         List<String> input = new ArrayList<>(Arrays.asList(strs));

         for(int i = 0; i < input.size() - 1; i++)
         {
             acceptStringAndCreateMap(input.get(i));
             for(int j = i +1; j < input.size(); j++)
             {
                 acceptStringAndCreateSecondMap(input.get(j));
                 validateAnagram(input.get(i),input.get(j));
                 stringMap2.clear();
             }
             stringMap.clear();
             groupResult.add(new ArrayList<>(stringSet));
             input.removeAll(stringSet);
             stringSet.clear();
             System.out.println("Got here");
         }
         return groupResult;
    }



    public static void validateAnagram(String first, String second)
    {
        if(stringMap2.equals(stringMap))
        {
            stringSet.add(first);
            stringSet.add(second);
        }
    }


    public static void acceptStringAndCreateMap(String input)
    {
        for(int i = 0; i < input.length(); i++)
        {
            if(!stringMap.containsKey(input.charAt(i)))
            {
                stringMap.put(input.charAt(i),1);
            }

            else
            {
                stringMap.put(input.charAt(i),stringMap.get(input.charAt(i)) + 1);
            }
        }
    }


    public static void acceptStringAndCreateSecondMap(String input)
    {
        for(int i = 0; i < input.length(); i++)
        {
            if(!stringMap2.containsKey(input.charAt(i)))
            {
                stringMap2.put(input.charAt(i),1);
            }

            else
            {
                stringMap2.put(input.charAt(i),stringMap2.get(input.charAt(i)) + 1);
            }
        }
    }


    public static void main(String[]args)
    {
        String [] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        groupAnagrams(input);


    }

}

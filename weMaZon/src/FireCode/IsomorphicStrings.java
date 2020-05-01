package FireCode;

import java.util.*;

/**
 * Created by oakinrele on Feb, 2020
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String input1, String input2) {
        Map<Character,Integer> hashMap1 = new LinkedHashMap<>();
        Map<Character,Integer> hashMap2 = new LinkedHashMap<>();

        for(int i = 0; i < input1.length(); i++)
        {
            int occurence = 1;
            if(!hashMap1.containsKey(input1.charAt(i)))
            {
                hashMap1.put(input1.charAt(i),occurence);
            }

            else
            {
                hashMap1.put(input1.charAt(i),hashMap1.get(input1.charAt(i)) + 1);
            }
        }

        for(int i = 0; i < input2.length(); i++)
        {
            int occurence = 1;
            if(!hashMap2.containsKey(input2.charAt(i)))
            {
                hashMap2.put(input2.charAt(i),occurence);
            }

            else
            {
                hashMap2.put(input2.charAt(i),hashMap2.get(input2.charAt(i)) + 1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Character,Integer> entry : hashMap1.entrySet())
        {
            set.add(entry.getValue());
        }

        Set<Integer> set2 = new HashSet<>();
        for(Map.Entry<Character,Integer> entry : hashMap2.entrySet())
        {
            set2.add(entry.getValue());
        }


        return hashMap1.values().equals(hashMap2.values());

        //return set.equals(set2);



    }


    public static boolean isIsomorphicFire(String input1, String input2) {


        if (input1.length() != input2.length()) return false;
        Map<Character, Character> freq1 = new HashMap<>();
        Map<Character, Character> freq2 = new HashMap<>();
        for (int i=0; i<input1.length(); i++) {
            char c1 = input1.charAt(i);
            char c2 = input2.charAt(i);
            if (!freq1.containsKey(c1)) freq1.put(c1, c2);
            if (!freq2.containsKey(c2)) freq2.put(c2, c1);
            if (freq1.get(c1) != c2 || freq2.get(c2) != c1) return false;
        }
        return true;
    }


    public static void main(String [] args)
    {
        System.out.println(isIsomorphic("css","dll"));
        System.out.println(isIsomorphic("css","dle"));
        System.out.println(isIsomorphic("abcabc","xyzxyz"));
        System.out.println(isIsomorphic("abcabc","xbexyz"));


    }
}

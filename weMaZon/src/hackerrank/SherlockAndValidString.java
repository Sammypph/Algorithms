package hackerrank;

import java.util.*;

/**
 * Created by oakinrele on Apr, 2020
 */
public class SherlockAndValidString
{
    // Complete the isValid function below.
    static String isValid(String s) {
        if(s == null)
        {
            return "NO";
        }

        if(s.length() > 0 && s.length() <= 2)
        {
            return "YES";
        }
        //Create a map of Strings and occurrence
        Map<Character,Integer> charFreq = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            if(!charFreq.containsKey(s.charAt(i)))
            {
                charFreq.put(s.charAt(i),1);
            }

            else{
                charFreq.put(s.charAt(i), charFreq.get(s.charAt(i)) + 1);
            }
        }


        Object[] intVal = charFreq.values().toArray();

        Arrays.sort(intVal);

        int min = (int)intVal[0];
        int max = (int) intVal[intVal.length - 1];

        if(min == max) { return "YES"; }

        else if(((max - min == 1) && (max > (Integer)intVal[intVal.length - 2]))
                || (min == 1) && ((Integer)intVal[1] == max))
                        { return "YES"; }

                            return "NO";

    }


    static String isValidSolution2(String s) {
        Map<Character, Integer> mapCharCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!mapCharCount.containsKey(s.charAt(i))) {
                mapCharCount.put(s.charAt(i), 0);
            }
            mapCharCount.put(s.charAt(i), mapCharCount.get(s.charAt(i)) + 1);
        }


        Map<Integer, Integer> mapCountChar = new HashMap<>();
        Integer frequency1 = 0;
        Integer frequency2 = 0;
        for (Character key : mapCharCount.keySet()) {
            if (!mapCountChar.containsKey(mapCharCount.get(key))) {
                frequency1 = frequency2;
                frequency2 = mapCharCount.get(key);
                mapCountChar.put(mapCharCount.get(key), 0);
            }
            mapCountChar.put(mapCharCount.get(key), mapCountChar.get(mapCharCount.get(key)) + 1);
        }
        if ((mapCountChar.size() == 1)) {
            return "YES";
        }
        if (mapCountChar.size() == 2) {

            int greater = frequency1 > frequency2 ? frequency1 : frequency2;
            int smallest = frequency1 < frequency2 ? frequency1 : frequency2;
            if (mapCountChar.get(greater) == 1 && greater - smallest != 1) {
                return "NO";
            }
            if (mapCountChar.get(greater) == 1 && mapCountChar.get(smallest) >= 1) {
                return "YES";
            }
            if (smallest == 1 && mapCountChar.get(smallest) == 1) {
                return "YES";
            }
        }
        return "NO";

    }

    static String isValidSolution3(String s) {
        Map<Integer,Integer> valChar = new HashMap<>();
        int[] allCharsCount = new int[256];
        for(Character c : s.toCharArray()){
            allCharsCount[c]++;
        }
        for(Integer i : allCharsCount){
            if(i>0){
                valChar.put(i, valChar.getOrDefault(i, 0) + 1);

            }
        }
        if(valChar.size() > 2) return "NO";
        if(valChar.size() <= 1) return "YES";

        for (Map.Entry<Integer,Integer> entry:valChar.entrySet()) {
                if(entry.getValue()==1) {
                 //List<Integer> entries = new ArrayList<>(valChar.keySet());
                if(Collections.max(valChar.keySet())-Collections.min(valChar.keySet())<=1||entry.getKey()==1) {
                    return "YES";
                }
            }
        }
        return "NO";

    }




    public static void main (String [] args)
    {
        System.out.println(isValid("aabbccddeefghi"));
    }
}

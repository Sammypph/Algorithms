package HackerRank;

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

        if(min == max) {
            return "YES";
        }

        else if(((max - min == 1) && (max > (Integer)intVal[intVal.length - 2])) || (min == 1) && ((Integer)intVal[1] == max)) {
                return "YES";
            }

            return "NO";

    }




    public static void main (String [] args)
    {
        System.out.println(isValid("abcdefghhgfedecba"));
    }
}

package FireCode;

import com.sun.tools.javac.util.StringUtils;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by oakinrele on Jan, 2020
 */
public class Permutation {

    public static boolean permutation(String str1, String str2)
    {
        String str1ToUpper = str1.toUpperCase();
        String str2ToUpper = str2.toUpperCase();

        if(str1.length() != str2.length())
        {
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for(char c : str1ToUpper.toCharArray())
        {
            int counter= 0;
          if(!hm.containsKey(c))
           {
                   hm.putIfAbsent(c,(counter + 1));
           }

           else
           {
               hm.put(c,(hm.get(c) + 1));
           }
        }

        for(char c2 : str2ToUpper.toCharArray())
        {
            int counter = 0;
            if(!hm2.containsKey(c2))
            {
                hm2.putIfAbsent(c2,(counter + 1));
            }

            else
            {
                hm2.put(c2,(hm2.get(c2) + 1));
            }
        }


        System.out.println(hm.equals(hm2));

        return hm.equals(hm2);
    }


    public static void main(String [] args)
    {
       // permutation("MADAM","Damma");



    }
}

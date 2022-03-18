package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by oakinrele on May, 2020
 */
public class FirstUniqueCharacterInAString {
    public static String inputString;
    public static int firstUniqChar(String s) {
        inputString = s;
        Map<Character,Integer> charFreq = new LinkedHashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            if(!charFreq.containsKey(s.charAt(i)))
            {
                charFreq.put(s.charAt(i),1);
            }

            else {
                charFreq.put(s.charAt(i),charFreq.get(s.charAt(i)) + 1);
            }
        }



        for(Map.Entry<Character,Integer> entry : charFreq.entrySet())
        {
            if(entry.getValue() == 1)
            {
                return getPosition(entry.getKey());
            }
        }

        return -1;
    }


    static int getPosition(char input)
    {
        for(int i = 0; i < inputString.length(); i++)
        {
          if(inputString.charAt(i) == input)
          {
              return i;
          }
        }
        return -1;
    }





    public static int firstUniqChar1ms(String s) {
        int res = Integer.MAX_VALUE;

        for(char c = 'a'; c <= 'z'; c++){
            int index = s.indexOf(c);

            if(index != -1 && index == s.lastIndexOf(c))
                res = Math.min(res, index);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public static int firstUniqChar7ms(String s) {

        int[] array=new int[26];

        for (int i=0;i<s.length();i++)
        {
            array[s.charAt(i)-'a']++;
        }

        for (int k=0;k<s.length();k++)
        {
            if(array[s.charAt(k)-'a']==1)
            {
                return k;
            }
        }

        return -1;

    }

    public static void main(String [] args)
    {
        //System.out.println(firstUniqChar("leetcode"));
        //System.out.println(firstUniqChar("loveleetcode"));

        //System.out.println(firstUniqChar1ms("lleettccoodde"));
        System.out.println(firstUniqChar7ms("leetcode"));
    }
}

package firecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oakinrele on Feb, 2020
 */
public class StringCompression {
    public static String compressString(String text) {
        int textLength = text.length();
        Map<Character, Integer> charAndOccurence = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if (text == null) {
            return null;
        }

        for (int i = 0; i < textLength; i++)
        {
            int counter = 1;
            if(!charAndOccurence.containsKey(text.charAt(i)))
            {
                charAndOccurence.putIfAbsent(text.charAt(i),counter);
            }

            else {
                charAndOccurence.put(text.charAt(i),charAndOccurence.get(text.charAt(i)) + 1);
            }
        }

        for(Map.Entry<Character,Integer> entrySet : charAndOccurence.entrySet())
        {
            if(entrySet.getValue() == 1)
            {
                sb.append(entrySet.getKey());
            }
            else {
                sb.append(entrySet.getKey()).append(entrySet.getValue());
            }
        }

        return sb.toString();
    }

    public static String compressStringSecondSolution(String text) {
        int textLength = text.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;


        for(int i = 0; i < textLength; i++)
        {
            count++;
            if(i + 1 >= text.length() || text.charAt(i) != text.charAt(i+1))
            {
               sb.append(text.charAt(i));

               if(count > 1)
               {
                   sb.append(count);
               }

               count = 0;
            }
        }

        return sb.toString();
    }


    public static String compressStringThirdSolution(String text) {
        int textLength = text.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;

  for(int i = 0; i < textLength -1; i++)
  {
      count++;
      if(text.charAt(i) == text.charAt(i+1))
      {
         count = count +1;
      }

      if(text.charAt(i) != text.charAt(i +1))
      {
          if(count > 1) {
              sb.append(text.charAt(i));
              sb.append(count);
          }

          else{
          sb.append(text.charAt(i));
      }

      count = 0;
      }
  }

        return sb.toString();
    }


    public static void main(String [] args)
    {
//        System.out.println(compressString("aaabbbbbcccc"));
//        System.out.println(compressString("aabbbbccc"));
//        System.out.println(compressString("abc"));
//
//        System.out.println(compressStringSecondSolution("aaabbbbbcccc"));
//        System.out.println(compressStringSecondSolution("aabbbbccc"));
//        System.out.println(compressStringSecondSolution("abc"));


        System.out.println(compressStringThirdSolution("aaabbbbbcccc"));
        System.out.println(compressStringThirdSolution("aabbbbccc"));
        System.out.println(compressStringThirdSolution("abc"));
    }
}

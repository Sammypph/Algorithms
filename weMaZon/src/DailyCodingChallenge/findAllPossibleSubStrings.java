package DailyCodingChallenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by oakinrele on Jan, 2020
 */
public class findAllPossibleSubStrings {

    public static String [] generateSubstrings(String input)
    {
          List<String> subStrings = new ArrayList<>();

          char [] inputToCharArray = input.toCharArray();

          StringBuilder sb = new StringBuilder();

        for (char value: inputToCharArray)
        {
            subStrings.add((String.valueOf(value)));
        }

        for(int i = 0; i < input.length() - 1; i++)
        {
            for(int j = i + 1; j< input.length(); j++)
            {
                  //sb.append(String.valueOf(inputToCharArray[i]) + input.substring(j,(input.length())));
                  String substring = "" + inputToCharArray[i] + inputToCharArray[j];
                  subStrings.add(substring);

                  if(input.length() > 3)
                  {

                  }
                  //sb.setLength(0);
                //sb.append(inputToCharArray[i] + inputToCharArray[j]);

            }
        }

        subStrings.add(input);
        return subStrings.toArray(new String[subStrings.size()]);

    }





    public static void main(String [] args)
    {
        generateSubstrings("abcd");
    }
}

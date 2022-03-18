package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by oakinrele on May, 2020
 */
public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        int stones = 0;
        List<Character> uniques = J.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Set<Character> set = new HashSet<>();
        for(char c : S.toCharArray())
        {
            if(uniques.contains(c))
            {
                stones++;
            }
        }
        return stones;
    }

    public static void main(String [] args)
    {
        String J = "aA";
        String S = "aAAbbbb";


        System.out.println(numJewelsInStones(J,S));
    }
}

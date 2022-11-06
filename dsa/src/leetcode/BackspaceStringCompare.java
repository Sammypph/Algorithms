package leetcode;

/**
 * Created by oakinrele on Apr, 2020
 */
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder(S);
        StringBuilder sb2 = new StringBuilder(T);
        return backspaceString(sb1).equals(backspaceString(sb2));
    }


    public static String backspaceString(StringBuilder input)
    {
        int stringLength = input.length();
        for(int i = 0; i < stringLength; i++)
        {
           if(input.charAt(i) == '#' && i-1 >= 0)
           {
               input.deleteCharAt(i);
               input.deleteCharAt(i-1);
               //reset value of counter and length after deletion
               i=0;
               stringLength = input.length();
           }

            else if (i-1 == 0 && input.charAt(i-1) == '#')
            {
                i=0;
                input.deleteCharAt(i);
                stringLength = input.length();
            }
        }
        return new String(input);
    }

    public  static void main(String [] args)
    {
          //String S = "ab#c", T = "ad#c";
         // String S = "a##c", T = "#a#c";
        //String S = "ab##", T = "c#d#";
        //String S = "a##c", T = "#a#c";
        String S = "y#fo##f", T = "y#f#o##f";


        System.out.println(backspaceCompare(S,T));
    }
}


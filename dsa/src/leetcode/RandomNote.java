package leetcode;

/**
 * Created by oakinrele on May, 2020
 */
public class RandomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] ascii = new int[256];

        for(int i = 0; i < magazine.length(); i++)
        {
            ascii[magazine.charAt(i)] += 1;
        }


        for(int i = 0; i < ransomNote.length(); i++)
        {
            ascii[ransomNote.charAt(i)]--;
        }

        for(int value : ascii)
        {
            if(value < 0)
            {
                return false;
            }
        }

        return  true;

    }



    public static void main(String [] args)
    {
        System.out.println(canConstruct("a", "b")); //false
        System.out.println(canConstruct("aa", "ab")); //false
        System.out.println(canConstruct("aa", "aab"));//true
    }
}

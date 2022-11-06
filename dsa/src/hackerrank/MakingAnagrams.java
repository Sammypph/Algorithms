package hackerrank;

/**
 * Created by oakinrele on Mar, 2020
 */
public class MakingAnagrams {
    static int makingAnagrams(String s1, String s2) {

        int[] ints = new int[256];
        int minimumDeletionRequired = 0;

        for (int i = 0; i < s1.length(); i++)
        {
            ints[s1.charAt(i)] += 1;
        }

        for(int i = 0; i < s2.length(); i++)
        {
            ints[s2.charAt(i)] -= 1;
        }


        for(int value : ints)
        {
                minimumDeletionRequired+= Math.abs(value);
        }

        return minimumDeletionRequired;

    }

    public static void main(String [] args)
    {
        String str = "absdjkvuahdakejfnfauhdsaavasdlkj";
        String str2 = "djfladfhiawasdkjvalskufhafablsdkashlahdfa";


        System.out.println(makingAnagrams(str,str2));
    }
}

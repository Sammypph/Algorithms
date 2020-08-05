package leetcode;

/**
 * Created by oakinrele on Aug, 2020
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s != null)
        {

            String modifiedInput = removeSpaceAndSpecialCharacters(s);
            if (modifiedInput.isEmpty()) {
                return true;
            }

            System.out.println("Original string: "+s);
            System.out.println("Modified string: "+modifiedInput);
            System.out.println("Reversed string: " +reverseString(modifiedInput));


            return modifiedInput.equalsIgnoreCase(reverseString(modifiedInput));
        }

        return false;
    }



    public static String removeSpaceAndSpecialCharacters(String input)
    {
        String modifiedString = input.replaceAll("[^a-zA-Z0-9]", "");

        return  modifiedString;
    }



    public static String removeSpaceAndSpecialCharactersWithoutRegex(String input)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i)) || Character.isLetter(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }


    public static String reverseString(String input) {
        char[] inputToCharArray = input.toCharArray();
        int length = input.length() - 1;

        for (int i = 0; i <= (input.length() - 1) / 2; i++) {
            char temp = inputToCharArray[i];
            inputToCharArray[i] = inputToCharArray[length];
            inputToCharArray[length] = temp;
            length--;
        }
        return new String(inputToCharArray);
    }


    public static void main(String[] args) {
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isPalindrome("race a car"));

        //System.out.println(isPalindrome(" "));

        System.out.println(isPalindrome(null));

        //reverseString("Tolani");
        //ijalob
    }
}

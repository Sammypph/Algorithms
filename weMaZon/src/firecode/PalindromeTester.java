package firecode;

/**
 * Created by oakinrele on Mar, 2021
 */
public class PalindromeTester {
    public static boolean isStringPalindrome(String str){
      //Check if string is null or empty
      //Check if length is 1
      //Convert string to lowercase or uppercase
      //Iterate from both ends and keep comparing each character
      //if char a != char b, return false
      // return true

           if(str == null || str.length() == 0 || str.length() == 1)
           { return true; }

            return isPalindrome(str.toLowerCase());
        }

    private static boolean isPalindrome(String input){
        int length = input.length();
        int end = length - 1;
        for(int start = 0; start <= length/2; start++){
            if(input.charAt(start) != input.charAt(end)){
                return false;
            }
            end--;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isStringPalindrome("madam"));
        System.out.println(isStringPalindrome("abba"));
        System.out.println(isStringPalindrome("sanmi"));
        System.out.println(isStringPalindrome("Maam"));
    }
}

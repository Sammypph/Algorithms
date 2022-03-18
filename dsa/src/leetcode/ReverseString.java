package leetcode;

/**
 * Created by oakinrele on Apr, 2021
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int end = s.length - 1;
        for(int i= 0; i <=(s.length -1)/2; i++){
            char temp = s[i];
            s[i] = s[end];
            s[end] = temp;
            end--;
        }
    }
}

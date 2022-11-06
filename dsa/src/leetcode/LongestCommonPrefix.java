package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        //String [] strs = new String[]{"dog","racecar","car"};
        String [] strs = new String[]{"flower","flow","flight"};
        String result = LongestCommonPrefix(strs);
        System.out.println(result);
    }



    private static String LongestCommonPrefix(String [] words){
        //Sort words in array
        //Get min length between first item and lasst item
        //Compare each character and keep adding common characters to a buffer
        //return result
        if(words == null || words.length < 1){
            return "";
        }
        if(words.length == 1){
           return words[0];
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(words);
        String firstWord = words[0];
        String lastWord = words[words.length -1];
        int runningLength = Math.min(firstWord.length(),lastWord.length());

        for(int i = 0; i < runningLength; i++){
            if(firstWord.charAt(i) == lastWord.charAt(i)){
                sb.append(firstWord.charAt(i));
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}

package leetcode;

/**
 * Created by oakinrele on Aug, 2020
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s)
    {
        int result = 0;
        for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++);
        return result;
    }


    public static void main(String [] args)
    {

    }
}

package leetcode;

/**
 * Created by oakinrele on Jan, 2020
 */
public class MaximumSwap {

    public static int maximumSwap(int num)
    {
        char [] numberToChar = String.valueOf(num).toCharArray();
        StringBuilder reversedString = new StringBuilder();

        for(int i = 0; i < numberToChar.length; i++)
        {
            int maxElem = i;

            for(int j=i+1;j<numberToChar.length;j++)
            {
                if(numberToChar[maxElem] <= numberToChar[j]){
                    maxElem = j;
                }
            }

            if(numberToChar[maxElem] > numberToChar[i])
            {
                char tmp = numberToChar[i];
                numberToChar[i] = numberToChar[maxElem];
                numberToChar[maxElem] = tmp;
                break;
            }
        }

        for(char c : numberToChar)
        {
            reversedString.append(c);
        }

           System.out.println(reversedString.toString());
           return Integer.parseInt(reversedString.toString());
    }


    public static void main(String [] args)
    {
      // maximumSwap(1993);


       StringBuilder sb = new StringBuilder();

       char c = 'c';

       sb.append(c == 'c'? c:'b');

        System.out.println(sb.toString());
    }
}

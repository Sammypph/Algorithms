package FireCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by oakinrele on Feb, 2020
 */
public class ComputeBinary {

    public static String computeBinary(int val) {

        StringBuilder sb = new StringBuilder();
        int remainder;

        while(val/2 >= 1)
        {
            remainder = val % 2;
            sb.append(remainder);
            val = val/2;
        }
        remainder = val % 2;
        sb.append(remainder);
        return sb.reverse().toString();
    }


   int x =  Integer.MIN_VALUE;


    public static void main(String [] args)
    {
        System.out.println(computeBinary(5));
    }
}

package FireCode;

import Util.TimeHelper;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by oakinrele on Feb, 2020
 */
public class reverseInteger {
    public static int reverseInt(int x) {
        boolean multiplyByNegative = false;
        if(x < 1)
        {
            x = x * -1;
            multiplyByNegative = true;
        }

        int valueAfterDivision;
        int reversed=0;

        while(x > 0)
        {
            valueAfterDivision = x/10;
            reversed = reversed * 10 + x % 10;
            x = valueAfterDivision;
        }
        return multiplyByNegative ? (reversed * -1) : reversed;
    }


    public static int reverseIntSecondSolution(int x) {
        int rev = 0;
        while(x != 0){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return rev;
    }


    public static void main(String [] args)
    {
//        System.out.println(reverseInt(7901));
//        System.out.println(reverseIntSecondSolution(-7901));

        Long reportDate = 1584082800000L;
        LocalDateTime startTime = TimeHelper.fromMillisToLDT(reportDate);

        String name = "Ade";

        //Map<Character,Character> map = new HashMap<>(Collections.singletonList(name));

        for (char value:name.toCharArray()) {

        }
       // System.out.println(startTime);
        System.out.println(startTime.toLocalDate().toString());
    }
}

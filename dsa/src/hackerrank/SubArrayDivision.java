package hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oakinrele on Oct, 2020
 */
public class SubArrayDivision{
       /*
        s: an array of integers, the numbers on each of the squares of chocolate
        d: an integer, Ron's birth day
        m: an integer, Ron's birth month

       */

        // Complete the birthday function below.
        static int birthday(List<Integer> s, int d, int m) {
            int birthDay = d;
            int birthMonth = m;
            int result = 0;

            int chocolateBar = 1;
            int chocolateBarValue = 0;

            //Base Case
            if(s.size() == 1)
            {
                chocolateBarValue = s.get(0);
                if(chocolateBar == birthMonth && chocolateBarValue == birthDay)
                {
                    result++;
                }

                return result;
            }

          for(int i = 0; i < s.size() - 1 ; i++) {

              if(chocolateBar < birthMonth)
              {
                     chocolateBar++;

              }

              else{chocolateBar = 1;}


              if(chocolateBarValue < birthDay)
              {
                  chocolateBarValue += (s.get(i) + s.get(i + 1));
              }

              else {
                  chocolateBarValue = 0;
              }


              if(chocolateBar == birthMonth && chocolateBarValue == birthDay)
              {
                  result++;
                  chocolateBar = 1;
                  chocolateBarValue = 0;
              }

            }
            return result;
        }



    static int birthdaySolution(List<Integer> s, int d, int m) {
        int birthDay = d;
        int birthMonth = m;
        int answer = 0;

        int chocolateBar = 1;
        int chocolateBarValue = 0;

        //Base Case
        if(s.size() == 1)
        {
            chocolateBarValue = s.get(0);
            if(chocolateBar == birthMonth && chocolateBarValue == birthDay)
            {
                answer++;
            }

            return answer;
        }

        for(int i = 0; i < s.size() - 1 ; i++) {

        }


        return answer;
    }


    public static void main(String[] args) {
              int result;

            List<Integer> testCase1 = new ArrayList<>();
            testCase1.add(1);
            testCase1.add(2);
            testCase1.add(1);
            testCase1.add(3);
            testCase1.add(2);

            result = birthday(testCase1, 3 , 2);

            System.out.println(String.format("First Output: %d ", result));

            List<Integer> testCase2 = new ArrayList<>();
            testCase2.add(1);
            testCase2.add(1);
            testCase2.add(1);
            testCase2.add(1);
            testCase2.add(1);
            testCase2.add(1);

            result= birthday(testCase2, 3 , 2);

            System.out.println(String.format("Second Output: %d ", result));

            List<Integer> testCase3 = new ArrayList<>();
            testCase3.add(4);
            result= birthday(testCase3, 4 , 1);

            System.out.println(String.format("Third Output: %d ", result));


    }
}

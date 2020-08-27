package firecode;

import java.util.*;

/**
 * Created by oakinrele on Feb, 2020
 */
public class CoupleSum {
    public static int[] coupleSum(int[] numbers, int target) {

        List<Integer> ls = new ArrayList<>();
        //Linear Space and Linear Time
        if (numbers.length == 0) {
            return new int[1];
        }

        for(int i = 0; i < numbers.length - 1; i++)
        {
            if(numbers[i] + numbers[i+1] == target)
            {
                ls.add(i+1);
                ls.add(i+2);
            }
        }


        return ls.stream().mapToInt(i->i).toArray();
    }


    public static int[] coupleSumSecondSolution(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (map.containsKey(target - number)) {
                int index = map.get(target - number);
                return new int[] { index + 1, i + 1};
            } else {
                map.put(number, i);
            }
        }
        return null;
    }


    public static int[] coupleSumSolutionThree(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < numbers.length; i++){
            int n = numbers[i];
            if(map.containsKey(n)){
                return new int[]{map.get(n), i+1};
            } else {
                map.put(target-n, i+1);
            }
        }
        return null;
    }



    public static void main(String [] args)
    {
        System.out.println(coupleSum( new int[]{4,3,4,8}, 8));
    }

    }

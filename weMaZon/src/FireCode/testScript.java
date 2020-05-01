package FireCode;

import java.util.*;

/**
 * Created by oakinrele on Feb, 2020
 */
public class testScript {
    public static void main(String[] args) {
        // initialize array with odd number of element
//        List<String> input = new ArrayList<>();
//        input.add("Hi");
//        input.add("Hi");
//        input.add("Hello");
//
//        String x = "";
//        x.isEmpty();
//
//        String y = x;
//
//        Set<String> set = new HashSet<>(input);
//        Set<String> treeSet = new TreeSet<>(input);
//
//
//        List<String> newOutput = new ArrayList<>(set);
//        newOutput.add(null);
//
//        Stack<Integer> integers = new Stack<>();
//
//        Queue<Integer> queue = new PriorityQueue<>();
//
//        int[] values = { 2, 3, 6, 12, 15, 34, 65, 78, 99 };
//        // calculate median
//        double median = median(values);
//        System.out.println("Median is : " + median);
//
//        int x = 1;
//        int y = 1;
//        int z = 1;
//
//
//        Stack<Integer> stack = new Stack<>();
//        int height = 0;
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//
//
//        for(int value : stack)
//        {
//            height = +value;
//        }
//
//
//        List<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//
//        TreeMap<Integer,int[]> treeMap = new TreeMap<>();
//
//        //int height = 0;
//        for(Integer value : list)
//        {
//            int sum =+ value;
//        }
//
//        boolean value = x==y && y==z;
////        // re-initialize array with even number of element
////        values = { 2, 3, 6, 12, 15, 34, 65, 78};
////        // calculate median
////        median = median(values);
////        System.out.println("Median is : " + median);


        System.out.println(median(new int[]{1,2,3,4,5,6}));
    }

    static double median(int[] values) {
        // sort array
        Arrays.sort(values);
        double median;
        // get count of scores
        int totalElements = values.length;
        // check if total number of scores is even
        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = values[totalElements / 2] + values[totalElements / 2 - 1];
            // calculate average of middle elements
            median = ((double) sumOfMiddleElements) / 2;
        } else {
            // get the middle element
            median = (double) values[values.length / 2];
        }
        return median;
    }
}

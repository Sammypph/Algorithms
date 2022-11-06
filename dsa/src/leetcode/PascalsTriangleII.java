package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by oakinrele on Aug, 2020
 */
public class PascalsTriangleII {

    //Solution beats 96.71% of leetCode submission as regards Memory.
    public static List<Integer> getRow(int rowIndex) {
        return generateTriangle(rowIndex + 1);
    }

    public static List<Integer> generateTriangle(int numRows)
    {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) { return new ArrayList<>();}

        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        for(int i = 1; i < numRows; i++)
        {  List<Integer> prev_row = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for(int j = 1; j < i ; j++ )
            {
                row.add(prev_row.get(j - 1) + prev_row.get(j));
            }

            row.add(1);

            triangle.add(row);
        }

        return triangle.get(numRows - 1);
    }


  //This solution Uses more memory but it works

//    public static List<Integer> getRow(int rowIndex) {
//        List<List<Integer>> triangle = pascalsTriangle(rowIndex + 1);
//        return triangle.get(rowIndex);
//    }
//
//    public static List<List<Integer>> pascalsTriangle(int numRows)
//    {
//        List<List<Integer>> triangle = new ArrayList<>();
//        if(numRows == 0) { return triangle;}
//
//        List<Integer> first_row = new ArrayList<>();
//        first_row.add(1);
//        triangle.add(first_row);
//
//        for(int i = 1; i < numRows; i++)
//        {  List<Integer> prev_row = triangle.get(i - 1);
//           List<Integer> row = new ArrayList<>();
//           row.add(1);
//
//           for(int j = 1; j < i ; j++ )
//           {
//               row.add(prev_row.get(j - 1) + prev_row.get(j));
//           }
//
//           row.add(1);
//
//           triangle.add(row);
//        }
//
//
//        return triangle;
//    }


    public static void main(String[] args) {
        System.out.println(getRow(3));
    }



}

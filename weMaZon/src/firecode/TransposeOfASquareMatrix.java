package firecode;

import java.util.Arrays;

/**
 * Created by oakinrele on Feb, 2020
 */
public class TransposeOfASquareMatrix {
    public static void transposeMatrix(int[][] matrix)
    {
       //This simply swapping the columns with the rows
        // m X n becomes n X m

        int newRow = matrix.length;
        int newColumn = matrix[0].length;

        //Create a new 2D Array
        int[][] transpose = new int[newColumn][newRow];

        for(int c = 0; c < matrix[0].length ; c++)
        {
            for(int r = 0; r < matrix.length; r++ )
            {
                int column = r;
                int row = c;

                int temp = matrix[r][c];
                transpose[row][column] = temp;
            }
        }

        matrix = Arrays.copyOf(transpose,newRow);

        System.out.println("Hello Sir");
    }


    public static void main(String [] args)
    {
       /// int [][] twoDimentional = {{1,0},{1,0},{1,0}};
        int [][] twoDimentional = {{1,0,1},{1,0,1},{1,0,1}};
        transposeMatrix(twoDimentional);

        for (int[] arr:twoDimentional
             ) {
            System.out.println(Arrays.toString(arr));

        }
    }
}

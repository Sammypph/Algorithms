package firecode;

import java.util.Arrays;

/**
 * Created by oakinrele on Feb, 2020
 */
public class TransposeOfASquareMatrix {
    @Deprecated
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

        //matrix = transpose;

        System.out.println(Arrays.deepToString(matrix));

        System.out.println("Hello Sir");
    }

    //Cleaner solution using for loops
    public static void transposeUsingForLoops(int[][] matrix){
        for(int r = 0; r < matrix.length; r++){
            for(int c = r; c < matrix[0].length; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    //Cleaner solution using while loops
    public static void transposeUsingWhileLoop(int[][] matrix) {
        int size = matrix.length; // 3
        int row = 0; // 3
        int col = 0; // 3
        while (row < size && col < size) {
            int temp = matrix[row][col];
            matrix[row][col] = matrix[col][row];
            matrix[col][row] = temp;

            if (col == size - 1) {
                row++;
                col = row;
            } else {
                col++;
            }
        }
    }



    public static void main(String [] args)
    {
       /// int [][] twoDimentional = {{1,0},{1,0},{1,0}};
        int [][] twoDimentional = {{1,0,1},{1,0,1},{1,0,1}};
        int [][] twoDimentional1 = {{1,0,1},{1,0,1},{1,0,1}};
        int [][] twoDimentional2 = {{1,0,1},{1,0,1},{1,0,1}};
        transposeMatrix(twoDimentional);
        transposeUsingForLoops(twoDimentional1);
        transposeUsingWhileLoop(twoDimentional2);

        for (int[] arr:twoDimentional) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(Arrays.deepToString(twoDimentional));
        System.out.println(Arrays.deepToString(twoDimentional1));
        System.out.println(Arrays.deepToString(twoDimentional2));
    }
}

package firecode;

import java.util.Arrays;

/**
 * Created by oakinrele on Mar, 2021
 */
public class flipHorizontal {

    public static void flipHorizontalAxis(int[][] matrix) {
     int row = matrix.length - 1;
     int column = matrix[0].length - 1;

     flipIt(matrix,row);
    }


    private static void flipIt(int[][] matrix, int row){
        for(int i = 0; i <= row/2; i++){
            int [] temp = matrix[i];
            matrix[i] = matrix[row];
            matrix[row] = temp;
            row--;
        }
    }


    public static void main(String[] args) {
        int [][] matrix = new int[2][];

        matrix[0] = new int[]{1,1};
        matrix[1] = new int[]{0,0};
        flipHorizontalAxis(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /*
     Go through the array
     Flip each row till you get to the middle
     Stop
     return flipped row
    */
}

package firecode;

/**
 * Created by oakinrele on Mar, 2021
 */
public class RotateSquareImageClockwise {
    public static void rotateSquareImageCCW(int[][] matrix) {
        //Transpose the matrix first
        transpose(matrix);

        //Then do an horizontal flip
        horizontalFlip(matrix);
    }


    private static void horizontalFlip(int[][] matrix){
            int column = matrix[0].length;
            int row = matrix.length-1;

            for(int r = 0; r <= row/2; r++)
            {
                for(int c = 0; c < column; c++)
                {
                    int temp = matrix[r][c];
                    matrix[r][c] = matrix[row - r][c];
                    matrix[row - r][c] = temp;
                }
            }
    }

    private static void transpose(int[][] matrix){
        for(int r = 0; r < matrix.length; r++){
            for(int c = r; c < matrix[0].length; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }
}

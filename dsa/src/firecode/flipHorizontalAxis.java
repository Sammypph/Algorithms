package firecode;

/**
 * Created by oakinrele on Jan, 2020
 */
public class flipHorizontalAxis {

    public static void flipIt(int [][] matrix) {
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
}

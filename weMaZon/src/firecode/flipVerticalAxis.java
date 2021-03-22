package firecode;

/**
 * Created by oakinrele on Feb, 2020
 */
public class flipVerticalAxis {
    public static void flipItVerticalAxis(int[][] matrix) {
        for (int [] row: matrix)
            reverseRow(row);
    }

    public static void reverseRow (int [] row) {
        int l = 0, r = row.length - 1;
        while (l < r) {
            int temp = row[l];
            row[l] = row[r];
            row[r] = temp;
            l++;
            r--;
        }
    }


    public static void flipItVerticalAxis2(int[][] matrix) {
        flipIt(matrix);
    }

    private static void flipIt(int[][] matrix) {
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;

        for(int r = 0; r <= row; r++ ){
            //Reset column
            int col = column;
            for(int c = 0; c <= col/2; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][col];
                matrix[r][col] = temp;
                col--;
            }
        }
    }


    public static void main(String [] args){
        int [][] twoDimentional = {{1,0,1},{1,0,1},{1,0,1}};
        flipItVerticalAxis(twoDimentional);

        String x = "Sanmi";
    }
}

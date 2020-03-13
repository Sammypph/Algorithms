package FireCode;

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


    public static void main(String [] args){
        int [][] twoDimentional = {{1,0,1},{1,0,1},{1,0,1}};
        flipItVerticalAxis(twoDimentional);

        String x = "Sanmki";
    }
}

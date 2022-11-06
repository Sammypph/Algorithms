package firecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by oakinrele on Jul, 2020
 */
public class PrintPaths {
    static StringBuilder paths;

    public static ArrayList<String> printPaths(char[][] board){
    int row = board.length;
    int column = board[0].length;
    int lastColumn = column - 1;


    // 0 0
    // 1 1

   // A X
   // D E

    List<String> validPaths = new ArrayList<>();

    Queue<int [][]> boardQueue = new LinkedList<>();

    for(int i = 0; i < row; i++)
    {
        paths = new StringBuilder();

        for(int j = 0; j < column; j++)
        {
            paths.append(board[i][j]);
        }

        for(int k = lastColumn; k > 0; k--)
        {
            paths.append(board[lastColumn][k]);
        }

        validPaths.add(paths.toString());
        lastColumn--;

    }

        return new ArrayList<>();

    }


    //TODO - Add recursive solution.

    public static void getRowPath()
    {}



    public static void main(String [] args)
    {
      char [][] board = new char[2][2];
      board[0][0] = 'A';
      board[0][1] = 'X';
      board[1][0] = 'D';
      board[1][1] = 'E';

      printPaths(board);
    }
}

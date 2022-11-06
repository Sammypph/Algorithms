package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by oakinrele on Aug, 2020
 */
public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
       //First thing is to get the initial state of the board
        //Using HashSet for fast access

        int m = grid.length;
        int n = grid[0].length;
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();

        //Iterate through the given grid and put all rotten oranges in the queue
         for(int i = 0; i < m; i++)
         {
             for(int j = 0; j < n; j++)
             {
                 if(grid[i][j] == 2) {
                       rotten.add("" + i + j);
                  }

                  else if(grid[i][j] == 1) {
                     fresh.add("" + i + j);
                 }
             }
         }

         int minutes = 0;
         //For every rotten orange we find we try to infect fresh oranges in this direction
         int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

         while(fresh.size() > 0)
         {
            Set<String> infected = new HashSet<>();
             for (String s: rotten) {
                 int i = s.charAt(0) - '0';
                 int j = s.charAt(1) - '0';

                 for(int [] direction : directions)
                 {
                     int nextI = i + direction[0];
                     int nextJ = j + direction[1];
                     if(fresh.contains("" + nextI + nextJ))
                     {
                         fresh.remove("" + nextI + nextJ);
                         infected.add("" + nextI + nextJ);
                     }
                 }
             }

             if(infected.size() == 0)
             {return -1;}

             rotten = infected;
             minutes++;
         }

         return minutes;
    }


    public static int orangesRotting2(int[][] grid) {
        Queue<Orange> queue = new LinkedList<>();
        int freshOranges = 0, minutes = 0;

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] == 1)
                {
                    freshOranges++;
                }

                if (grid[i][j] == 2)
                {
                    queue.offer(new Orange(i, j));
                }
            }
        }

        if (freshOranges == 0)
        {
            return 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size ; i++)
            {
              Orange currentOrange = queue.poll();

              if(currentOrange.x < grid.length - 1 && grid[currentOrange.x + 1][currentOrange.y] == 1)
              {
                  //reduce fresh oranges count
                 freshOranges--;
                 //Infect the fresh orange in adjacent cells
                  grid[currentOrange.x + 1][currentOrange.y] = 2;
                  //add infected cell to the queue
                  queue.offer(new Orange(currentOrange.x + 1, currentOrange.y));
              }


                if (currentOrange.x > 0 && grid[currentOrange.x - 1][currentOrange.y] == 1)
                {
                    freshOranges--;
                    grid[currentOrange.x - 1][currentOrange.y] = 2;
                    queue.offer(new Orange(currentOrange.x - 1, currentOrange.y));
                }

                if (currentOrange.y + 1 <= grid[0].length - 1 && grid[currentOrange.x][currentOrange.y + 1] == 1)
                {
                    freshOranges--;
                    grid[currentOrange.x][currentOrange.y + 1] = 2;
                    queue.offer(new Orange(currentOrange.x, currentOrange.y + 1));
                }

                if (currentOrange.y > 0 && grid[currentOrange.x][currentOrange.y - 1] == 1)
                {
                    freshOranges--;
                    grid[currentOrange.x][currentOrange.y - 1] = 2;
                    queue.offer(new Orange(currentOrange.x, currentOrange.y - 1));
                }

            }

            minutes++;
        }

        if(freshOranges != 0) { return -1; }

        return minutes -1;
        }


    public static class Orange
    {
        public int x;
        public int y;
        public Orange(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][];
        grid[0] =  new int[]{2,1,1};
        grid[1] =  new int[]{0,1,1};
        grid[2] =  new int[]{1,0,1};

        System.out.println(orangesRotting2(grid));

    }
}


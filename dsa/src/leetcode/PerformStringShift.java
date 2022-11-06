package leetcode;

/**
 * Created by oakinrele on Apr, 2020
 */
public class PerformStringShift {

    static StringBuilder sb;
    public static String stringShift(String s, int[][] shift) {
        sb = new StringBuilder(s);
        for (int [] arr: shift) {

                if(arr[0] == 0)
                {
                   //Left Shift
                    performLeftShift(arr[1]);
                }

                if(arr[0] == 1)
                {
                    //Right Shift
                    performRightShift(arr[1]);
                }
            }
        return new String(sb);

    }



    public static void performLeftShift(int amountOfShifts)
    {
        for(int i = 0; i < amountOfShifts; i++)
        {
            char firstCharacter = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(firstCharacter);
        }
    }

    public static void performRightShift(int amountOfShifts)
    {
        for(int i = 0; i < amountOfShifts; i++)
        {
            int stringLength = sb.length();
            char lastCharacter = sb.charAt(stringLength - 1);
            sb.deleteCharAt(stringLength - 1);
            sb.insert(0,lastCharacter);
        }
    }



    public static void main(String [] args)
    {
        int [][] shifts = {{0,1},
                           {1,2}
                          };

        System.out.println(stringShift("abc",shifts));
    }
}

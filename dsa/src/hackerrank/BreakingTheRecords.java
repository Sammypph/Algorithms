package hackerrank;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by oakinrele on Oct, 2020
 */
public class BreakingTheRecords {
    private static final Scanner scanner = new Scanner(System.in);

    static int[] breakingRecords(int[] scores) {

        int [] brokenRecords = new int[2];

        int leastRecord = scores[0];
        int highestRecord = scores[0];

        for(int i = 0; i < scores.length; i++)
        {
            if(i < scores.length - 1 &&  scores[i+1] > highestRecord)
            {
                highestRecord = scores[i+1];
                brokenRecords[0]++;
            }

            if(i < scores.length - 1 &&  scores[i+1] < leastRecord)
            {
                leastRecord = scores[i+1];
                brokenRecords[1]++;
            }

        }

        return brokenRecords;

    }

    public static void main(String[] args) throws IOException {

        //region
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] scores = new int[n];
//
//        String[] scoresItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int scoresItem = Integer.parseInt(scoresItems[i]);
//            scores[i] = scoresItem;
//        }
//
//        int[] result = breakingRecords(scores);
//
//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();

        //endregion

        int [] testCase1 = new int[]{10,5,20,20,4,5,2,25,1};
        int [] testCase2 = new int[]{3,4,21,36,10,28,35,5,24,42};

        int [] result = breakingRecords(testCase1);
        System.out.println(String.format("Least: %d   Highest:  %d",result[0], result[1]));

        result = breakingRecords(testCase2);
        System.out.println(String.format("Least: %d    Highest:  %d",result[0], result[1]));


    }
}

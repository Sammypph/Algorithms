package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by oakinrele on Aug, 2020
 */
public class StringCompression {

    public static void compress(String s){
        String input = s.toLowerCase();
        //Result
        StringBuilder result = new StringBuilder();
        int length = input.length() - 1;
        int occurrence = 1;

        if(input != null && input.length() > 1) {
            for (int i = 0; i < length ; i++) {

                if(i < input.length() && input.charAt(i) != input.charAt(i+1)) {
                    result.append(input.charAt(i));
                    if(occurrence> 1)
                        result.append(occurrence);
                    //Set occurrence back to default
                    occurrence = 1;
                }

                else {
                    occurrence++;
                }

                if(i == (length - 1)){
                    result.append(input.charAt(i+1));
                    if(occurrence> 1)
                        result.append(occurrence);
                }

            }
        }

        else
        {
            System.out.println(input);
        }

        if(result.length() > 0)
        System.out.println(result.toString());
    }



    public static void compressString(String source) {
        StringBuffer result = new StringBuffer();

        if(source != null && source.length() > 1)
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while(i < source.length() - 1 && source.charAt(i) == source.charAt(i+1))
            {
                runLength++;
                i++;
            }
            result.append(source.charAt(i));

            if(runLength > 1)
            result.append(runLength);
        }

        else
            System.out.println(source);


        if(result.length() > 0)
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<String> allStrings = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int inputCount = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < inputCount; i++)
        {
            String value = scanner.nextLine();
            allStrings.add(value);
        }

//


        for(String s : allStrings)
        {
            compressString(s);
        }

    }

}

package MSFT;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oakinrele on Aug, 2020
 */
public class StringCompressionAndDecompression {

    //Compression
    //AAABBBCCC
    // Count and compress
    // a3b3c3

    //AAABBACC
    //A3B2A1C2

    public static String compress(String s) {
        String input = s.toLowerCase();
        //Result
        StringBuilder result = new StringBuilder();
        int length = input.length() - 1;
        int occurrence = 1;

        if (input != null && input.length() > 1) {

            for (int i = 0; i < length; i++) {

                if (i == (length - 1) || (input.charAt(i) != input.charAt(i + 1))) {
                    result.append(input.charAt(i));
                    if (occurrence > 1)
                        result.append(occurrence);
                    //Set occurrence back to default
                    occurrence = 1;
                } else {
                    occurrence++;
                }

                //When there's no repititive occurrence, add the current character and it's occurrence
//                if(i == (length - 1)){
//                    result.append(input.charAt(i+1));
//                    if(occurrence> 1)
//                    result.append(occurrence);
//                }

            }
        } else {
            return input;
        }

        return result.toString();

    }

    //A100
    //B200

    //a9b6
    //a100b200

    //decode(char currChar, int len, String curr, String res)
    // decode(A, 100, B200, "")

    //A1000B2000

//    static StringBuilder sb = new StringBuilder();
//
//    public static String decompress(String input)
//    {
//
//        for(int i = 0; i < input.length(); i = i+2)
//        {
//            String characterToString = Character.toString(input.charAt(i + 1));
//            decompressHelper(input.charAt(i), Integer.parseInt(characterToString));
//        }
//        return sb.toString();
//
//    }
//
//
//    public static void decompressHelper(char c , int occurence)
//    {
//        for(int i = 0; i < occurence ; i++)
//        {
//            sb.append(c);
//        }
//    }

    public static String decode(String compressedStr) {
        //a300b3c4
        String result = "";
        for (int i = 0; i < compressedStr.length(); i++) {
            char c = compressedStr.charAt(i); //Valid letter
            String repeat = "";
            while (i + 1 < compressedStr.length() && Character.isDigit(compressedStr.charAt(i + 1))) {
                repeat += compressedStr.charAt(i + 1);
                i = i + 1;
            }

            int len = repeat.isEmpty() ? 1 : Integer.parseInt(repeat);
            while (len-- > 0) {
                result += c;
            }
        }

        return result;
    }


    public static String encode(String source) {
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while (i < source.length() - 1 && source.charAt(i) == source.charAt(i + 1)) {
                runLength++;
                i++;
            }

            dest.append(source.charAt(i));
            dest.append(runLength);
        }
        return dest.toString();
    }

    public static void main(String[] args) {
        //AAABBBCCC    expected a3b3c3
        //AAABBBCCCDD
        // System.out.println(compress("AAAFBBBCCCDDDFKLLMMPLPPP"));
        //System.out.println(compress("a"));
        //System.out.println(encode("AABBBCCCC"));

        System.out.println(compress("AABBBCCCC"));


        //a31b3d11cd

        //a
        //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbdddddddddddcd
        //System.out.println(compress("AAABBBCCCDDDDFFF"));


        ///AAABBBCCC
        //AAADBBBCCCA
        //System.out.println(decode("A12D1B3C3A1"));
    }
}

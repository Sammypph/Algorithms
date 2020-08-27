package leetcode;

/**
 * Created by oakinrele on May, 2020
 */
public class NumberComplement {
    static StringBuilder sb = new StringBuilder();
    static StringBuilder complement = new StringBuilder();
    static int remainder;

    public static int findComplement(int num) {

        String binary = convertInteger(num);
        String binaryComplement = getComplement(binary);
        int binaryToDecimal = convertBinaryToDecimal(binaryComplement);
        return binaryToDecimal;
    }

    public static String convertInteger(int value)
    {
        sb = new StringBuilder();
        complement = new StringBuilder();
        remainder = 0;

        while(value/2 >= 1)
        {
            remainder = value % 2;
            sb.append(remainder);
            value = value/2;
        }
        remainder = value % 2;
        sb.append(remainder);

        return new String(sb.reverse());
    }

    public static String getComplement(String value)
    {
        for (char charac : value.toCharArray()) {
            if (charac == '1') {
                complement.append('0');
            } else {
                complement.append('1');
            }
        }
        return new String(complement);
    }


    public static int convertBinaryToDecimal(String binary)
    {
        return Integer.parseInt(binary,2);
    }


    public static void main(String [] args)
    {
      findComplement(1);
    }
}

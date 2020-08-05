package linkedinlearning.Recursion;

/**
 * Created by oakinrele on Jul, 2020
 */
public class DecimalToBinary {

    public static void main(String [] args)
    {printBinary(2);
    }



    public static void printBinary(int value)
    {
        if(value > 0)
        {
            printBinary(value/2);
            System.out.printf("%d",value%2);
            //System.out.print(value%2);
        }
    }
}

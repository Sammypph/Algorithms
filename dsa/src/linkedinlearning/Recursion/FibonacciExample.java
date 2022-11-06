package linkedinlearning.Recursion;

/**
 * Created by oakinrele on Jul, 2020
 */
//Fibonacci series similar to nature (Pattern of a sunflower or shell)
// PrintsOut first 10 items of the fibonacci series
public class FibonacciExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }


    public static int fibonacci(int num)
    {
        int result = 0;
        if(num == 1 || num == 2)
        {
            return 1;
        }
        return fibonacci(num - 1 ) + fibonacci(num - 2);
    }





}

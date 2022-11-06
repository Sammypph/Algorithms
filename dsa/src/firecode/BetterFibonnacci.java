package firecode;

/**
 * Created by oakinrele on Jul, 2020
 */
public class BetterFibonnacci {
    public static int betterFibonacci(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}

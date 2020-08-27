package firecode;

/**
 * Created by oakinrele on Jul, 2020
 */
public class PrimeChecker {
    public void checkPrime(int ... inputs)
    {
        for (int input : inputs) {
            if (isPrime(input)) {
                System.out.print(input + " ");
            }
        }
        System.out.println();
    }

    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

package firecode;

/**
 * Created by oakinrele on Mar, 2020
 */
public class Pow {
    public static double pow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(x==0) return x;

        //-2 //3
        if(n<0) {
            x = 1/x;
            n = -n;
        }
        if(n%2 > 0) { //n is odd
            return x*pow(x*x, n/2);
        } else { //n is even
            return pow(x*x, n/2);
        }
    }
}

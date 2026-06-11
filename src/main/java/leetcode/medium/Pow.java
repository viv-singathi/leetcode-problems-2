package leetcode.medium;

public class Pow {
    //problem: Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
    public static void main(String[] args) {
        System.out.println(myPow(2.1, 3)); //output: 9.261
    }

    public static double myPow(double x, int n) {
        return n < 0 ? 1.0/(calcPow(x, Math.abs(n))) : Pow.calcPow(x, Math.abs(n));
    }

    static double calcPow(double x, int n){
        if (n == 0) {return 1;}
        if (n == 1) {return x;}

        double p = calcPow(x, n/2);
        p *= p;

        if ((n & 1) == 1){
            return p * x;
        }

        return p;
    }
}

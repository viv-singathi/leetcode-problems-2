package leetcode.easy;

public class NthTribonacciNumber {

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));

        //output:
        // 4
        // 1389537
    }

    public static int tribonacci(int n) {
        if (n == 0) {return 0;}
        if (n == 1) {return 1;}
        if (n == 2) {return 1;}

        int t1 = 0;
        int t2 = 1;
        int t3 = 1;
        int tn = t1 + t2 + t3;

        for (int i = 3; i <= n; i++){
            tn = t1 + t2 + t3;
            t1 = t2;
            t2 = t3;
            t3 = tn;
        }

        return tn;
    }
}

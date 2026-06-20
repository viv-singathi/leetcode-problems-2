package leetcode.medium;

public class CountKthRootsInRange {
    //problem: You are given three integers l, r, and k.
    //An integer y is said to be a perfect kth power if there exists an integer x such that y = xk.
    //Return the number of integers y in the range [l, r] (inclusive) that are perfect kth powers.
    public static void main(String[] args) {
        System.out.println(countKthRoots(1, 9, 3));//output: 2
    }

    public static int countKthRoots(int l, int r, int k) {
        int lower = kthRoot(l, k);
        int upper = kthRoot(r, k);

        if (pow(upper, k) > r){
            upper--;
        }
        if (lower > upper) {return 0;}

        return upper - lower + 1;
    }

    public static long pow(long x, int n){
        if (n == 1) {return x;}
        if (n % 2 == 1){return x * pow(x, n - 1);}
        long r =  pow(x, n/2);
        return r * r;
    }

    public static int kthRoot(int x, int k){
        int r = 1 + (int) Math.pow(x, 1.0/k);
        return pow(r-1, k) == x ? r-1 : r;
    }
}

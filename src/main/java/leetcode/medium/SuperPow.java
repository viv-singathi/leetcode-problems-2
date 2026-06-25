package leetcode.medium;

public class SuperPow {
    //problem: Your task is to calculate ab mod 1337 where a is a positive integer and b is an
    // extremely large positive integer given in the form of an array.

    public static void main(String[] args) {
        int b[] = {4,3,3,8,5,2};
        System.out.println(superPow(3, b)); //output: 627
    }

    public static int superPow(int a, int[] b) {
        return superPow(a % 1337, b, b.length-1);
    }

    public static int superPow(int a, int[] b, int e) {
        if (e == 0){return fpow(a, b[e]) % 1337;}
        int r = fpow(a, b[e]);
        int m = superPow(a, b, e-1);
        return fpow(m, 10) * r % 1337;
    }


    public static int fpow(int x, int n){
        if (n == 0) { return 1;}

        int r = fpow(x, n/2);
        return n % 2 == 0 ? r * r % 1337 : (x * (r * r % 1337)) %1337;
    }
}

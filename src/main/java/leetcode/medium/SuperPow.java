package leetcode.medium;

public class SuperPow {
    //problem: Your task is to calculate ab mod 1337 where a is a positive integer and b is an
    // extremely large positive integer given in the form of an array.

    public static void main(String[] args) {
        int b[] = {4,3,3,8,5,2};
        System.out.println(superPow(3, b)); //output: 627
    }

    public static int superPow(int a, int[] b) {
        a %= 1337;

        if (gcd(a, 1337) == 1){
            int exp = 0;
            for (int i = 0; i < b.length; i++){
                exp = (exp * 10 + b[i]) % 1140;
            }
            return fpow(a, exp);
        }
        return superPow(a, b, b.length-1);
    }

    public static int gcd(int x, int y){
        if(x == 1){return 1;}
        if (x % y == 0){return y;}
        return gcd(y, x % y);
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

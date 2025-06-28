package leetcode.easy;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        // this is works fine

    }

    public static int reverse(int x) {
        if (x == 0) {return 0;}

        long n = x % 10;
        x = x/10;

        while (x != 0){
            int m = x % 10;
            if (m != 0 || n != 0){
                n *= 10;
                n += m;
            }
            x = x/10;
        }

        if (Math.abs(n) > (1 << 31) - 1){
            return 0;
        }


        return (int) n;
    }
}

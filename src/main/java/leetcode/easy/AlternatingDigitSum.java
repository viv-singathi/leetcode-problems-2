package leetcode.easy;

public class AlternatingDigitSum {
    public static void main(String[] args) {
        System.out.println(alternateDigitSum(521));
        System.out.println(alternateDigitSum(111));

        //output:
        // 4
        // 1
    }

    public static int alternateDigitSum(int n) {
        int s = 0;
        int add = 1;

        while (n > 0){
            s += (n % 10) * add;
            add *= -1;
            n /= 10;
        }

        return s * (-add);
    }
}

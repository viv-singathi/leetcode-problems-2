package leetcode.easy;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(13));

        //output:
        //true
        //false

    }
    public static boolean isPerfectSquare(int num) {
        if (num < 0){ return false; }
        if (num < 2){ return true; }

        long i = 0;
        long j = num;

        while (i < j - 1){
            long m = (i+j)/2;
            long m_squared = m*m;

            if (m_squared == num || i * i == num || j * j == num){
                return true;
            } else if (m_squared > num){
                j = m;
            } else {
                i = m;
            }
        }

        return false;

    }
}

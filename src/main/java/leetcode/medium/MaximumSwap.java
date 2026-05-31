package leetcode.medium;

public class MaximumSwap {
    //problem:
    //You are given an integer num. You can swap two digits at most once to get the maximum valued number.
    //Return the maximum valued number you can get.
    public static void main(String[] args) {
        System.out.println(maximumSwap(2736)); //output: 7236
    }

    public static int maximumSwap(int num) {
        int max = num;
        int digits = 1 + (int) Math.log10(num);
        int div = 1;

        for (int i = 0; i < digits; i++){
            int d = (num / div) % 10;
            int div2 = div;
            for (int j = i+1; j < digits; j++){
                div2 *= 10;
                int d2 = (num / div2) % 10;
                int n = num + (d - d2) * div2 + (d2 - d) * div;
                if (n > max){
                    max = n;
                }

            }
            div *= 10;
        }

        return max;
    }
}

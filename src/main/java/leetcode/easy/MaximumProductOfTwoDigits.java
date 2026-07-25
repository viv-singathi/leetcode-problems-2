package leetcode.easy;

public class MaximumProductOfTwoDigits {
    //problem: You are given a positive integer n.
    //Return the maximum product of any two digits in n
    public static void main(String[] args) {
        System.out.println(maxProduct(124)); //output: 8
    }

    public static int maxProduct(int n) {
        int freq[] = new int[10];
        int d = 0;

        while (n > 0){
            d++;
            freq[n % 10]++;
            n /= 10;
        }

        int i = 9;
        while (freq[i] == 0){
            i--;
        }

        int p = i;
        freq[i]--;

        while (freq[i] == 0){
            i--;
        }

        return p * i;
    }
}

package leetcode.hard;

public class CheckGoodArray {
    //problem:Given an array nums of positive integers. Your task is to select some subset of nums,
    // multiply each element by an integer and add all these numbers.
    // The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.
    //Return True if the array is good otherwise return False

    public static void main(String[] args) {
        int nums[] = {12,5,7,23};
        System.out.println(isGoodArray(nums)); //output: true
    }

    public static boolean isGoodArray(int[] nums) {
        if (nums.length == 1) {return nums[0] == 1;}

        int d = gcd(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++){
            d = gcd(d, nums[i]);

            if (d == 1){
                return true;
            }
        }

        return d == 1;
    }

    public static int gcd(int x, int y){
        if(x == 1){return 1;}
        if (x % y == 0){return y;}
        return gcd(y, x % y);
    }
}

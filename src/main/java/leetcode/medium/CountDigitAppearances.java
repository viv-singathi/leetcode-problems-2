package leetcode.medium;

public class CountDigitAppearances {
    //problem: You are given an integer array nums and an integer digit.
    //Return the total number of times digit appears in the decimal representation of all elements in nums.
    public static void main(String[] args) {
        int arr[] = {12,54,32,22};
        System.out.println(countDigitOccurrences(arr, 2)); //output: 4
    }

    public static int countDigitOccurrences(int[] nums, int digit) {
        int r = 0;

        for (int i = 0; i < nums.length; i++){
            r += nums[i] % 10 == digit ? 1 : 0;
            nums[i] /= 10;

            while (nums[i] > 0){
                if (nums[i] % 10 == digit){
                    r++;
                }
                nums[i] /= 10;
            }
        }

        return r;
    }
}

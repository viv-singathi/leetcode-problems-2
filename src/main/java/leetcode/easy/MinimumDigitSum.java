package leetcode.easy;

public class MinimumDigitSum {
    //problem:
    // You are given an integer array nums.
    //You replace each element in nums with the sum of its digits.
    //Return the minimum element in nums after all replacements.
    public static void main(String[] args) {
        int arr[] = {10,12,13,14};
        System.out.println(minElement(arr)); //output: 1
    }

    public static int minElement(int[] nums) {
        int min = 9999;
        for (int i = 0; i < nums.length; i++){
            int s = 0;
            while (nums[i] != 0){
                s += nums[i] % 10;
                nums[i] /= 10;
            }
            if (s < min){
                min = s;
            }
            nums[i] = s;
        }

        return min;
    }
}

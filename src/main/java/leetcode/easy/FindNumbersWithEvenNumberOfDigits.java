package leetcode.easy;

public class FindNumbersWithEvenNumberOfDigits {
    //problem: Given an array nums of integers, return how many of them contain an even number of digits.
    public static void main(String[] args) {
        int arr[] = {12,345,2,6,7896};
        System.out.println(findNumbers(arr)); //output: 2
    }

    public static int findNumbers(int[] nums) {
        int even = 0;

        for (int i = 0; i < nums.length; i++){
            if ((int) (Math.log10(nums[i])) % 2 == 1){
                even++;
            }
        }

        return even;
    }
}

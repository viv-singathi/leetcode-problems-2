package leetcode.easy;


public class CheckIfArrayIsSortedAndRotated {
    //problem: Given an array nums, return true if the array was originally sorted in non-decreasing order,
    // then rotated some number of positions (including zero). Otherwise, return false.

    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        System.out.println(check(arr)); //output: true

    }

    public static boolean check(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            boolean sorted = true;
            int j;

            for (j = i; j < i + nums.length-1; j++){

                if (nums[j % nums.length] > nums[(j + 1) % nums.length]){
                    sorted = false;
                    break;
                }

            }

            if (sorted){
                return true;
            } else if (j < i) {
                return false;
            }
            i = j;
        }

        return nums.length == 1;
    }
}

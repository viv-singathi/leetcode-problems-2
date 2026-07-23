package leetcode.easy;

public class UniqueMiddleElement {
    //problem: You are given an integer array nums of odd length n.
    //Return true if the middle element of nums appears exactly once in the array. Otherwise return false
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(isMiddleElementUnique(nums)); //output: true
    }

    public static boolean isMiddleElementUnique(int[] nums) {
        int m = nums[nums.length/2];

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == m && i != nums.length/2){
                return false;
            }
        }

        return true;
    }
}

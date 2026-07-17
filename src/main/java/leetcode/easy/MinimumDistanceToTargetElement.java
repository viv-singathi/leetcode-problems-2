package leetcode.easy;

public class MinimumDistanceToTargetElement {
    //problem: Given an integer array nums (0-indexed) and two integers target and start,
    // find an index i such that nums[i] == target and abs(i - start) is minimized.
    // Note that abs(x) is the absolute value of x.
    //Return abs(i - start)
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        System.out.println(getMinDistance(nums, 5, 3)); //output: 1

    }

    public static int getMinDistance(int[] nums, int target, int start) {
        int i = 0;

        while (start - i >= 0 || start + i < nums.length){
            if (start - i >= 0 && nums[start - i] == target){
                break;
            } else if (start + i < nums.length && nums[start + i] == target){
                break;
            }
            i++;
        }

        return i;
    }
}

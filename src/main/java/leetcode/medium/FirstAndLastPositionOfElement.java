package leetcode.medium;

import java.util.Arrays;

public class FirstAndLastPositionOfElement {
    //problem: Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    //If target is not found in the array, return [-1, -1].
    public static void main(String[] args) {
        int arr[] = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 8))); //output: [3, 4]
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            int res[] = {-1, -1};
            return res;
        }

        int l1 = 0;
        int u1 = nums.length-1;
        int s = 0;

        int l2 = 0;
        int u2 = nums.length-1;
        int e = 0;

        while (l1 <= u1){
            s = (l1 + u1)/2;

            if (nums[s] == target && (s-1 < 0 || nums[s-1] != nums[s])){
                break;
            }

            if (nums[s] >= target){
                u1 = s-1;
            } else{
                l1 = s+1;
            }

        }

        if (l1 > u1){
            int res[] = {-1, -1};
            return res;
        }

        while (l2 <= u2){
            e = (l2 + u2)/2;
            if (nums[e] == target && (e+1 >= nums.length || nums[e+1] != nums[e])){
                break;
            }

            if (nums[e] <= target){
                l2 = e+1;
            } else{
                u2 = e-1;
            }

        }

        int res[] = {s, e};

        return res;
    }
}

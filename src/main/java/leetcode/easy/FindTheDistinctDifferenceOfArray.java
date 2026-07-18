package leetcode.easy;

import java.util.Arrays;

public class FindTheDistinctDifferenceOfArray {
    //problem: You are given a 0-indexed array nums of length n.
    //The distinct difference array of nums is an array diff of length n such that diff[i] is equal to the number
    // of distinct elements in the suffix nums[i + 1, ..., n - 1] subtracted from the number of distinct elements
    // in the prefix nums[0, ..., i].
    //
    //Return the distinct difference array of nums
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        System.out.println(Arrays.toString(distinctDifferenceArray(nums)));//output: [-3, -1, 1, 3, 5]
    }

    public static int[] distinctDifferenceArray(int[] nums) {
        int seen[] = new int[50];
        int diff[] = new int[nums.length];
        int unique = 0;

        for (int i = 0; i < nums.length; i++){
            if (seen[nums[i]-1] == 0){
                unique++;
            }
            seen[nums[i]-1]++;

        }

        int currentUnique = 0;
        int currentSeen[] = new int[50];


        for (int i = 0; i < nums.length; i++){
            if (currentSeen[nums[i]-1] == 0){
                currentSeen[nums[i]-1]++;
                currentUnique++;
            }

            seen[nums[i]-1]--;


            if (seen[nums[i]-1] == 0){
                unique--;
            }
            diff[i] = currentUnique - unique;
        }

        return diff;
    }
}

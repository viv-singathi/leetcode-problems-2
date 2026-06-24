package leetcode.easy;

public class SmallestStableIndex {
    //problem:
    //You are given an integer array nums of length n and an integer k.
    //For each index i, define its instability score as max(nums[0..i]) - min(nums[i..n - 1]).
    //An index i is called stable if its instability score is less than or equal to k.
    //Return the smallest stable index. If no such index exists, return -1.
    public static void main(String[] args) {
        int nums[] = {5,0,1,4};
        System.out.println(firstStableIndex(nums, 3)); //output: 3
    }

    public static int firstStableIndex(int[] nums, int k) {
        int mins[] = new int[nums.length];
        mins[nums.length-1] = nums[nums.length-1];

        for (int i = nums.length-2; i>=0; i--){
            mins[i] = Math.min(mins[i+1], nums[i]);
        }

        int m = nums[0];

        for (int i = 0; i < nums.length; i++){
            m = Math.max(nums[i], m);
            if (m - mins[i] <= k){
                return i;
            }
        }

        return -1;
    }


}

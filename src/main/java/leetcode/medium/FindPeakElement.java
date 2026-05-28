package leetcode.medium;

public class FindPeakElement {
    //problem:
    // A peak element is an element that is strictly greater than its neighbors.
    //Given a 0-indexed integer array nums, find a peak element, and return its index.
    //You may imagine that nums[-1] = nums[n] = -∞

    public static void main(String[] args) {
        int nums[] = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums)); //output: 5
    }

    public static int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e){
            int m = (e+s)/2;
            if ((m == 0 || nums[m-1] < nums[m]) && (m+1 == nums.length || nums[m] > nums[m+1])){
                return m;
            }

            if (nums[m] < nums[m+1]){
                s = m + 1;
            } else {
                e = m;
            }
        }

        return 0;
    }
}

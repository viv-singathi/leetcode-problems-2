package leetcode.medium;

public class SingleElementinSortedArray {
    //problem: You are given a sorted array consisting of only integers where every element appears exactly twice,
    // except for one element which appears exactly once.Return the single element that appears only once.
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr));//output: 2
    }
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) { return nums[0]; }

        int i = 0;
        int j = nums.length - 1;

        if (nums[0] != nums[1]){
            return nums[0];
        }
        if (nums[j] != nums[j-1]){
            return nums[j];
        }

        while (i <= j){
            int m = (i+j)/2;

            if (nums[m] != nums[m+1] && nums[m] != nums[m-1]){
                return nums[m];
            }

            int leftIndex = nums[m-1] == nums[m] ? m-2 : m-1;
            int rightIndex = nums[m+1] == nums[m] ? m + 2 : m + 1;

            if ((leftIndex+1) % 2 == 1){
                j = leftIndex;
            } else {
                i = rightIndex;
            }
        }

        return nums[i];
    }
}

package leetcode.easy;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int arr1[] = {-4,-1,0,3,10};
        int arr2[] = {-7,-3,2,3,11};

        System.out.println(Arrays.toString(sortedSquares(arr1)));
        System.out.println(Arrays.toString(sortedSquares(arr2)));

        //output:
        // [0, 1, 9, 16, 100]
        // [4, 9, 9, 49, 121]
    }

    public static int[] sortedSquares(int[] nums) {
        int res[] = new int[nums.length];

        int i = 1;

        while (i < nums.length && nums[i] * nums[i] <= nums[i-1] * nums[i-1]){
            i++;
        }

        int l = i - 2;
        int r = i - 1;
        int len = 0;

        while (l > -1 || r < nums.length){
            if (r >= nums.length || (l > -1 && nums[l] * nums[l] < nums[r] * nums[r])){
                res[len++] = nums[l] * nums[l];
                l--;
            } else {
                res[len++] = nums[r] * nums[r];
                r++;
            }
        }

        return res;
    }
}

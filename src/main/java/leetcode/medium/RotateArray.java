package leetcode.medium;

import java.util.Arrays;

public class RotateArray {
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
        //output: [5, 6, 7, 1, 2, 3, 4]
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == 0) { return; }


        int len = nums.length;
        int tmp[] = new int[len];

        for (int i = 0; i < len; i++){
            tmp[i] = nums[i];
        }

        for (int i = 0; i < len; i++){
            nums[(i + k) % len] = tmp[i];
        }

    }
}

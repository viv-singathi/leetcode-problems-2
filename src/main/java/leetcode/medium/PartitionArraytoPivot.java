package leetcode.medium;

import java.util.Arrays;

public class PartitionArraytoPivot {
    //problem:
    //You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
    //Every element less than pivot appears before every element greater than pivot.
    //Every element equal to pivot appears in between the elements less than and greater than pivot.
    //The relative order of the elements less than pivot and the elements greater than pivot is maintained.
    public static void main(String[] args) {
        int arr[] = {9,12,5,10,14,3,10};
        System.out.println(Arrays.toString(pivotArray(arr, 10))); //output: [9, 5, 3, 10, 10, 12, 14]
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int piv[] = new int[nums.length];
        int l = 0;
        int u = nums.length-1;
        int equal = 0;

        for (int i = 0; i < nums.length;i++){
            if (nums[i] < pivot){
                piv[l++] = nums[i];
            } else if (nums[i] > pivot) {
                piv[u--] = nums[i];
            } else {
                equal++;
            }
        }

        int i = 0;

        for (; i < l; i++){
            nums[i] = piv[i];
        }

        for (; i < l + equal; i++){
            nums[i] = pivot;
        }

        for (; i < nums.length; i++){
            nums[i] = piv[piv.length - 1 + (l + equal) - i];
        }

        return nums;
    }
}

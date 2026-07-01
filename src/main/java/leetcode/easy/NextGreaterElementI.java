package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElementI {
    //problem: The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
    //You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
    //For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
    // If there is no next greater element, then the answer for this query is -1.
    //
    //Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
    public static void main(String[] args) {
        int nums1[] = {4,1,2};
        int nums2[] = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2))); //output: [-1, 3, -1]
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int p = nums2.length-1;
        int res[] = new int[nums1.length];
        HashMap<Integer, Integer> indexes = new HashMap<>();

        for (int k = 0; k < nums1.length; k++){
            indexes.put(nums1[k], k);
        }

        for (int i = nums2.length-1; i >= 0; i--){
            int nextGreater = -1;
            while (p <= nums2.length-1){
                if (nums2[p] > nums2[i]){
                    nextGreater = nums2[p];
                    break;
                }
                p++;
            }

            Integer idx = indexes.get(nums2[i]);
            if (idx != null){
                res[idx] = nextGreater;
            }

            p--;
            nums2[p] = nums2[i];
        }

        return res;
    }
}

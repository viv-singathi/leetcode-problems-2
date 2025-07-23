package leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4};
        int arr2[] = {-1,1,0,-3,3};

        System.out.println(Arrays.toString(productExceptSelf(arr1)));
        System.out.println(Arrays.toString(productExceptSelf(arr2)));

        //output:
        // [24, 12, 8, 6]
        // [0, 0, 9, 0, 0]

    }

    public static int[] productExceptSelf(int[] nums) {
        boolean zero_exists = false;
        int prod = 1;
        int res[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){

                if (zero_exists){
                    return res;
                }

                zero_exists = true;

            } else {
                prod *= nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                res[i] = zero_exists ? 0 : prod / nums[i];
            } else {
                res[i] = prod;
            }
        }

        return res;
    }
}

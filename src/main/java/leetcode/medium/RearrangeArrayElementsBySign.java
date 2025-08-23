package leetcode.medium;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int arr[] = {3,1,-2,-5,2,-4};
        int res[] = rearrangeArray(arr);

        System.out.println(Arrays.toString(res));
        //output: [3, -2, 1, -5, 2, -4]
    }

    public static int[] rearrangeArray(int[] nums) {

        int pos = 0;
        int neg = 1;

        int res[] = new int[nums.length];


        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                res[pos] = nums[i];
                pos += 2;
            } else {
                res[neg] = nums[i];
                neg += 2;
            }
        }

        return res;
    }
}

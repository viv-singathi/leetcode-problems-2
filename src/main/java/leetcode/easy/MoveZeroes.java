package leetcode.easy;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int arr[] = {0,1,0,3,12};

        moveZeroes(arr);

        System.out.println(Arrays.toString(arr));
        //output: [1, 3, 12, 0, 0]
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1){return;}
        int f = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[f++] = nums[i];
            }
        }

        for (f = f; f < nums.length; f++){
            nums[f] = 0;
        }

    }
}

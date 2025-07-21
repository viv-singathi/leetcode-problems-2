package leetcode.medium;

import java.util.Arrays;

public class TwoSumSorted {
    public static void main(String[] args) {

        int arr[] = {2,7,11,15};
        int res[] = twoSum(arr, 9);

        System.out.println(Arrays.toString(res));
        //output: [1, 2]
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        int res[] = new int[2];

        while (i < j){
            int s = numbers[i] + numbers[j];

            if (s == target){
                res[0] = i+1;
                res[1] = j+1;
                return res;
            } else if (s < target){
                i++;
            } else {
                j--;
            }

        }

        return res;
    }
}

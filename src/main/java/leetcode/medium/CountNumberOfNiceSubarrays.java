package leetcode.medium;

public class CountNumberOfNiceSubarrays {
    //problem: Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
    //
    //Return the number of nice sub-arrays
    public static void main(String[] args) {
        int nums[] = {1,1,2,1,1};
        System.out.println(numberOfSubarrays(nums, 3));//output: 2
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int odd = 0;
        int l = 0;
        int u = -1;
        int nice = 0;

        while (true){
            if (odd == k){
                nice += 1;
                int j = 1;

                while (u+j < nums.length && nums[u+j] % 2 == 0){
                    nice++;
                    j++;
                }

                odd -= nums[l++] & 1;

            } else {
                u++;
                if (u >= nums.length){break;}

                odd += nums[u] & 1;
            }
        }

        return nice;

    }
}

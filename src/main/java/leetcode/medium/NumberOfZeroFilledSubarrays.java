package leetcode.medium;

public class NumberOfZeroFilledSubarrays {
    public static void main(String[] args) {
        int arr[] = {1,3,0,0,2,0,0,4};

        System.out.println(zeroFilledSubarray(arr));
        //output: 6
    }

    public static long zeroFilledSubarray(int[] nums) {
        long res = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                int s = i;
                i++;

                while (i < nums.length && nums[i] == 0){
                    i++;
                }

                long len = i-s;

                res += len * (len+1)/2;
            }
        }

        return res;

    }
}

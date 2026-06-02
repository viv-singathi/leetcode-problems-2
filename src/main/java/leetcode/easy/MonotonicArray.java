package leetcode.easy;

public class MonotonicArray {
    //problem:
    //An array is monotonic if it is either monotone increasing or monotone decreasing.
    //An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
    // An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
    public static void main(String[] args) {
        int nums[] = {6,5,4,4};;
        System.out.println(isMonotonic(nums)); //output:true
    }

    public static boolean isMonotonic(int[] nums) {
        int change = 0;

        for (int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i-1];
            if ((diff < 0 && change > 0 )|| (diff > 0 && change < 0)){
                return false;
            }

            if (change == 0){
                change = diff;
            }
        }

        return true;
    }
}

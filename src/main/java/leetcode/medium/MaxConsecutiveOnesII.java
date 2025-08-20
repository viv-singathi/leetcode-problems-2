package leetcode.medium;

public class MaxConsecutiveOnesII {

    public static void main(String[] args) {
        int arr[] = {1,0,1,1,0};

        System.out.println(findMaxConsecutiveOnes(arr));
        //output: 4

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        int i = 0;
        int j = 0;

        boolean flipped  = false;
        int flipped_index = -1;

        while (j < nums.length){
            if (nums[j] == 1){
                j++;
            } else if (nums[j] != 1 && !flipped){
                flipped = true;
                flipped_index = j;
                j++;
            } else if (j <= i){
                j++;
            } else {
                flipped = false;
                i = flipped_index + 1;
            }

            if (j - i > max){
                max = j - i;
            }

        }

        return max;
    }
}

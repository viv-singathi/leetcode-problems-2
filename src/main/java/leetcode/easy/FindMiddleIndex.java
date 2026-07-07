public class FindMiddleIndex {
    //problem: Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible ones).
    //A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].
    //If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1, the right side sum is considered to be 0.
    //Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index
    public static void main(String[] args) {
        int nums[] = {2,3,-1,8,4};
        System.out.println(findMiddleIndex(nums)); //output: 3
    }

    public static int findMiddleIndex(int[] nums) {
        int s = 0;

        for (int i = 0; i < nums.length; i++){
            s += nums[i];
        }

        int s2 = 0;

        for (int i = 0; i < nums.length; i++){

            s -= nums[i];

            if (s == s2){
                return i;
            }

            s2 += nums[i];
        }

        return -1;
    }
}

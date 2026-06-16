package leetcode.easy;

public class SignOfTheProductOfArray {
    //problem: Implement a function signFunc(x) that returns:
    //1 if x is positive.
    //-1 if x is negative.
    //0 if x is equal to 0.
    //You are given an integer array nums. Let product be the product of all values in the array nums.
    // Return signFunc(product).
    public static void main(String[] args) {
        int nums[] = {-1,-2,-3,-4,3,2,1};
        System.out.println(arraySign(nums)); //output: 1
    }

    public static int arraySign(int[] nums) {
        int sgn = 1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                return 0;
            }

            sgn = nums[i] > 0 ? sgn : -sgn;
        }

        return sgn;
    }
}

package leetcode.easy;

public class PivotIndex {

    public static void main(String[] args) {

        int arr[] = {1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));
        //output: 3
    }

    public static int pivotIndex(int[] nums) {

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

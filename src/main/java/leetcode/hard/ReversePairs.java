package leetcode.hard;

public class ReversePairs {
    //problem: Given an integer array nums, return the number of reverse pairs in the array.
    //A reverse pair is a pair (i, j) where:
    //0 <= i < j < nums.length and
    //nums[i] > 2 * nums[j]

    public static void main(String[] args) {
        int arr[] = {2,4,3,5,1};
        System.out.println(reversePairs(arr)); //output: 3
    }

    public static int reversePairs(int[] nums) {
        int sorted[] = new int[nums.length];
        return countReverse(nums, sorted, 0, nums.length);
    }

    public static int countReverse(int nums[], int sorted[], int l, int u){
        if (u - l == 1){
            sorted[l] = nums[l];
            return 0;
        }

        int m = (l+u)/2;

        int reversed = countReverse(nums, sorted, l, m) + countReverse(nums, sorted, m, u);
        int j = (l+u)/2;

        for (int i = l; i < m; i++){
            while (j < u && sorted[i] > ((long) sorted[j] << 1)){
                j++;
            }

            reversed += j - m;
        }

        int p1 = l;
        int p2 = m;

        int p3 = l;

        while (p1 < m || p2 < u){
            if (p2 >= u || p1 < m && sorted[p1] <= sorted[p2]){
                nums[p3++] = sorted[p1++];
            } else {
                nums[p3++] = sorted[p2++];
            }
        }

        for (int i = l; i < u; i++){
            sorted[i] = nums[i];
        }

        return reversed;
    }
}

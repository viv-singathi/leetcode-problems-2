package leetcode.medium;

public class MinimizeProductSumOfTwoArrays {
    //problem: The product sum of two equal-length arrays a and b is equal to the sum of a[i] * b[i] for all 0 <= i < a.length (0-indexed).
    //For example, if a = [1,2,3,4] and b = [5,2,3,1], the product sum would be 1*5 + 2*2 + 3*3 + 4*1 = 22.
    //Given two arrays nums1 and nums2 of length n, return the minimum product sum if you are allowed to rearrange the order of the elements in nums1
    // 1 <= nums1[i], nums2[i] <= 100
    public static void main(String[] args) {
        int nums1[] = {5,3,4,2};
        int nums2[] = {4,2,2,5};
        System.out.println(minProductSum(nums1, nums2)); //output: 40
    }

    public static int minProductSum(int[] nums1, int[] nums2) {
        int res = 0;
        int count1[] = new int[100];
        int count2[] = new int[100];


        for (int i = 0; i < nums1.length; i++){
            count1[nums1[i]-1]++;
            count2[nums2[i]-1]++;
        }

        int p1 = 0;
        int p2 = 99;
        while (p1 < 100 && p2 >= 0){
            if (count1[p1] == 0){
                p1++;
            } else if (count2[p2] == 0){
                p2--;
            } else {
                int min = count1[p1] < count2[p2] ? count1[p1] : count2[p2];
                res += (p1+1) * (p2+1) * min;
                count1[p1] -= min;
                count2[p2] -= min;
            }
        }

        return res;
    }
}

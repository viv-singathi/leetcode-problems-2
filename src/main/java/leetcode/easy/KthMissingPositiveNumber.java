package leetcode.easy;

public class KthMissingPositiveNumber {
    //problem: Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
    //Return the kth positive integer that is missing from this array.
    public static void main(String[] args) {
        int arr[] = {2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5)); //output: 9
    }

    public static int findKthPositive(int[] arr, int k) {
        if (arr[arr.length-1] - arr.length < k){return k + arr.length; }
        if (k < arr[0]) {return k;}

        int l = 0;
        int u = arr.length-1;

        while (l <= u){
            int m = (l+u)/2;

            if (arr[m] - m <= k && k < arr[m+1] - m-1){
                return k + m+1;
            }

            if (arr[m] - m > k){
                u = m - 1;
            } else {
                l = m +1;
            }
        }

        return -1;
    }
}

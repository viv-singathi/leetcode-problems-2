package leetcode.medium;

public class PeakIndexInMountainArray {

    // problem:
    // You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease
    //Return the index of the peak element.

    public static void main(String[] args) {
        int arr[] = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr)); //output: 1
    }

    public static int peakIndexInMountainArray(int[] arr) {

        int s = 0;
        int e = arr.length - 1;

        while (s < e){
            int m = (e+s)/2;
            if (arr[m-1] < arr[m] && arr[m] > arr[m+1]){
                return m;
            }

            if (arr[m] < arr[m+1]){
                s = m + 1;
            } else {
                e = m;
            }
        }

        return -1;
    }
}

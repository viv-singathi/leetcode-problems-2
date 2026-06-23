package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    //problem: Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
    // The result should also be sorted in ascending order
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(findClosestElements(arr, 4,3)); //output: [1, 2, 3, 4]
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int u = arr.length - 1;
        int m = 0;

        List<Integer> res = new ArrayList<Integer>(k);

        while (l <= u){
            m = (l+u)/2;

            if (arr[m] == x){
                break;
            }

            if (arr[m] < x){
                l = m+1;
            } else {
                u = m-1;
            }
        }

        if (l > u){
            m = u;
        }

        l = Math.max(0, m - k);
        u = Math.min(m + k, arr.length-1);

        while (u - l >= k){
            if (Math.abs(arr[l] - x) <= Math.abs(arr[u] - x)){
                u--;
            } else {
                l++;
            }
        }

        for (int i = l; i <= u; i++){
            res.add(arr[i]);
        }

        return res;
    }
}

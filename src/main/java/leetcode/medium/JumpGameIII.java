package leetcode.medium;

public class JumpGameIII {
    //prroblem: Given an array of non-negative integers arr, you are initially positioned at start index of the array.
    // When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
    //Notice that you can not jump outside of the array at any time.
    public static void main(String[] args) {
        int arr[] = {4,2,3,0,3,1,2};
        System.out.println(canReach(arr, 5));//output: true
    }

    public static boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] == -1 ) {return false;}
        if (arr[start] == 0){return true;}
        int j = arr[start];
        arr[start] = -1;
        return canReach(arr, start - j) || canReach(arr, start+j);
    }
}

package leetcode.medium;

import java.util.Arrays;

public class KClosestPoint {
    //problem: Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
    // return the k closest points to the origin (0, 0)

    public static void main(String[] args) {
        int points[][] = {{3,3},{5,-1},{-2,4}};
        int closest[][] = kClosest(points, 2);

        for (int i = 0; i < closest.length; i++){
            System.out.println(Arrays.toString(closest[i]));
        }

        //output: [3, 3]
        //[-2, 4]
    }

    public static int[][] kClosest(int[][] points, int k) {
        int res[][] = new int[k][2];
        int l = points.length;

        for (int i = points.length-1; i >= 0; i--){
            downHeap(i, points, l);
        }


        for (int i = 0; i < k; i++){
            res[i] = pop(points, l);
            l--;
        }

        return res;
    }

    public static void swap(int arr[][], int i, int j){
        int tmp[] = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] pop(int arr[][], int len){
        int top[] = arr[0];
        arr[0] = arr[len-1];
        arr[len-1] = top;
        downHeap(0, arr, --len);
        return top;
    }

    public static void downHeap(int i, int nums[][], int len){
        if (2 * i + 1 >= len) {return;}

        int l = 2 * i + 1;
        int r = 2 * i + 2 < len ? 2 * i + 2 : 2 * i + 1;

        int L = nums[l][0] * nums[l][0] + nums[l][1] * nums[l][1];
        int R = nums[r][0] * nums[r][0] + nums[r][1] * nums[r][1];
        int I = nums[i][0] * nums[i][0] + nums[i][1] * nums[i][1];

        if (L <= R && L < I){
            swap(nums, i, l);
            downHeap(l, nums, len);
        } else if (R < I){
            swap(nums, i, r);
            downHeap(r, nums, len);
        }
    }


}

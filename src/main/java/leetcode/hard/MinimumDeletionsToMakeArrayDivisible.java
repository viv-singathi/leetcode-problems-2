package leetcode.hard;

public class MinimumDeletionsToMakeArrayDivisible {
    //problem: You are given two positive integer arrays nums and numsDivide. You can delete any number of elements from nums.
    //Return the minimum number of deletions such that the smallest element in nums divides all the elements of numsDivide.
    // If this is not possible, return -1.
    public static void main(String[] args) {
        int nums[] = {2,3,2,4,3};
        int numsDivide[] = {9,6,9,3,15};
        System.out.println(minOperations(nums, numsDivide)); //output: 2

    }

    public static int minOperations(int[] nums, int[] numsDivide) {
        int d = numsDivide[0];
        int l = nums.length;

        for (int i = 1; i < numsDivide.length; i++){
            d = gcd(d, numsDivide[i]);
        }

        for (int i = nums.length-1; i >= 0; i--){
            downHeap(nums, i, l);
        }

        for (int i = 0; i < nums.length; i++){
            if (d % removeMin(nums, l) == 0){return i;}
            l--;
        }

        return -1;
    }

    public static void swap(int h[], int i, int j){
        int tmp = h[i];
        h[i] = h[j];
        h[j] = tmp;
    }

    public static int removeMin(int h[], int len){
        if (len == 1){return h[0];}
        int min = h[0];
        swap(h, 0, len-1);

        downHeap(h, 0, len-1);
        return min;
    }

    public static void downHeap(int h[], int i, int len){
        if (2 * i + 1 >= len) {return;}

        int l =  2 * i + 1;
        int r = 2 * i + 2 < len ? 2 * i + 2 :  l-1;

        if (h[i] > h[l] && h[l] <= h[r]){
            swap(h, i, l);
            downHeap(h, l, len);
        } else if (h[i] > h[r]){
            swap(h, i, r);
            downHeap(h, r, len);
        }
    }

    public static int gcd(int x, int y){
        if (y == 1){return 1;}
        if (x % y == 0) {return y;}
        return gcd(y, x % y);
    }


}

package leetcode.medium;

public class KthLargestElement {
    //problem:
    //Given an integer array nums and an integer k, return the kth largest element in the array.
    //Note that it is the kth largest element in the sorted order, not the kth distinct element.
    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2)); //output: 5
    }

    public static int findKthLargest(int[] nums, int k) {
        for (int i = nums.length/2 - 1; i >= 0; i--){
            downHeap(i, nums, nums.length);
        }

        for (int i = 0; i < k-1; i++){
            pop(nums, nums.length - i);
        }

        return pop(nums, nums.length - k+1);
    }

    public static void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int pop(int arr[], int len){
        int top = arr[0];
        arr[0] = arr[len-1];
        arr[len-1] = top;
        downHeap(0, arr, --len);
        return top;
    }

    public static void downHeap(int i, int nums[], int len){
        if (2 * i + 1 >= len) {return;}

        int l = 2 * i + 1;
        int r = 2 * i + 2 < len ? 2 * i + 2 : 2 * i + 1;

        if (nums[l] >= nums[r] && nums[i] < nums[l]){
            swap(nums, i, l);
            downHeap(l, nums, len);
        } else if (nums[i] < nums[r]){
            swap(nums, i, r);
            downHeap(r, nums, len);
        }
    }
}

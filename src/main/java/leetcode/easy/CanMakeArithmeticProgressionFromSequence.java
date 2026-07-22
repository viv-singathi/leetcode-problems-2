package leetcode.easy;

public class CanMakeArithmeticProgressionFromSequence {
    //problem: A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
    //Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false

    public static void main(String[] args) {
        int arr[] = {3,5,1};
        System.out.println(canMakeArithmeticProgression(arr));//output: true

    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        int l = arr.length;

        for (int i = arr.length-1; i >= 0; i--){
            downHeap(arr, i, l);
        }

        int prev = removeMin(arr, l);
        int current = removeMin(arr, l-1);
        int diff = current - prev;
        l -=2;

        for (; l > 0; l--){
            prev = current;
            current = removeMin(arr, l);

            if (current - prev != diff){
                return false;
            }

        }

        return true;
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
}

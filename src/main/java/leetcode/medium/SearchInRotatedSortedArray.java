package leetcode.medium;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};

        System.out.println(search(nums, 4));
        System.out.println(search(nums, 7));
        //output:
        // 0
        // 3
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {return nums[0] == target ? 0 : -1;}

        int offset = findRotationOffset(nums);
        int i = offset + 1;
        int j = offset + nums.length;

        if (nums[i % nums.length] == target){
            return i % nums.length;
        }

        if (nums[j % nums.length] == target){
            return j % nums.length;
        }

        while (i < j - 1){
            int m = (i+j)/2;

            int m_idx = m % nums.length;

            if (nums[m_idx] == target){
                return m_idx;
            } else if (nums[m_idx] > target){
                j = m;
            } else {
                i = m;
            }

        }

        return -1;
    }

    public static int findRotationOffset(int nums[]){
        int i = 0;
        int j = nums.length -1;

        while (i < j -1){
            int m = (i+j)/2;

            if (m-1 > 0 && nums[m-1] > nums[m] ){
                return m-1;
            } else if (m+1 < nums.length && nums[m] > nums[m+1]){
                return m;
            }

            if (nums[m] > nums[i]){
                i = m;
            } else{
                j = m;
            }

        }

        return -1;
    }
}

package leetcode.easy;

public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        TreeNode r = sortedArrayToBST(arr);

        System.out.println(r.val + ", " + r.left.val + ", " + r.right.val); //output: 2, 1, 3

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int m = nums.length / 2;
        TreeNode parent = new TreeNode(nums[m]);
        createTree(0, m - 1, parent, nums);
        createTree(m + 1, nums.length - 1, parent, nums);

        return parent;

    }

    public static void createTree(int l, int u, TreeNode parent, int nums[]) {
        if (l > u) {
            return;
        }
        int m = (u + l) / 2;
        TreeNode n = new TreeNode(nums[m]);

        if (nums[m] > parent.val) {
            parent.right = n;
        } else {
            parent.left = n;
        }

        if (l != u) {
            createTree(l, m - 1, n, nums);
            createTree(m + 1, u, n, nums);
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

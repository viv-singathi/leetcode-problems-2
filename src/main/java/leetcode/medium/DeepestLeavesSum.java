package leetcode.medium;


public class DeepestLeavesSum {
    public static void main(String[] args) {
        //problem: Given the root of a binary tree, return the sum of values of its deepest leaves.
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(deepestLeavesSum(root)); //output: 6
    }

    static int MaxDepth = 0;
    static int S = 0;
    public static int deepestLeavesSum(TreeNode root) {
        S = 0;
        MaxDepth = 0;
        sum(root,0);
        return S;
    }

    public static void sum(TreeNode root, int d){
        if (root == null){return;}
        if (d > MaxDepth) {
            MaxDepth = d;
            S = 0;
        }
        if (d == MaxDepth){
            S += root.val;
        }

        sum(root.left, d+1);
        sum(root.right, d+1);
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

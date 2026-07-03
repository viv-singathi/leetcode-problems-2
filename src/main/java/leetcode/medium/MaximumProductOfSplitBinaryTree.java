package leetcode.medium;

public class MaximumProductOfSplitBinaryTree {
    //problem: Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
    //Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 10^9 + 7.
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println(maxProduct(root));//output: 110
    }

    public static int maxProduct(TreeNode root) {
        sum(root);
        return (int) (findMax(root.val, root) % 1000000007);
    }

    public static long findMax(long totalSum, TreeNode t){
        if (t == null){return 0;}
        long leftMax = findMax(totalSum, t.left);
        long rightMax = findMax(totalSum, t.right);
        long m = leftMax > rightMax ? leftMax : rightMax;
        long current = (long) (totalSum - t.val) * t.val;
        return current > m ? current : m;
    }

    public static int sum(TreeNode t){
        if (t == null){return 0;}
        t.val = sum(t.left) + sum(t.right) + t.val;
        return t.val;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}

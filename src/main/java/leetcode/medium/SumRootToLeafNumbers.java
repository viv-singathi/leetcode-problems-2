package leetcode.medium;

public class SumRootToLeafNumbers {

    public static  void main(String args[]){
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode root = new TreeNode(1, l, r);
        System.out.println(sumNumbers(root));
        //output: 25
    }

    static int s = 0;
    public static int sumNumbers(TreeNode root) {

        s = 0;
        sumTree(root, 0);

        return s;
    }

    public static void sumTree(TreeNode t, int currentSum){
        currentSum = currentSum * 10 + t.val;

        if (t.left != null){
            sumTree(t.left, currentSum);
        }
        if (t.right != null){
            sumTree(t.right, currentSum);
        }

        if (t.left == null && t.right == null){
            s += currentSum;
        }
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

package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String args[]){
        TreeNode root =  new TreeNode(3);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);

        root.left = l;
        root.right = r;
        r.right = rr;
        r.left = rl;

        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);

        //output: [[3], [9, 20], [15, 7]]

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        traverse(root, res, 0);

        return res;

    }

    public static void traverse(TreeNode n, List<List<Integer>> list, int level){
        if (n == null){return;}

        if (list.size() <= level){
            list.add(new ArrayList<Integer>());
        }

        list.get(level).add(n.val);

        if (n.left != null){
            traverse(n.left, list, level+1);
        }

        if (n.right != null){
            traverse(n.right, list, level+1);
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

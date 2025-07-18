package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);

        root.left = l;
        root.right = r;

        List<List<Integer>> res = pathSum(root, 3);

        for (List<Integer> list : res){
            System.out.println(list.toString());
        }

        //output: [1, 2]

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null){
            return res;
        }

        checkPathSums(res, new ArrayList<Integer>(), root, targetSum, 0);

        return res;
    }

    public static void checkPathSums(List<List<Integer>> res, List<Integer> currentPath, TreeNode r, int targetSum, int currentSum){

        currentSum += r.val;
        currentPath.add(r.val);

        if (r.left == null && r.right == null && targetSum == currentSum){
            res.add(new ArrayList<Integer>(currentPath));
        }

        if (r.left != null){
            checkPathSums(res, currentPath, r.left, targetSum, currentSum);
        }

        if (r.right != null){
            checkPathSums(res, currentPath, r.right, targetSum, currentSum);
        }

        currentPath.remove(currentPath.size()-1);
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

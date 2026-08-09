package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOderTraversal {
    //problem: Given the root of a binary tree, return the inorder traversal of its nodes' values.
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(inorderTraversal(root)); //output:[1, 2, 3]
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inOrder(res, root);
        return res;
    }

    public static void inOrder(List<Integer> res, TreeNode r){
        if (r == null){return;}
        inOrder(res, r.left);
        res.add(r.val);
        inOrder(res, r.right);
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

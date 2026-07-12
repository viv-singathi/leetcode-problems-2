package leetcode.medium;

import leetcode.easy.InvertBinaryTree;

public class BinaryTreePruning {
    //problem: Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
    //A subtree of a node is the node plus every node that is a descendant of it

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        pruneTree(root);
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null){return null;}
        if (!containsOne(root)){return null;}

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        return root;
    }

    public static boolean containsOne(TreeNode t){
        if (t == null){return false;}
        return t.val == 1 || containsOne(t.left) || containsOne(t.right);
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

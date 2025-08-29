package leetcode.easy;

import leetcode.medium.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> res = averageOfLevels(root);
        System.out.println(res.toString());

        //output: [3.0, 14.5, 11.0]
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        List<Double> nodes = new ArrayList<Double>();

        traverse(root, res, nodes, 0);

        for (int i = 0; i < res.size(); i++){
            res.set(i, res.get(i) / nodes.get(i));
        }

        return res;

    }

    public static void traverse(TreeNode r, List<Double> res, List<Double> nodes, int depth){
        if (r == null){
            return;
        }

        if (res.size() <= depth){
            res.add(0.0);
            nodes.add(0.0);
        }

        res.set(depth, res.get(depth) + r.val);
        nodes.set(depth, nodes.get(depth) + 1);

        traverse(r.left, res, nodes, depth+1);
        traverse(r.right, res, nodes, depth+1);
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

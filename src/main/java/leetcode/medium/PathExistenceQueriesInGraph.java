package leetcode.medium;

import java.util.Arrays;

public class PathExistenceQueriesInGraph {
    //problem: You are given an integer n representing the number of nodes in a graph, labeled from 0 to n - 1.
    //You are also given an integer array nums of length n sorted in non-decreasing order, and an integer maxDiff.
    //An undirected edge exists between nodes i and j if the absolute difference between nums[i] and nums[j] is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).
    //You are also given a 2D integer array queries. For each queries[i] = [ui, vi], determine whether there exists a path between nodes ui and vi.
    //
    //Return a boolean array answer, where answer[i] is true if there exists a path between ui and vi in the ith query and false otherwise

    public static void main(String[] args) {
        int arr[] = {2,5,6,8};
        int queries[][] = {{0,1},{0,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(pathExistenceQueries(4, arr, 2, queries)));
        //output: [false, false, true, true]
    }

    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int c = 0;
        int prev = nums[0];
        nums[0] = c;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] - prev <= maxDiff){
                prev = nums[i];
                nums[i] = c;
            } else {
                prev = nums[i];
                nums[i] = ++c;
            }
        }

        boolean res[] = new boolean [queries.length];

        for (int q = 0; q < queries.length; q++){
            int query[] = queries[q];
            res[q] = nums[query[0]] == nums[query[1]];
        }

        return res;
    }


}

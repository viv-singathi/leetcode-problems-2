package leetcode.easy;

import java.util.Arrays;

public class FindMissingRepeatedValues {
    //problem: You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears
    // exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.
    //Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b
    public static void main(String[] args) {
        int grid[][] = {{1,3},{2,2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid))); //output: [2, 4]
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int i = 0;
        int n = grid.length;
        int ans[] = new int[2];

        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                int num = grid[r][c];
                int nr = (num-1) / n;
                int nc = (num-1)  - nr * n;
                while (grid[nr][nc] != num){
                    int tmp = grid[nr][nc];
                    grid[r][c] = tmp;
                    grid[nr][nc] = num;
                    num = tmp;
                    nr = (num-1) / n;
                    nc = (num-1)  - nr * n;
                }
            }
        }

        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] != r * n + c + 1){
                    ans[0] = grid[r][c];
                    ans[1] = r * n + c + 1;
                    return ans;
                }
            }
        }

        return ans;
    }
}

package leetcode.medium;

public class MinPathSum {

    public static void main(String[] args) {
        int grid[][] = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(grid));
        //output: 7
    }
    public static int minPathSum(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        for (int j = 1; j < c; j++){
            grid[0][j] += grid[0][j-1];
        }

        for (int i = 1; i < r; i++){

            grid[i][0] += grid[i-1][0];

            for (int j = 1; j < c; j++){
                int above = grid[i-1][j];
                int prev = grid[i][j-1];

                grid[i][j] += above < prev ? above : prev;
            }
        }

        return grid[r-1][c-1];
    }

}

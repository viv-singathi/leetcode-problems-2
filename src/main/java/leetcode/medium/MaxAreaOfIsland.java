package leetcode.medium;

public class MaxAreaOfIsland {

    //problem: You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
    // You may assume all four edges of the grid are surrounded by water.
    //The area of an island is the number of cells with a value 1 in the island.
    //
    //Return the maximum area of an island in grid. If there is no island, return 0

    public static void main(String[] args) {
        int grid[][] = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid)); //output: 6
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int m = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                int a = sumArea(grid, i, j);
                m = a > m ? a : m;
            }
        }

        return m;
    }

    public static int sumArea(int grid[][], int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){return 0;}
        grid[i][j] = -1;
        return 1 + sumArea(grid, i + 1, j) + sumArea(grid, i - 1, j) + sumArea(grid, i, j+1) +sumArea(grid, i , j-1);
    }
}

package leetcode.medium;

import java.util.Arrays;

public class DifferenceBetweenOnesandZeros {
    //problem:
    //You are given a 0-indexed m x n binary matrix grid.
    //A 0-indexed m x n difference matrix diff is created with the following procedure:
    //Let the number of ones in the ith row be onesRowi.
    //Let the number of ones in the jth column be onesColj.
    //Let the number of zeros in the ith row be zerosRowi.
    //Let the number of zeros in the jth column be zerosColj.
    //diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
    //Return the difference matrix diff.

    public static void main(String[] args) {
        int mat[][] = {
                {0, 1, 1},
                {1, 0, 1},
                {0, 0, 1}
        };

        int res[][] = onesMinusZeros(mat);

       for (int i = 0; i < res.length; i++){
           System.out.println(Arrays.toString(res[i]));
       }
       //output:
        // [0, 0, 4]
        //[0, 0, 4]
        //[-2, -2, 2]
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int onesRow[] = new int[rows];
        int onesCol[] = new int[cols];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1){
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }

        int res[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                res[i][j] = onesRow[i] + onesCol[j] - (rows - onesRow[i]) - (cols - onesCol[j]);
            }
        }

        return res;
    }
}
